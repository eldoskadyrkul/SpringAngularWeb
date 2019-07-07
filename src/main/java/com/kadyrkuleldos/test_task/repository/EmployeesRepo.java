package com.kadyrkuleldos.test_task.repository;

import com.kadyrkuleldos.test_task.models.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeesRepo extends JpaRepository<Employees, Long> {
    /*String searchQuery =  "SELECT `employees`.`ID`, \n" +
            "`employees`.`firstname`, `employees`.`lastname`, \n" +
            "`employees`.`surname`, `employees`.`email`, \n" +
            "`employees`.`gender` FROM `test-application`.`employees` \n" +
            "WHERE `employees`.`ID` = '%s'";

    @EntityGraph(value = "employees.open", type = EntityGraph.EntityGraphType.LOAD)
    Optional<Employees> findById(int ID);

    @EntityGraph(value = "employees.preview", type = EntityGraph.EntityGraphType.LOAD)
    @Override
    List<Employees> findAll();

    @EntityGraph(value = "employees.preview", type = EntityGraph.EntityGraphType.LOAD)
    @Query(value = searchQuery)
    Page<Employees> findByRequest(
            @Param("id") int id,
            @Param("firstname") String firstname,
            @Param("lastname") String lastname,
            @Param("surname") String surname,
            @Param("email") String email,
            @Param("gender") String gender
    );*/
}
