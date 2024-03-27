# Using Spring Boot Profiles

Spring Boot profiles provide a way to segregate parts of your application configuration and make it available only in certain environments. Profiles are useful for defining environment-specific configurations, such as development, testing, and production settings.

## Understanding Profiles

A profile is a named group of configuration settings. By activating a specific profile, you can apply its configurations to the application runtime.

## Defining Profiles

Profiles can be defined in various configuration files (`application.properties`, `application.yml`, or within Spring configuration classes).

### Example in `application.properties`

```properties
# Default configurations
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=password

# Development-specific configurations
spring.profiles.active=dev
spring.config.activate.on-profile=dev
spring.datasource.url=jdbc:h2:mem:devdb
```

### Example in `application.yml`

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    username: sa
    password: password

---

spring:
  profiles: dev
  datasource:
    url: jdbc:h2:mem:devdb
```

## Activating Profiles

Profiles can be activated in various ways, including through environment variables, JVM system properties, or command-line arguments.

### Command-Line Argument

```shell
java -jar myapp.jar --spring.profiles.active=dev
```

### Environment Variable

```shell
export SPRING_PROFILES_ACTIVE=dev
java -jar myapp.jar
```

### Application Properties or YAML

In `application.properties` or `application.yml`, set the `spring.profiles.active` property:

```yaml
spring:
  profiles:
    active: dev
```

## Creating Profile-specific Configuration Files

For more complex configurations, you can create profile-specific configuration files:

- `application-dev.properties` or `application-dev.yml` for development
- `application-test.properties` or `application-test.yml` for testing
- `application-prod.properties` or `application-prod.yml` for production

Spring Boot automatically loads the configurations from the profile-specific files along with the default `application.properties` or `application.yml`.

## Example Use Case

Consider a scenario where you want to use an in-memory H2 database for development and a PostgreSQL database for production. You can define the datasource configurations in `application-dev.yml` and `application-prod.yml`, and activate the appropriate profile during runtime.

**application-dev.yml:**

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:devdb
    driverClassName: org.h2.Driver
    username: sa
    password:
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
```

**application-prod.yml:**

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/proddb
    driverClassName: org.postgresql.Driver
    username: produser
    password: prodpass
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
```

By leveraging profiles, you can easily switch between different configurations without changing the code, simplifying development, testing, and deployment processes.