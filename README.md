# Empresarial
Sistema Comercial JAVA com JPA, JSF, CDI, Primefaces e Spring Security.

Como algumas pessoas estão tendo dificuldades de rodar o projeto, vai a dica: antes de tentar entrar com o usuário e senha que consta no arquivo de carga, tente executar o arquivo java TestaConexao. Como a aplicação vai validar o usuário, sem algum usuário no banco de dados? Então este arquivo - TestaConexao- irá abrir uma conexão e criar as tabelas, se não existem. 
Feito isto, podem rodar o arquivo carga.sql e usar o usuário que lá foi adicionado. Ou simplesmente crie um usuário.

