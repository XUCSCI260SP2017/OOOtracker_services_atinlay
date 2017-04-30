package edu.xavier.csci260.atinlay.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/30/2017.
 */
@Component
public class DatabaseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save() {

        final String sql = "SCRIPT TO 'src/main/resources/schema.sql'";

        jdbcTemplate.execute(sql);
    }
}
