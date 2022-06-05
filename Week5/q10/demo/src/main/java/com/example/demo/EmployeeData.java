package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class EmployeeData {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String insertSql = "insert into Person (name) values (?)";
    private final int count = 1000;
    public void create(){
        long startTime = System.currentTimeMillis();
        for (int i=0; i<count; i++){
            jdbcTemplate.update(insertSql, "name"+i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time :" + (endTime-startTime));
    }

    @Transactional
    public void bulkCreate(){
        long startTime = System.currentTimeMillis();
        //Init dummy data. To be refactored
        ArrayList<String> list = new ArrayList<>(count);
        for (int i=0; i<count; i++) {
            list.add("batch name"+i);
        }
        jdbcTemplate.batchUpdate(insertSql,list,100,
                new ParameterizedPreparedStatementSetter<String>() {
                    public void setValues(PreparedStatement ps, String argument)
                            throws SQLException {
                        ps.setString(1, argument);
                    }
                });
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time (batch) : " + (endTime-startTime));
    }
}
