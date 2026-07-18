# 🔗 EncurtaLink

Um encurtador de URLs desenvolvido com **Java + Spring Boot**, permitindo gerar links curtos para URLs longas.

## 🚀 Tecnologias

- Java 21 
- Spring Boot
- Spring Web
- Spring Data JPA
- Banco de Dados - sqllite
- HTML5
- CSS3
- JavaScript

---

## 📂 Estrutura do Projeto

```
src
├── main
│   ├── java
│   │   └── api
│   │       └── encurtalk
│   │           ├── controller
│   │           │   ├── EncurtaLinksWebController.java
│   │           │   └── LinksController.java
│   │           │
│   │           ├── dto
│   │           │   └── LinkResponse.java
│   │           │
│   │           ├── entities
│   │           │   └── Links.java
│   │           │
│   │           ├── repository
│   │           │   └── LinksRepository.java
│   │           │
│   │           ├── service
│   │           │   └── EncurtarService.java
│   │           │
│   │           └── EncurtalkApplication.java
│   │
│   └── resources
│       ├── static
│       │   ├── styles.css
│       │   └── script.js
│       │
│       ├── templates
│       │   └── index.html
│       │
│       └── application.properties
```

---

## 📌 Arquitetura

O projeto segue a arquitetura em camadas utilizada no Spring Boot.

### Controller

Responsável por receber as requisições HTTP.

- **EncurtaLinksWebController**
    - Renderiza a página HTML (Thymeleaf).

- **LinksController**
    - Disponibiliza a API REST para criação dos links.

---

### DTO

Responsável pela transferência de dados entre cliente e servidor.

- **LinkResponse**
    - Retorna as informações do link criado.

---

### Entity

Representa a tabela do banco de dados.

- **Links**
    - id
    - linkOriginal
    - linkNovo
    - dataHora

---

### Repository

Camada de acesso aos dados.

- **LinksRepository**
    - Persistência utilizando Spring Data JPA.

---

### Service

Contém toda a regra de negócio.

- **EncurtarService**
    - Geração do código do link.
    - Persistência no banco.
    - Busca de URLs.
    - Redirecionamento.

---

## 🌐 Fluxo da Aplicação

```text
HTML
   │
   ▼
JavaScript (Fetch API)
   │
   ▼
LinksController
   │
   ▼
EncurtarService
   │
   ▼
LinksRepository
   │
   ▼
Banco de Dados
```

---

## 🔄 Fluxo de Encurtamento

```text
Usuário
   │
   ▼
Digita uma URL
   │
   ▼
JavaScript envia POST
   │
   ▼
/encurtar
   │
   ▼
Service gera código
   │
   ▼
Salva no banco
   │
   ▼
Retorna JSON
   │
   ▼
JavaScript renderiza o resultado
```

---

## 📡 Endpoints

### Criar Link

```
POST /encurtar
```

### Redirecionar

```
GET /r/{codigo}
```

---

## ▶️ Executando o Projeto

Clone o repositório

```bash
git clone https://github.com/seu-usuario/encurtalk.git
```

Entre na pasta

```bash
cd encurtalk
```

Execute

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

A aplicação estará disponível em

```
http://localhost:8080
```

---

## 📸 Interface

A interface foi construída utilizando:

- HTML
- CSS
- JavaScript

A comunicação com a API é feita utilizando a **Fetch API**, sem necessidade de recarregar a página.

---

## 📈 Melhorias Futuras

- Login de usuários
- Histórico de links
- QR Code

---

## 👨‍💻 Autor

Desenvolvido por **Cauã Evaristo da Cruz**.