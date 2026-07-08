package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT e FROM Employee e " +
            "left join fetch e.department d " +
            "left join fetch e.skillList " +
            "WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    // Aggregate function across the whole table
    @Query(value = "SELECT AVG(e.salary) FROM Employee e")
    double getAverageSalary();

    // NOTES:
    //  - department id is referred from 'e' as e.department.id (object
    //    navigation, not a foreign key column name)
    //  - the colon (:id) defines a bind parameter within the query
    //  - @Param binds the method argument to that named parameter
    //  - the same pattern works for any other aggregate function
    //    (SUM, MIN, MAX, COUNT, ...), not just AVG
    @Query(value = "SELECT AVG(e.salary) FROM Employee e where e.department.id = :id")
    double getAverageSalary(@Param("id") int id);
}

