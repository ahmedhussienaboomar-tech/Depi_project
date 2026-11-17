# Depi Project

A software testing project built as part of the **DEPI** (Digital Egypt Pioneers Initiative) program. It combines UI test automation with Selenium and TestNG, together with API, database, and manual testing artifacts.

<!-- TODO: Replace the line below with the name/URL of the application under test -->
> **Application under test:** _add the website / app name and URL here_

---

## Tech Stack

| Category | Tool / Version |
|---|---|
| Language | Java 25 |
| Build tool | Maven |
| UI automation | Selenium WebDriver 4.44.0 |
| Test framework | TestNG 7.10.0 |
| IDE | IntelliJ IDEA |

---

## Project Structure

```
Depi_project/
├── api/        # API testing artifacts
├── database/   # Database testing artifacts
├── manual/     # Manual test cases and documentation
├── src/        # Selenium + TestNG automation source code
├── pom.xml     # Maven configuration and dependencies
└── .gitignore
```

<!-- TODO: Replace the descriptions above with the actual contents of each folder (e.g. Postman collection, SQL scripts, Excel test cases) -->

---

## Prerequisites

- **JDK 25** (the project is configured with `maven.compiler.source/target = 25`)
- **Apache Maven 3.9+**
- A recent version of **Google Chrome** (or the browser used in the tests)
- Git

---

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/ahmedhussienaboomar-tech/Depi_project.git
cd Depi_project
```

### 2. Install dependencies

```bash
mvn clean install -DskipTests
```

### 3. Run the tests

```bash
mvn test
```

<!-- TODO: If you use a testng.xml suite file, add: mvn test -DsuiteXmlFile=testng.xml -->

---

## Test Coverage

<!-- TODO: List the main test scenarios, for example: -->

- [ ] Login / Registration
- [ ] Search
- [ ] Cart / Checkout
- [ ] API endpoints validation
- [ ] Database validation

---

## Test Reports

TestNG generates HTML reports automatically after each run under:

```
target/surefire-reports/
```

Open `index.html` in a browser to view the results.

---

## Author

**Ahmed Hussien Aboomar**
GitHub: [@ahmedhussienaboomar-tech](https://github.com/ahmedhussienaboomar-tech)

---

## License

<!-- TODO: Add a license (e.g. MIT) or remove this section -->
This project is for educational purposes as part of the DEPI program.
