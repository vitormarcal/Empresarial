package com.vitormarcal.empresarial.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.vitormarcal.empresarial.model.Cliente;
import com.vitormarcal.empresarial.repository.filter.ClienteFilter;
import com.vitormarcal.empresarial.service.NegocioException;
import com.vitormarcal.empresarial.util.jpa.Transactional;

public class Clientes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Cliente guardar(Cliente cliente){
		return manager.merge(cliente);
	}
	
	@Transactional
	public void remover(Cliente cliente) {
		try {
			cliente = porId(cliente.getId());
			manager.remove(cliente);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Cliente não pode ser excluído.");
		}
	}
	
	public Cliente porId(Long id) {
		return this.manager.find(Cliente.class, id);
	}
	
	public List<Cliente> porNome(String nome) {
		return this.manager.createQuery("from Cliente " +
				"where upper(nome) like :nome", Cliente.class)
				.setParameter("nome", nome.toUpperCase() + "%")
				.getResultList();
	}

	public Cliente porDocumentoReceitaFederal(String documentoReceitaFederal) {
		try {
			return this.manager.createQuery("from Cliente where upper(documentoReceitaFederal)"
					+ " like :documentoReceitaFederal",Cliente.class)
					.setParameter("documentoReceitaFederal", documentoReceitaFederal.toUpperCase())
					.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}	
	
	@SuppressWarnings("unchecked")
	public List<Cliente> filtrados(ClienteFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Cliente.class);
		
		if((!(null==filtro.getId()))){
			criteria.add(Restrictions.eq("id", filtro.getId()));
		}
		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(filtro.getDocumentoReceitaFederal())){
			criteria.add(Restrictions.eq("documentoReceitaFederal", filtro.getDocumentoReceitaFederal()));
		}
		return criteria.addOrder(Order.asc("nome")).list();
	}

	
}