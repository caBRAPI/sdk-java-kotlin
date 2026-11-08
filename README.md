# ☕ caBRAPI SDK for Java and Kotlin

Official SDK of **caBRAPI** for **Java** and **Kotlin**.

The SDK provides a modern, unified, and strongly typed interface for integration with all platform services. Designed for client and server applications, it reduces integration complexity, increases security, and provides a consistent development experience.

## 📚 Table of Contents

* [Installation](#-installation)
* [Getting Started](#-getting-started)
* [Authentication Modes](#-authentication-modes)
* [Configuration](#-configuration)
* [Available Modules](#-available-modules)
* [Requirements](#-requirements)
* [Build](#-build)
* [License](#-license)

---

# 📦 Installation

The SDK is distributed through **GitHub Packages**.

Before adding the dependency to your project, configure the Maven repository using a GitHub **Personal Access Token** with the `read:packages` permission.

## Maven

### `settings.xml`

```xml
<servers>
    <server>
        <id>github</id>
        <username>YOUR_GITHUB_USERNAME</username>
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
    <artifactId>sdk-java-kotlin</artifactId>
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
    implementation("br.com.cabrapi:sdk-java-kotlin:1.0.0")
}
```

---

# 🚀 Getting Started

## Server application (`PRIVATE`)

```java
import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;

caBRAPI api = new caBRAPI(
    new CoreClient.Options(CoreClient.Mode.PRIVATE)
        .apiKey("YOUR_API_KEY")
);
```

## Client application (`PUBLIC`)

```java
import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;

caBRAPI api = new caBRAPI(
    new CoreClient.Options(CoreClient.Mode.PUBLIC)
);
```

---

# 🔐 Authentication Modes

The SDK offers two authentication modes, allowing it to be used in both client and server applications.

| Mode      | Recommended for                                                     |
| --------- | ------------------------------------------------------------------- |
| `PUBLIC`  | Client applications that do not use an API key.                      |
| `PRIVATE` | Server applications that use an API key for authentication.         |

---

# 💻 Usage Examples

## 🔒 Server application (`PRIVATE`)

Ideal for administrative operations and protected access to API resources.

```java
import br.com.cabrapi.sdk.caBRAPI;
import br.com.cabrapi.sdk.client.CoreClient;
import br.com.cabrapi.sdk.model.store.*;

caBRAPI api = new caBRAPI(
    new CoreClient.Options(CoreClient.Mode.PRIVATE)
        .apiKey("YOUR_API_KEY")
);

// List stores
GetStoresResponse stores =
    api.stores().get(new GetStoresRequest(1, 10));

// Get a store
GetStoreByIdResponse store =
    api.stores().getById("store-id");

// Create a store
CreateStoreResponse created =
    api.stores().create(
        new CreateStoreRequest(StoreTemplate.PERSONALIZADO)
            .name("My Store")
    );
```

## 🌐 Client application (`PUBLIC`)

Ideal for web, desktop, and mobile applications.

```java
caBRAPI api = new caBRAPI(
    new CoreClient.Options(CoreClient.Mode.PUBLIC)
);

// List products
GetProductsResponse products =
    api.products().get(
        "store-id",
        new GetProductsRequest(1, 20)
    );

// Create payment
CreatePaymentResponse payment =
    api.payments().create(
        "store-id",
        new CreatePaymentRequest()
            .name("John Doe")
            .email("john@email.com")
            .gateway(PaymentCreateGateway.MERCADOPAGO_ORDER_PIX)
    );
```

It is also possible to use Asaas as a payment gateway:

```java
// Create payment via Asaas (PIX)
CreatePaymentResponse payment =
    api.payments().create(
        "store-id",
        new CreatePaymentRequest()
            .name("John Doe")
            .email("john@email.com")
            .gateway(PaymentCreateGateway.ASAAS_ORDER_PIX)
    );
```

---

# ⚙️ Configuration

## `CoreClient.Options`

| Property | Type              |        Required        | Description                                                  |
| -------- | ----------------- | :--------------------: | ------------------------------------------------------------ |
| `mode`   | `CoreClient.Mode` |             ✅          | Defines the authentication mode (`PUBLIC` or `PRIVATE`).      |
| `apiKey` | `String`          | Only in `PRIVATE` mode | API key used to authenticate requests.                       |

---

# 📦 Available Modules

| Module        | Class              |
| ------------- | ------------------ |
| 🏪 Stores     | `StoresModule`     |
| 📦 Products   | `ProductsModule`   |
| 📁 Categories | `CategoriesModule` |
| 🎫 Coupons    | `CouponsModule`    |
| 💳 Payments   | `PaymentsModule`   |
| 📄 Pages      | `PagesModule`      |
| 🔗 Webhooks   | `WebhooksModule`   |

---

# ☕ Requirements

| Technology | Version           |
| ---------- | ----------------- |
| Java       | **8 or higher**   |

---

# 🔨 Build

Clone the repository:

```bash
git clone https://github.com/caBRAPI/sdk-java-kotlin.git
```

Access the project directory:

```bash
cd sdk-java-kotlin
```

Build the SDK:

```bash
mvn clean install
```

---

# 📄 License

This project is distributed under the **Apache License 2.0** license.