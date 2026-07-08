# Hands on 4 — Spring Core: Load Country from Spring Configuration XML

## Objective
An airlines website needs a drop-down of countries with their two-character ISO code.
This data is stored in a Spring XML configuration file and read using
`ClassPathXmlApplicationContext`.

## Project structure
```
hands-on-4/
├── pom.xml
└── src
    ├── main
    │   ├── java/com/cognizant/springlearn
    │   │   ├── SpringLearnApplication.java   # main() + displayCountry()
    │   │   └── Country.java                  # bean: code, name, logging in ctor/getters/setters
    │   └── resources
    │       ├── application.properties        # logging config
    │       └── country.xml                   # Spring bean definition for "country"
    └── test
        └── java/com/cognizant/springlearn
            └── SpringLearnApplicationTests.java
```

## Key files

**country.xml** — defines the `country` bean via setter injection:
```xml
<bean id="country" class="com.cognizant.springlearn.Country">
    <property name="code" value="IN" />
    <property name="name" value="India" />
</bean>
```

**Country.java** — POJO with `code` and `name`, a no-arg constructor (required by Spring
for setter injection) and getters/setters, each logging a debug message.

**SpringLearnApplication.java** — `displayCountry()`:
```java
ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
Country country = context.getBean("country", Country.class);
LOGGER.debug("Country : {}", country.toString());
```
This is invoked from `main()` after the Spring Boot app starts.

## How to build & run

```bash
cd hands-on-4
mvn clean package
mvn spring-boot:run
```

or:

```bash
java -jar target/spring-learn-0.0.1-SNAPSHOT.jar
```

## What happens when `context.getBean()` is invoked
1. `ClassPathXmlApplicationContext` parses `country.xml` from the classpath.
2. Spring instantiates `Country` via its no-arg constructor (you'll see
   "Inside Country Constructor." in the debug log).
3. Spring calls the setters (`setCode`, `setName`) to inject the property values —
   each setter call is logged.
4. `context.getBean("country", Country.class)` returns the fully configured singleton instance.

## Expected console output (debug level)
```
...|DEBUG|...Country              |<init>                  |Inside Country Constructor.
...|DEBUG|...Country              |setCode                 |Inside setCode() - setting code: IN
...|DEBUG|...Country              |setName                 |Inside setName() - setting name: India
...| INFO|...SpringLearnApplication|displayCountry          |START
...|DEBUG|...SpringLearnApplication|displayCountry          |Country : Country [code=IN, name=India]
...| INFO|...SpringLearnApplication|displayCountry          |END
```

## Notes for SME walkthrough
- `<bean>` tag: `id` (bean name used to look it up), `class` (fully qualified class name Spring instantiates)
- `<property>` tag: `name` (setter to call, e.g. `name="code"` → `setCode()`), `value` (literal value to inject)
- `ApplicationContext` — the central Spring IoC container interface
- `ClassPathXmlApplicationContext` — loads bean definitions from an XML file on the classpath
- `context.getBean()` — triggers instantiation (if not already cached) and dependency injection,
  then returns the bean instance, cast/typed to the class you request
