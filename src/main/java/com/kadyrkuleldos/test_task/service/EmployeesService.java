package com.kadyrkuleldos.test_task.service;

import com.kadyrkuleldos.test_task.connector.ConnectionPool;
import com.kadyrkuleldos.test_task.models.Employees;
import com.kadyrkuleldos.test_task.models.EmployeesModels;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class EmployeesService {

    private static final String GET_EMPLOYEES_QUERY = "SELECT `employees`.`ID`, \n" +
            "`employees`.`firstname`, `employees`.`lastname`, \n" +
            "`employees`.`surname`, `employees`.`email`, \n" +
            "`employees`.`gender` FROM `test-application`.`employees` \n" +
            "WHERE `employees`.`ID` = '%s'";

    private static final String INSERT_EMPLOYEES_QUERY = "INSERT INTO `employees` VALUES (default, '%s', '%s', '%s', '%s', '%s')";

    private static final String UPDATE_EMPLOYEES_QUERY = "UPDATE `employees` SET `employees`.`firstname`='%s', \n " +
            "`employees`.`lastname`='%s',`employees`.`surname`='%s', \n" +
            "`employees`.`email`='%s',`employees`.`gender`='%s' \n" +
            "WHERE `employees`.`ID`= '%s'";

    public Employees getEmployeesFromID(EmployeesModels employeesModels) {
        Employees res = null;
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            String query = String.format(GET_EMPLOYEES_QUERY, employeesModels.getID());
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                res = new Employees(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getString("gender")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public Employees insertEmployess(String firstname, String lastname, String surname, String email, String gender) {
        Employees result = null;
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            String insert_query = String.format(INSERT_EMPLOYEES_QUERY);
            PreparedStatement statement = connection.prepareStatement(insert_query);
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, surname);
            statement.setString(4, email);
            statement.setString(5, gender);
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Employees updateEmployess() {
        Employees res = null;
        EmployeesModels employeesModels = null;
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            String update_query = String.format(UPDATE_EMPLOYEES_QUERY, employeesModels.getID());
            PreparedStatement statement = connection.prepareStatement(update_query, new String[]{res.getFirstname(), res.getLastname(),
                    res.getSurname(), res.getEmail(), res.getGender()});
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
