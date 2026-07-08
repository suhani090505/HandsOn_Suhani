package com.training.employeeapp.dao;

import com.training.employeeapp.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class EmployeeDao {

    @SuppressWarnings("unchecked")
    private static ArrayList<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {
        // Read the employee list straight out of the XML config, as specified.
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList", List.class);
        ((ClassPathXmlApplicationContext) context).close();
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}
