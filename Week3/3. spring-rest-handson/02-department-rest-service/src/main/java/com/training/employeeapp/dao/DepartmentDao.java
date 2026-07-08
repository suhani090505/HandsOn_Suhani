package com.training.employeeapp.dao;

import com.training.employeeapp.model.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class DepartmentDao {

    @SuppressWarnings("unchecked")
    private static ArrayList<Department> DEPARTMENT_LIST;

    public DepartmentDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("department.xml");
        DEPARTMENT_LIST = (ArrayList<Department>) context.getBean("departmentList", List.class);
        ((ClassPathXmlApplicationContext) context).close();
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
