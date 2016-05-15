# Empresarial
Sistema Comercial de Pedidos de Venda

Tecnologias ultilizadas:

    JAVA, Persistência com  JPA (com Hibernate),
    JSF (com abiblioteca de componentes Primefaces),
    CDI,
    Relatórios com IReport,
    Envio de Emails com JavaMail,
    Spring Security.


Como algumas pessoas estão tendo dificuldades de rodar o projeto, vai a dica: 

    Antes de tentar entrar com o usuário e senha que consta no arquivo de carga, tente executar o arquivo java TestaConexao. Como a aplicação vai validar o usuário, sem algum usuário no banco de dados? Então este arquivo - TestaConexao- irá abrir uma conexão e criar as tabelas, se não existem. 
    Feito isto, podem rodar o arquivo carga.sql e usar o usuário que lá foi adicionado. Ou simplesmente crie um usuário.

