# Projeto de Automação de Testes - Organização Modular (`pgats-organizacao-modular`)

Este projeto tem como objetivo demonstrar a automação de testes de interfaces web (UI) utilizando Selenium WebDriver com Java e Maven, com foco em uma estrutura de código organizada e modular, seguindo boas práticas de desenvolvimento e aplicando design patterns como Page Objects.

## 🚀 Funcionalidades Automatizadas

O projeto atualmente abrange a automação das seguintes funcionalidades na aplicação web de demonstração [Automation Exercise](https://www.automationexercise.com/):

1.  **Registro de Usuário (Test Case 1: Register User):**
    * Navegação e verificação da visibilidade da Home Page.
    * Clique no botão 'Signup / Login' e verificação da visibilidade de 'New User Signup!'.
    * **Geração dinâmica de nome, e-mail e senha de usuário.**
    * Preenchimento de nome e e-mail para registro inicial e clique no botão 'Signup'.
    * Verificação da visibilidade de 'ENTER ACCOUNT INFORMATION' e preenchimento de detalhes da conta (Título, Data de Nascimento **obtidos de arquivo YAML**).
    * Seleção de checkboxes de newsletter e ofertas.
    * Preenchimento de detalhes de endereço (Nome, Sobrenome, Empresa, Endereços, País, Estado, Cidade, CEP, Número de Celular **obtidos de arquivo YAML**).
    * Clique no botão 'Create Account' e verificação da visibilidade de 'ACCOUNT CREATED!'.
    * Clique no botão 'Continue' e verificação de que 'Logged in as username' está visível.
    * Clique no botão 'Delete Account', verificação da visibilidade de 'ACCOUNT DELETED!', e clique em 'Continue'.

2.  **Login de Usuário:**
    * Navegação e verificação da visibilidade da Home Page.
    * Clique no botão 'Signup / Login'.
    * Preenchimento de credenciais (e-mail e senha) na seção de login.
        * **Teste de Sucesso:** Credenciais válidas **obtidas de arquivo YAML**.
        * **Teste de Falha:** Credenciais inválidas **obtidas de arquivo YAML**.
    * Realização do login.
    * Verificação do login bem-sucedido ('Logged in as username' visível).
    * Teste de falha de login com credenciais inválidas e verificação da mensagem de erro **(obtida de arquivo YAML)**.
    * **Observação:** O teste de login bem-sucedido inclui a exclusão da conta para garantir a limpeza do ambiente após a execução.

## 💡 Estrutura do Projeto e Boas Práticas

O projeto foi cuidadosamente estruturado para promover a modularidade, reusabilidade e fácil manutenção, seguindo os princípios de um framework de automação robusto e a estrutura sugerida em sala de aula.

### Estrutura de Pastas Principal:

Abaixo está a estrutura de pastas do projeto, que reflete a organização modular e a separação por camadas:
```
.
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── config/         # Configurações gerais e gerenciamento do WebDriver
│   │       │   ├── Config.java
│   │       │   └── DriverManager.java # Se o DriverManager.java foi mantido e usado
│   │       └── utils/          # Utilitários diversos
│   │           ├── DataFactory.java  # Para geração de dados dinâmicos
│   │           └── TestDataLoader.java # Para carregamento de dados de teste de arquivos YAML
│   └── test/
│       └── java/
│           ├── base/           # Classes base para os testes
│           │   └── BaseTest.java
│           ├── resources/      # Arquivos de recursos, como dados de teste YAML
│           │   └── testdata.yaml
│           └── tests/          # Testes e Page Objects agrupados por funcionalidade
│               ├── register/   # Funcionalidade de Registro de Usuário
│               │   ├── HomePage.java
│               │   ├── SignupLoginPage.java
│               │   ├── AccountInformationPage.java
│               │   ├── AccountDetailsPage.java
│               │   ├── AccountCreatedPage.java
│               │   └── RegisterUserTest.java
│               └── login/      # Funcionalidade de Login de Usuário
│                   ├── LoginPage.java
│                   └── LoginTest.java
├── pom.xml
└── README.md
```
### Detalhes da Organização:

* **Separação por Camadas:**
    * `tests/register/` e `tests/login/`: Contêm tanto as classes de teste (`RegisterUserTest`, `LoginTest`) quanto as suas respectivas Page Objects (`HomePage`, `SignupLoginPage`, `AccountInformationPage`, `AccountDetailsPage`, `AccountCreatedPage`, `LoginPage`). Esta organização agrupa tudo que é específico de uma funcionalidade em um único local, facilitando a navegação e manutenção.
    * `config/`: Armazena configurações globais (`Config.java`) e o gerenciador do WebDriver (`DriverManager.java`).
    * `utils/`: Inclui utilitários como `DataFactory` para geração de dados de teste e `TestDataLoader` para carregar dados de arquivos externos.
    * `base/`: Contém a classe `BaseTest`, que é a base para todos os testes, cuidando da inicialização e finalização do WebDriver.
    * `resources/`: Novo diretório para armazenar arquivos de dados de teste externos, como `testdata.yaml`.

* **Design Patterns Aplicados:**
    * **Page Object Model (POM):** Implementado nas diversas Page Objects, garantindo que a lógica de interação com a UI esteja separada da lógica de teste.
    * **Singleton (implícito no DriverManager):** O `DriverManager` gerencia a instância do WebDriver.
    * **Factory (em DataFactory):** A classe `DataFactory` atua como uma fábrica para gerar dados de teste dinamicamente.
    * **Data Driven (com YAML):** Os dados de teste fixos agora são lidos de arquivos YAML, tornando os testes mais flexíveis e fáceis de manter.

* **Convenções e Padronizações:**
    * Nomes de arquivos e métodos são claros e descritivos.
    * A estrutura de pastas segue a hierarquia lógica e padronizada conforme as diretrizes do curso.

## 🛠️ Tecnologias Utilizadas

* **Linguagem de Programação:** Java 11+
* **Ferramenta de Automação:** Selenium WebDriver
* **Gerenciador de Dependências:** Apache Maven
* **Framework de Testes:** JUnit 5 (Jupiter)
* **Gerenciamento de Drivers:** WebDriverManager
* **Processamento YAML:** SnakeYAML (adicionado ao `pom.xml`)
* **IDE:** IntelliJ IDEA (recomendado)

## 🌐 Aplicação de Teste

Este projeto utiliza o **Automation Exercise** como aplicação web de demonstração:

* **URL Base:** `https://www.automationexercise.com/`

## ⚙️ Pré-requisitos

Antes de executar os testes, certifique-se de ter o seguinte instalado:

* **Java Development Kit (JDK) 11** ou superior.
* **Apache Maven** (geralmente incluído com IDEs como o IntelliJ).
* Um navegador web compatível (e.g., Google Chrome), pois o WebDriverManager fará o download automático do driver necessário.

## ▶️ Como Executar os Testes

1.  **Clonar o Repositório:**
    ```bash
    git clone [https://github.com/SEU_USUARIO_GITHUB/pgats-organizacao-modular.git](https://github.com/SEU_USUARIO_GITHUB/pgats-organizacao-modular.git)
    cd pgats-organizacao-modular
    ```
    (Substitua `SEU_USUARIO_GITHUB` pelo seu nome de usuário do GitHub).

2.  **Configurar o Projeto no IntelliJ IDEA (ou sua IDE preferida):**
    * Abra o IntelliJ IDEA.
    * Vá em `File` -> `Open...` e selecione o diretório raiz do projeto (`pgats-organizacao-modular`).
    * O IntelliJ deve reconhecer o `pom.xml` e importar o projeto Maven automaticamente. Se não, clique com o botão direito no `pom.xml` e selecione `Maven` -> `Reload Project`.

3.  **Executar os Testes:**
    * **Via IDE:** Navegue até as classes `RegisterUserTest.java` ou `LoginTest.java` (em `src/test/java/tests/register/` e `src/test/java/tests/login/`). Clique com o botão direito na classe e selecione `Run 'NomeDoTeste'`.
    * **Via Maven (Terminal):**
        * Para executar todos os testes:
            ```bash
            mvn clean test
            ```
        * Para executar um teste específico (ex: `RegisterUserTest`):
            ```bash
            mvn test -Dtest=RegisterUserTest
            ```

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.