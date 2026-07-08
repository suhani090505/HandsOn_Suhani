package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;


@SpringBootApplication
public class OrmLearnHandson4Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnHandson4Application.class);

    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnHandson4Application.class, args);

        employeeService = context.getBean(EmployeeService.class);

        testAddEmployee();
    }

    private static void testAddEmployee() {
        LOGGER.info("Start");
        Employee employee = new Employee("Grace", "Hopper");
        employeeService.addEmployee(employee);
        LOGGER.debug("Saved employee={}", employee);
        LOGGER.info("End");
    }
}
