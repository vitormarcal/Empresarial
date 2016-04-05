drop database empresarial;
create database empresarial;
use empresarial;

insert into categoria (descricao) values ('Refrigerantes');
insert into categoria (descricao) values ('Computadores');
insert into categoria (descricao) values ('Notebooks');
insert into categoria (descricao) values ('tablests');
insert into categoria (descricao) values ('Monitores');
insert into categoria (descricao) values ('Impressoras');
insert into categoria (descricao) values ('Acessorios');
insert into produto (nome, sku, quantidade_estoque, valor_unitario, categoria_id) values ('Guaraná 2L', 'GUA00123', 10, 2.32, 1);
insert into usuario (nome, email, senha) values ('Maria', 'maria@abadia.com', '123');
insert into cliente (nome, email, tipo, doc_receita_federal) values ('Mercado do Tiao', 'mercado@tiao.com', 'JURIDICA', '10123123000101');

Insert into categoria (descricao) values ('Informática');
insert into categoria (descricao) values ('Eletrodomésticos');
insert into categoria (descricao) values ('Móveis');

insert into categoria (descricao, categoria_pai_id) values ('Computadores', 1);
insert into categoria (descricao, categoria_pai_id) values ('Notebooks', 1);
insert into categoria (descricao, categoria_pai_id) values ('Tablets', 1);
insert into categoria (descricao, categoria_pai_id) values ('Monitores', 1);
insert into categoria (descricao, categoria_pai_id) values ('Impressoras', 1);
insert into categoria (descricao, categoria_pai_id) values ('Acessórios', 1);

insert into categoria (descricao, categoria_pai_id) values ('Ar condicionados', 2);
insert into categoria (descricao, categoria_pai_id) values ('Fogões', 2);
insert into categoria (descricao, categoria_pai_id) values ('Fornos elétricos', 2);
insert into categoria (descricao, categoria_pai_id) values ('Microondas', 2);
insert into categoria (descricao, categoria_pai_id) values ('Refrigeradores', 2);

insert into categoria (descricao, categoria_pai_id) values ('Cadeiras', 3);
insert into categoria (descricao, categoria_pai_id) values ('Mesas', 3);
insert into categoria (descricao, categoria_pai_id) values ('Racks', 3);
insert into categoria (descricao, categoria_pai_id) values ('Sofás', 3);

INSERT INTO `empresarial`.`grupo` (`descricao`, `nome`) VALUES ('VENDEDORES', 'VENDEDORES');
INSERT INTO `empresarial`.`grupo` (`descricao`, `nome`) VALUES ('AUXILIARES', 'AUXILIARES');
INSERT INTO `empresarial`.`grupo` (`descricao`, `nome`) VALUES ('ADMINISTRADORES', 'ADMINISTRADORES');


INSERT INTO `empresarial`.`usuario` (`email`, `nome`, `senha`) VALUES ('vitormarcal8@gmail.com', 'vitor', 'vitor');
UPDATE `empresarial`.`usuario` SET `senha`='maria' WHERE `id`='1';
INSERT INTO `empresarial`.`usuario` (`email`, `nome`, `senha`) VALUES ('vendedor@vendedor.com', 'vendedor', 'vendedor');
INSERT INTO `empresarial`.`usuario` (`email`, `nome`, `senha`) VALUES ('auxiliar@auxiliar.com', 'auxiliar', 'auxiliar');

INSERT INTO `empresarial`.`usuario_grupo` (`usuario_id`, `grupo_id`) VALUES ('3', '1');
INSERT INTO `empresarial`.`usuario_grupo` (`usuario_id`, `grupo_id`) VALUES ('4', '2');
INSERT INTO `empresarial`.`usuario_grupo` (`usuario_id`, `grupo_id`) VALUES ('2', '3');
INSERT INTO `empresarial`.`usuario_grupo` (`usuario_id`, `grupo_id`) VALUES ('1', '1');
