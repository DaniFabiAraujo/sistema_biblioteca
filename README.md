# Projeto Biblioteca 

# Sobre o projeto


Projeto Biblioteca é uma aplicação a fim de teste e estudos e o objetivo é permitir o gerenciamento de livros de uma biblioteca.

A aplicação deverá permitir que usuários acessem o sistema através de uma página Web com login e senha e fazer a reserva de livros. Deverá ter controle de níveis de acesso.

# Tecnologias utilizadas
## Back end
- Java 
- Spring Web
- Sprin Boot
- Spring Security
- JPA / Hibernate
- Maven
## Front end
- HTML - Thymeleaf Framework
- Estilização: CSS , Bootstrap 

# Como executar o projeto
1° passo - Instalando o Spring Tool Suite
O Spring Tool Suite (STS) é uma IDE baseada em Eclipse. Existem versões do STS para Linux, Mac e Windows. Você pode baixar em: http://spring.io/tools/sts/all.
Esse não é um pré-requisito para rodar projetos Spring Boot, pois é possível utilizar qualquer IDE que dê suporte ao Maven. Inclusive um site interessante para aqueles que forem utilizar outras IDEs é o http://start.spring.io. Ele ajuda na criação de um novo projeto Spring Boot quase que da mesma forma que o STS.

## Configurando O Spring Tool Suite (STS) para rodar o projeto

## 2° Passo - Clonando o repositório
git clone https://github.com/DaniFabiAraujo/sistema_biblioteca
-Abra Git Bash.
-Altere o diretório de trabalho atual para o local desejado.
-Digite git clone e cole a URL que você copiou anteriormente.
$ git clone https://github.com/DaniFabiAraujo/sistema_biblioteca
-Pressione Enter para criar seu clone local.

## 3° Passo - inicializando o projeto
Abra a IDE e escolha o local (workspace) do projeto.
![Selecionandp o projeto](https://github.com/DaniFabiAraujo/Assets/blob/main/select-workspace.png) 

Escolha a opção de Import projects> Maven > Existing Maven Projects
![Impotando Projeto](https://github.com/DaniFabiAraujo/Assets/blob/main/import_maven_project.png)
Marque o arquivo pom.xml no checbox.
Após concluir a importação, abra a classe main e execute o projeto. conforme imagem abaixo:
![Executando a aplicação](https://github.com/DaniFabiAraujo/Assets/blob/main/run-application.png)

### obs: Na Classe PopulaBD estão dispostos os inserts necessários para acesso ao Sistema. Sempre que o programa é executado, essa classe é chamada para popular o banco. Portanto, depois que rodar a primeira vez e achar necessário pode comentar o código (para evitar erro de duplicação de chaves no banco). Mas se tiver o acesso ao MSQL Workbench é só apagar as tabelas e executar normalmente. Nessa classe também é possível visualizar as credenciais de login de usuarios para acesso ao sistema. Imagem Abaixo:
![Credenciais Usuários na classe PopulaBD](https://github.com/DaniFabiAraujo/Assets/blob/main/user-credencials.png)

Após concluir a build, acesse o endereço LOCALHOST:8080, no Browser: 
![acessando a aplicação Web ](https://github.com/DaniFabiAraujo/Assets/blob/main/localhost.png)
## Back end
Pré-requisitos: Java 11
Banco de dados utilizado: MYSQL


# Autor

Daniel Araujo



