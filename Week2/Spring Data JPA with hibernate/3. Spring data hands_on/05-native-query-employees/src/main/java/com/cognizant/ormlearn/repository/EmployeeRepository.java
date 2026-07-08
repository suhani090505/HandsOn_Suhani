package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // NOTE: HQL looks like SQL, but instead of tables, Java classes and
    // their instance variables are addressed here.
    //
    // Journey to this final query (see README for the full walkthrough):
    //   1) "SELECT e FROM Employee e WHERE e.permanent = 1"
    //      -> works, but with EAGER associations it fires extra queries
    //         per row (N+1) to load department/skills.
    //   2) Removing EAGER fixes the N+1 explosion but department/skills
    //      come back null/uninitialized (LazyInitializationException risk
    //      once outside the session, or simply not populated).
    //   3) "left join e.department d left join e.skillList" - the join
    //      links the tables for filtering purposes, but does NOT populate
    //      the Java bean fields.
    //   4) Adding "fetch" to each join is what actually populates the
    //      beans, in a single SQL statement:
    @Query(value = "SELECT e FROM Employee e " +
            "left join fetch e.department d " +
            "left join fetch e.skillList " +
            "WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    // Native queries are direct SQL against the database instead of HQL.
    // Prefer HQL/JPQL where possible (better database portability) and
    // keep native queries to a minimum, for cases HQL can't express well.
    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}
