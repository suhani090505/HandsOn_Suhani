package com.cognizant.ormlearn.hibernateraw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.ormlearn.model.Employee;

public class HibernateRawDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateRawDemo.class);

    public static void main(String[] args) {
        HibernateRawEmployeeDao dao = new HibernateRawEmployeeDao();
        try {
            Employee employee = new Employee("Ada", "Lovelace");
            Integer id = dao.addEmployee(employee);
            LOGGER.info("Inserted employee id={}", id);

            Employee fetched = dao.getEmployee(id);
            LOGGER.info("Fetched employee={}", fetched);
        } finally {
            dao.close();
        }
    }
}
