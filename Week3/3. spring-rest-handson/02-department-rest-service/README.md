# Hands-on 2: Department REST Service

Implements **Create REST service for department**. Builds on hands-on 1 (includes
the full Employee REST service too), and adds the parallel Department stack.

## Project structure

```
src/main/java/com/training/employeeapp/
├── EmployeeAppApplication.java   @ImportResource({employee.xml, department.xml})
├── model/
│   ├── Employee.java
│   └── Department.java            id, name
├── dao/
│   ├── EmployeeDao.java
│   └── DepartmentDao.java         static DEPARTMENT_LIST, loaded from department.xml
├── service/
│   ├── EmployeeService.java
│   └── DepartmentService.java     @Service, @Transactional, logs on every call
└── controller/
    ├── EmployeeController.java    GET /employees
    └── DepartmentController.java  GET /departments, logs on every call
src/main/resources/
├── employee.xml
├── department.xml                 3 Department beans + departmentList ArrayList
└── application.properties
```

## Run

```bash
mvn spring-boot:run
```

## Test

```bash
curl http://localhost:8080/departments
curl http://localhost:8080/employees
```

Expected `/departments` response:
```json
[
  { "id": 1, "name": "Engineering" },
  { "id": 2, "name": "Database Administration" },
  { "id": 3, "name": "Human Resources" }
]
```

In Postman: new request → `GET` → `http://localhost:8080/departments` → Send.

## Verifying the call in the logs

`DepartmentController` and `DepartmentService` both emit an INFO log line whenever
`/departments` is hit, so you can confirm — as the hands-on asks — that the
department REST service was actually invoked by watching the running app's console:

```
GET /departments called
DepartmentService.getAllDepartments() invoked - fetching department list from DAO
DepartmentService.getAllDepartments() returning 3 department(s)
```
