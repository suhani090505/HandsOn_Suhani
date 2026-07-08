# Hands-on 1: Employee List REST Service

Implements:
- **Create static employee list data using spring xml configuration** — `src/main/resources/employee.xml`
- **Create REST service to get all employees** — `EmployeeDao` → `EmployeeService` → `EmployeeController`

## Project structure

```
src/main/java/com/training/employeeapp/
├── EmployeeAppApplication.java   Spring Boot entry point (@ImportResource employee.xml)
├── model/
│   └── Employee.java              id, name, department, skills
├── dao/
│   └── EmployeeDao.java           static EMPLOYEE_LIST, loaded from employee.xml
├── service/
│   └── EmployeeService.java       @Service, @Transactional getAllEmployees()
└── controller/
    └── EmployeeController.java    GET /employees
src/main/resources/
├── employee.xml                   2 departments, 4 employees, reused skill lists
└── application.properties
```

## employee.xml contents

- Two departments: `Engineering`, `Database Administration`
- Four `Employee` beans (`employee1`..`employee4`), each assigned to one of the
  departments above
- Three reusable skill lists (`javaSkills`, `frontendSkills`, `dbSkills`) shared
  across employees instead of duplicating skill values per employee
- All four employees collected into the `employeeList` bean (an `ArrayList`),
  which `EmployeeDao` reads

## Run

```bash
mvn spring-boot:run
```

## Test

```bash
curl http://localhost:8080/employees
```

Expected response:
```json
[
  { "id": 1, "name": "Alice Johnson", "department": "Engineering", "skills": ["Java","Spring Boot","REST"] },
  { "id": 2, "name": "Bob Williams",  "department": "Engineering", "skills": ["Angular","TypeScript","HTML/CSS"] },
  { "id": 3, "name": "Carla Mendes",  "department": "Database Administration", "skills": ["SQL","PL/SQL","Data Modeling"] },
  { "id": 4, "name": "David Kim",     "department": "Database Administration", "skills": ["Java","Spring Boot","REST"] }
]
```

In Postman: new request → `GET` → `http://localhost:8080/employees` → Send.
