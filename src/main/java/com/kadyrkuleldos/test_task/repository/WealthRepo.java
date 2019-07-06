package com.kadyrkuleldos.test_task.repository;

import com.kadyrkuleldos.test_task.models.Wealth;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface WealthRepo extends JpaRepository<Wealth, Long> {
    String searchQuery =  "SELECT `wealth`.`ID`, \n" +
            "`wealth`.`category_wealth`, `wealth`.`name_wealth`, \n" +
            "`wealth`.`date_wealth`, `wealth`.`price_wealth`, \n" +
            "`wealth`.`employee_id` \n" +
            "WHERE `wealth`.`ID` = '%s'";

    @EntityGraph(value = "wealth.open", type = EntityGraph.EntityGraphType.LOAD)
    Optional<Wealth> findById(int ID);

    @EntityGraph(value = "wealth.preview", type = EntityGraph.EntityGraphType.LOAD)
    @Override
    List<Wealth> findAll();

    @EntityGraph(value = "wealth.preview", type = EntityGraph.EntityGraphType.LOAD)
    @Query(value = searchQuery)
    Page<Wealth> findByRequest(
            @Param("id") int id,
            @Param("category_wealth") String category_wealth,
            @Param("name_wealth") String name_wealth,
            @Param("date_wealth")Date date_wealth,
            @Param("price_wealth") int price_wealth,
            @Param("employee_id") int employee_id
    );
}
