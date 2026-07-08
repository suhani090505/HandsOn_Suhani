package com.cognizant.ormlearn;

import com.cognizant.ormlearn.entity.Employee;
import com.cognizant.ormlearn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);

        testGetAllPermanentEmployees();
        testGetAverageSalary();
        testGetAverageSalaryByDepartment();
    }

    public static void testGetAllPermanentEmployees() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees:{}", employees);
        employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
        LOGGER.info("End");
    }

    public static void testGetAverageSalary() {
        LOGGER.info("Start");
        double averageSalary = employeeService.getAverageSalary();
        LOGGER.debug("Average Salary (all departments):{}", averageSalary);
        LOGGER.info("End");
    }

    public static void testGetAverageSalaryByDepartment() {
        LOGGER.info("Start");
        int departmentId = 1;
        double averageSalary = employeeService.getAverageSalary(departmentId);
        LOGGER.debug("Average Salary (department {}):{}", departmentId, averageSalary);
        LOGGER.info("End");
    }
}
