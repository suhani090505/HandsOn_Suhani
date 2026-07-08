package com.training.employeeapp.service;

import com.training.employeeapp.dao.DepartmentDao;
import com.training.employeeapp.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentDao departmentDao;

    @Transactional
    public List<Department> getAllDepartments() {
        LOGGER.info("DepartmentService.getAllDepartments() invoked - fetching department list from DAO");
        List<Department> departments = departmentDao.getAllDepartments();
        LOGGER.info("DepartmentService.getAllDepartments() returning {} department(s)", departments.size());
        return departments;
    }
}
