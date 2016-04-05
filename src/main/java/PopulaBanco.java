import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vitormarcal.empresarial.model.Cliente;
import com.vitormarcal.empresarial.model.EnderecoEntrega;
import com.vitormarcal.empresarial.model.FormaPagamento;
import com.vitormarcal.empresarial.model.Pedido;
import com.vitormarcal.empresarial.model.StatusPedido;
import com.vitormarcal.empresarial.model.Usuario;

public class PopulaBanco {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmpresarialPU");
		EntityManager manager = factory.createEntityManager();

		for (int i = 1; i <= 2000; i++) {
			manager.getTransaction().begin();
			System.out.println(i);
			Long b = null;
			if (i % 2 == 0) {
				b = 1L;
				System.out.println("par");
			} else {
				b = 3L;
				System.out.println("impar");
			}
			adicionaPedido(manager, b);

			manager.getTransaction().commit();
		}

	}

	private static void adicionaPedido(EntityManager manager, Long b) {
		Pedido pedido = new Pedido();
		pedido.setCliente(manager.find(Cliente.class, b));
		pedido.setDataCriacao(new Date());
		pedido.setDataEntrega(new Date());
		pedido.setEnderecoEntrega(adcionaEndereco(b));
		pedido.setFormaPagamento(FormaPagamento.CARTAO_CREDITO);
		pedido.setStatus(StatusPedido.EMITIDO);
		pedido.setValorDesconto(BigDecimal.valueOf(35.80));
		pedido.setValorFrete(BigDecimal.valueOf(205.80));
		pedido.setValorTotal(BigDecimal.valueOf(8000.00));
		pedido.setVendedor(manager.find(Usuario.class, b));
		pedido.setObservacao("teste");
		manager.persist(pedido);
	}

	private static EnderecoEntrega adcionaEndereco(Long b) {
		EnderecoEntrega endereco = new EnderecoEntrega();
		endereco.setCep("722610"+b);
		endereco.setCidade("Ceilandia"+b);
		endereco.setLogradouro("teste"+b);
		endereco.setNumero("18"+b);
		endereco.setUf("DF");
		endereco.setComplemento("testesteste"+b);
		return endereco;

	}

}
