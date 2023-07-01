<div align="center">
 <img src="https://user-images.githubusercontent.com/111321384/225424307-c1475755-8810-4fd3-aa1f-64c7f67c6f65.png" />
 </div>

### Disciplina: Projeto e Arquitetura de Software
### Professor: [Glauco Scheffel](https://www.linkedin.com/in/glaucoscheffel/)


### Alunos: [Willian Mikhael da Cunha](https://www.linkedin.com/in/willianmikhael/) <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Vitor do Nascimento](https://www.linkedin.com/in/vitor-nascimento-126b73253)
  



#### 30/06/2023

#

## Para Entender um Pouco Sobre Este Projeto

### Sintese

<div>
Objetivo:
O objetivo deste projeto é codificar um encurtador de URL usando a linguagem JAVA. 
O sistema deve ser capaz de armazenar e recurperar as URLs encurtadas em um banco de dados,
implementar uma estratégia de cache para melhorar o desempenho, 
expor as funcionalidades através de um API Gateway e garantir a segurança por meio de autenticação utilizando API Key ou outra estratégia. 
Além disso, o projeto deve ser configurado para ser executado em um ambiente de contêiner, preferencialmente usando Docker, ou utilizando alternativas viáveis para Windows ou Linux.

Requisitos:

1. Codificação em JAVA: O sistema deve ser implementado utilizando a linguagem de programação JAVA.

2. Banco de Dados: Utilizar um banco de dados para armazenar as URLs encurtadas.

3. Estratégia de Cache: Implementar uma estratégia de cache para melhorar o desempenho do encurtador de URL.

4. API Gateway: Expor as funcionalidades do encurtador de URL através de um API Gateway.

5. Autenticação via API Key: Implementar um mecanismo de autenticação baseado em API Key para garantir a segurança das chamadas à API do encurtador de URL.

6. Contêiner: Configurar o projeto para ser executado em um ambiente de contêiner, preferencialmente usando Docker. Caso não seja possível usar Docker.

</div>

#

### O que é MVC ?

O MVC (Model-View-Controller) é um padrão de arquitetura de software amplamente adotado no desenvolvimento de aplicativos web. Ele separa as responsabilidades do aplicativo em três componentes principais: a Model, responsável pela lógica de negócios e gerenciamento de dados; a View, responsável pela apresentação da interface do usuário; e o Controller, responsável por gerenciar as interações do usuário e coordenar a comunicação entre a Model e a View. Essa separação ajuda a promover a modularidade, reutilização de código e facilita a manutenção do aplicativo, tornando-o mais organizado e escalável.

### O que é SpringBoot ?

O Spring Boot é um framework Java que simplifica o desenvolvimento de aplicativos robustos e prontos para produção, oferecendo configuração automática, servidor embutido e integração com o ecossistema Spring. Ele permite criar aplicativos independentes e facilita o gerenciamento de dependências, além de fornecer recursos avançados para monitoramento e métricas.

### Porque utilizar Redis ?

O Redis é um banco de dados em memória conhecido por sua alta velocidade, baixa latência e simplicidade de uso. Ele oferece recursos avançados, escalabilidade, persistência de dados e é frequentemente utilizado como cache em memória. A escolha do Redis depende dos requisitos do projeto e das necessidades de desempenho.

### 

### Porque utilizar H2 como banco de dados ?

As vantagens de utilizar o H2 em desenvolvimento e testes com o Spring Boot incluem:

- Configuração simples: O H2 é fácil de configurar com o Spring Boot, pois é necessário apenas adicionar a dependência correta no arquivo de configuração.

- Execução em memória: O H2 pode ser executado em modo de memória, o que significa que não é necessário configurar um servidor de banco de dados separado durante o desenvolvimento e testes. Isso torna o processo mais rápido e conveniente.

- Recursos de persistência: O H2 suporta recursos de persistência, como a criação de tabelas e execução de consultas SQL. Isso permite que você teste facilmente a camada de persistência do seu aplicativo durante o desenvolvimento.

#

# Funcionamento:

- Utilizamos o SpringBoot e por consequente o padrão MVC, onde renderizamos uma pagina HTML simples utilizando Thymeleaf dentro da **View**;
- Na **Controller** implementamos a lógica em **JAVA**, onde criamos as URLS encurtadas e armazenamos-as no banco de dados **H2** e no **REDIS**, bem como as URLS originais;


### 
<div align="center">
 <img src="https://github.com/willianmikhael/ShortURL_CatolicaSC/assets/111321384/103617a4-0b67-4a6f-a207-1075ee989f39.png" />
 </div>
 
 ## Instalação

Para o correto funcionamento da aplicação é necessário ter o [WSL2](https://learn.microsoft.com/pt-br/windows/wsl/install) intalado em seu computador, caso você esteja utilizando Windows.

Necessario ter o [Docker](https://www.docker.com/) instalado em seu computador.
Após isso, abra um terminal e  rode o seguinte comando:
 
 ```powershell
 Docker run -it --name redis -p 6379:6379 redis:5.0.3
 ```
 
 #### Atente-se para o arquivo *applications.properties*
 É nele que estão configurados a porta HTTP que sera acessada via **Tomcat** e a conexão com o **Redis**
 
 ```powershell
 server.port=5000

spring.cache.type=redis
spring.data.redis.host=localhost
spring.data.redis.port=6379
```

## TESTES:

### JMeter
