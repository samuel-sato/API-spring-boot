# API REST para gerenciamanento de pessoas com Spring Boot
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Heroku](https://img.shields.io/badge/heroku-%23430098.svg?style=for-the-badge&logo=heroku&logoColor=white)


O projeto consiste no desenvolvimento de uma API Rest para gerenciamento de pessoas de uma empresa que possui diversos departamentos.
Possibilita a realização das principais atividades para gerenciamento de pessoas e departamentos.
## 🚀 Começando

Clone o projeto em sua máquina local e execute o seguinte comando na pasta do projeto:

### 📋 Pré-requisitos
Para executar o projeto, será necessário: 

- JDK 11:  https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html
- Apache Maven 3.6: https://maven.apache.org/download.cgi
- Intellij: https://www.jetbrains.com/pt-br/idea/download/#section=linux



### 🔧 Instalação

Para construir o projeto utilizando o Maven, execute o comando na pasta do projeto:
```
mvn clean install
```
O comando instalará as dependências para o funcionamento do projeto.

Para executar o projeto utilize o comando:

```
mvn spring-boot:run
```

Após executar o comando acima, o projeto pode ser visualizado a partir do endereço: 


```
http://localhost:8080/api/v1/people
```



## ⚙️ Deploy e publicação

Existe uma versão do projeto em funcionamento, hospedado pelo Heroku, a aplicação pode ser visualizada e testada no endereço:

```
https://peopleapi-live03.herokuapp.com
```

## 🔩 Funcionalidades

É possível:

- Cadastrar, editar e deletar uma pessoa
- Buscar todas as pessoas cadastradas
- Buscar pelo Id de uma pessoa
- Cadastrar e editar um departamento
- Buscar todos os departamentos cadastrados
- Buscar por Id de um departamento

### Cadastrar
Para cadastrar pessoa ou departamento utilize os endereços abaixo com o método POST, passando as respectivas informações no corpo da 
requisição usando JSON

#### Para cadastrar uma pessoa com o campo departmentID, é necessário antes cadastrar o departamento

| URI                     | Método | Descrição                         | Requisição   | Resposta     | Status  |
|-------------------------|--------|-----------------------------------|--------------|--------------|---------|
| /api/v1/people          | POST   | Cadastrar pessoa no sistema       | pessoa       | pessoa       | 200/404 |
| /api/v1/department      | POST   | Cadastrar departamento no sistema | departamento | departamento | 200/404 |


```
http://localhost:8080/api/v1/people
http://localhost:8080/api/v1/department
```

PESSOA EXEMPLO
```
{
    "firstName": "nome",
    "lastName": "sobrenome",
    "cpf": "00000000000",
    "birthDate": "23-11-1999",
    "departmentID": 1,
    "phones": [
        {
            "type": "MOBILE",
            "number": "(61)999999999"
        }
    ]
} 
```
DEPARTAMENTO EXEMPLO
```
{
    "name": "departamento",
    "description": "descrição departamento"   
}
```

### Editar

| URI                     | Método | Descrição                           | Requisição   | Resposta | Status  |
|-------------------------|--------|-------------------------------------|--------------|----------|---------|
| /api/v1/people/{id}     | PUT    | Edita pessoa definida pelo id       | Pessoa       | n/a      | 200/404 |
| /api/v1/department/{id} | PUT    | Edita departamento definido pelo id | Departamento | n/a      | 200/404 |

Exemplo
```
http://localhost:8080/api/v1/people/{id}
http://localhost:8080/api/v1/department/{id}
```

### Deletar


| URI                | Método | Descrição                         | Requisição | Resposta | Status  |
|--------------------|--------|-----------------------------------|------------|----------|---------|
| /api/v1/people/{id} | DELETE | Deleta pessoa com o respectivo id | n/a        | n/a      | 200/404 |

Exemplo
```
http://localhost:8080/api/v1/people/{id}
```
### Buscas


| URI                     | Método | Descrição                               | Requisição | Resposta               | Status  |
|-------------------------|--------|-----------------------------------------|------------|------------------------|---------|
| /api/v1/people          | GET    | Lista todas as pessoas do sistema       | n/a        | Lista de pessoas       | 200/404 |
| /api/v1/people/{id}     | GET    | Lista pessoa definida pelo id           | n/a        | Pessoa                 | 200/404 |
| /api/v1/department      | GET    | Lista todos os departamentos do sistema | n/a        | Lista de departamentos | 200/404 |
| /api/v1/department/{id} | GET    | Lista departamento definido pelo id     | n/a        | Departamento           | 200/404 |


## 🛠️ Construído com


* [Spring Boot](https://spring.io/projects/spring-boot) - O framework
* [Maven](https://maven.apache.org/) - Gerente de Dependência



---
