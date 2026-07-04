# ☕ SDK da caBRAPI para Java e Kotlin

SDK oficial da **caBRAPI** para **Java** e **Kotlin**.

O SDK fornece uma interface moderna, unificada e fortemente tipada para integração com todos os serviços da plataforma. Projetado para aplicações cliente e servidor, ele reduz a complexidade da integração, aumenta a segurança e oferece uma experiência de desenvolvimento consistente.

## 📚 Índice

* [Instalação](#-instalação)
* [Primeiros passos](#-primeiros-passos)
* [Modos de autenticação](#-modos-de-autenticação)
* [Configuração](#-configuração)
* [Módulos disponíveis](#-módulos-disponíveis)
* [Requisitos](#-requisitos)
* [Compilação](#-compilação)
* [Licença](#-licença)

---

# 📦 Instalação

O SDK é distribuído por meio do **GitHub Packages**.

Antes de adicionar a dependência ao projeto, configure o repositório Maven utilizando um **Personal Access Token** do GitHub com a permissão `read:packages`.

## Maven

### `settings.xml`

```xml
<servers>
    <server>
        <id>github</id>
        <username>SEU_USUARIO_GITHUB</username>
        <password>${env.GITHUB_TOKEN}</password>
    </server>
</servers>
```

### `pom.xml`

```xml
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/caBRAPI/sdk-java-kotlin</url>
    </repository>
</repositories>

<dependency>
    <groupId>br.com.cabrapi</groupId>
    <artifactId>cabrapi-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Gradle

```groovy
repositories {
    maven {
        url = uri("https://maven.pkg.github.com/caBRAPI/sdk-java-kotlin")

        credentials {
            username = project.findProperty("gpr.user")
                    ?: System.getenv("GITHUB_USER")

            password = project.findProperty("gpr.key")
                    ?: System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    implementation("br.com.cabrapi:cabrapi-sdk:1.0.0")
}
```

---

# 🚀 Primeiros passos

## Aplicação servidor (`PRIVATE`)

```java
import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;

caBRAPI api = new caBRAPI(
    new CoreClient.Options(CoreClient.Mode.PRIVATE)
        .apiKey("SUA_API_KEY")
);
```

## Aplicação cliente (`PUBLIC`)

```java
import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;

caBRAPI api = new caBRAPI(
    new CoreClient.Options(CoreClient.Mode.PUBLIC)
);
```

---

# 🔐 Modos de autenticação

O SDK oferece dois modos de autenticação, permitindo sua utilização tanto em aplicações cliente quanto em aplicações servidor.

| Modo      | Indicado para                                                    |
| --------- | ---------------------------------------------------------------- |
| `PUBLIC`  | Aplicações cliente que não utilizam chave de API.                |
| `PRIVATE` | Aplicações servidor que utilizam chave de API para autenticação. |

---

# 💻 Exemplos de uso

## 🔒 Aplicação servidor (`PRIVATE`)

Ideal para operações administrativas e acesso protegido aos recursos da API.

```java
import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.model.store.*;

caBRAPI api = new caBRAPI(
    new CoreClient.Options(CoreClient.Mode.PRIVATE)
        .apiKey("SUA_API_KEY")
);

// Listar lojas
GetStoresResponse stores =
    api.stores().get(new GetStoresRequest(1, 10));

// Buscar uma loja
GetStoreByIdResponse store =
    api.stores().getById("store-id");

// Criar uma loja
CreateStoreResponse created =
    api.stores().create(
        new CreateStoreRequest(StoreTemplate.PERSONALIZADO)
            .name("Minha Loja")
    );
```

## 🌐 Aplicação cliente (`PUBLIC`)

Ideal para aplicações web, desktop e dispositivos móveis.

```java
caBRAPI api = new caBRAPI(
    new CoreClient.Options(CoreClient.Mode.PUBLIC)
);

// Listar produtos
GetProductsResponse products =
    api.products().get(
        "store-id",
        new GetProductsRequest(1, 20)
    );

// Criar pagamento
CreatePaymentResponse payment =
    api.payments().create(
        "store-id",
        new CreatePaymentRequest()
            .name("João Silva")
            .email("joao@email.com")
            .gateway(PaymentCreateGateway.MERCADOPAGO_SERVICE_PIX)
    );
```

---

# ⚙️ Configuração

## `CoreClient.Options`

| Propriedade | Tipo              |        Obrigatório       | Descrição                                                 |
| ----------- | ----------------- | :----------------------: | --------------------------------------------------------- |
| `mode`      | `CoreClient.Mode` |             ✅            | Define o modo de autenticação (`PUBLIC` ou `PRIVATE`).    |
| `apiKey`    | `String`          | Apenas no modo `PRIVATE` | Chave de API utilizada para autenticação das requisições. |

---

# 📦 Módulos disponíveis

| Módulo        | Classe             |
| ------------- | ------------------ |
| 🏪 Lojas      | `StoresModule`     |
| 📦 Produtos   | `ProductsModule`   |
| 📁 Categorias | `CategoriesModule` |
| 🎫 Cupons     | `CouponsModule`    |
| 💳 Pagamentos | `PaymentsModule`   |
| 📄 Páginas    | `PagesModule`      |
| 🔗 Webhooks   | `WebhooksModule`   |

---

# ☕ Requisitos

| Tecnologia | Versão            |
| ---------- | ----------------- |
| Java       | **8 ou superior** |

---

# 🔨 Compilação

Clone o repositório:

```bash
git clone https://github.com/caBRAPI/sdk-java-kotlin.git
```

Acesse o diretório do projeto:

```bash
cd sdk-java-kotlin
```

Compile o SDK:

```bash
mvn clean install
```

---

# 📄 Licença

Este projeto é distribuído sob a licença **Apache License 2.0**.
