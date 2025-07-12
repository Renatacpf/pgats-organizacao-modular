# Projeto de Automação de Testes - Organização Modular (`pgats-organizacao-modular`)

Este projeto tem como objetivo demonstrar a automação de testes de interfaces web (UI) utilizando Selenium WebDriver com Java e Maven, com foco em uma estrutura de código organizada e modular, seguindo boas práticas de desenvolvimento e aplicando design patterns como Page Objects.

## 🚀 Funcionalidades Automatizadas

O projeto atualmente abrange a automação das seguintes funcionalidades em uma aplicação web de demonstração:

1.  **Cadastro de Usuário:**
    * Preenchimento de formulário de registro com dados válidos.
    * Validação do sucesso do cadastro.
2.  **Login de Usuário:**
    * Preenchimento de credenciais (usuário e senha).
    * Realização do login.
    * Validação do login bem-sucedido (verificação da página pós-login).

## 💡 Estrutura do Projeto e Boas Práticas

O projeto foi cuidadosamente estruturado para promover a modularidade, reusabilidade e fácil manutenção, seguindo os princípios de um framework de automação robusto:

* **Separação por Camadas:**
    * `pages/`: Contém as classes Page Objects (`LoginPage`, `CadastroPage`), que representam cada tela da aplicação e encapsulam seus elementos e as ações que podem ser realizadas nelas.
    * `tests/`: Contém as classes de teste (`LoginTest`, `CadastroTest`), que definem os cenários de teste e utilizam as Page Objects para interagir com a aplicação.
    * `utils/`: Contém funções auxiliares e utilitários, como `DataFactory` para geração de dados de teste e `DriverManager` para o gerenciamento do WebDriver.
    * `config/`: Contém a classe `Config` para armazenar parâmetros de configuração global, como a URL base da aplicação e o tipo de navegador.
    * `base/`: Contém a classe `BaseTest`, que serve como uma classe base para todos os testes, inicializando e finalizando o WebDriver (usando `DriverManager`) para cada cenário.

* **Design Patterns Aplicados:**
    * **Page Object Model (POM):** Implementado nas classes `LoginPage` e `CadastroPage`, garantindo que a lógica de interação com a UI esteja separada da lógica de teste.
    * **Singleton (implícito no DriverManager):** O `DriverManager` gerencia a instância do WebDriver, garantindo que haja uma única instância do driver por thread de execução, promovendo reuso e evitando problemas de concorrência.
    * **Factory (em DataFactory):** A classe `DataFactory` atua como uma fábrica para gerar dados de teste dinamicamente, tornando os testes mais flexíveis e reusáveis.

* **Separação por Domínio/Funcionalidade:**
    * As pastas e pacotes são organizados por funcionalidade (e.g., `login`, `cadastro`), agrupando Page Objects e Testes relacionados, o que melhora a clareza e a navegação no projeto.

* **Convenções e Padronizações:**
    * Nomes de arquivos e métodos são claros e descritivos, seguindo convenções de nomenclatura padrão em Java e para frameworks de automação (e.g., `preencherUsuario()`, `clicarNoBotaoLogin()`).
    * A estrutura de pastas segue uma hierarquia lógica e amplamente aceita na comunidade de automação.

## 🛠️ Tecnologias Utilizadas

* **Linguagem de Programação:** Java 11+
* **Ferramenta de Automação:** Selenium WebDriver
* **Gerenciador de Dependências:** Apache Maven
* **Framework de Testes:** JUnit 5 (Jupiter)
* **Gerenciamento de Drivers:** WebDriverManager
* **IDE:** IntelliJ IDEA (recomendado)

## 🌐 Aplicação de Teste

Este projeto utiliza o **Parabank** como aplicação web de demonstração:

* **URL Base:** `https://parabank.parasoft.com/parabank/index.htm`

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
    * **Via IDE:** Navegue até as classes `LoginTest.java` ou `CadastroTest.java` (em `src/test/java/tests/login/` e `src/test/java/tests/cadastro/`). Clique com o botão direito na classe e selecione `Run 'NomeDoTeste'`.
    * **Via Maven (Terminal):**
        * Para executar todos os testes:
            ```bash
            mvn clean test
            ```
        * Para executar um teste específico (ex: `CadastroTest`):
            ```bash
            mvn test -Dtest=CadastroTest
            ```

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

---
