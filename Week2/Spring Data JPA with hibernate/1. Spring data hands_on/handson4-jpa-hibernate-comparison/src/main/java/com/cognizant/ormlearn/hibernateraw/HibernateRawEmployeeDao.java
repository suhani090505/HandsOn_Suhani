package com.cognizant.ormlearn.hibernateraw;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cognizant.ormlearn.model.Employee;


public class HibernateRawEmployeeDao {

    private final SessionFactory factory;

    public HibernateRawEmployeeDao() {
        this.factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    /** Method to CREATE an employee in the database (mirrors the hands-on doc's snippet) */
    public Integer addEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeId = null;

        try {
            tx = session.beginTransaction();
            employeeId = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return employeeId;
    }

    public Employee getEmployee(Integer id) {
        Session session = factory.openSession();
        try {
            return session.get(Employee.class, id);
        } finally {
            session.close();
        }
    }

    public void close() {
        factory.close();
    }
}
