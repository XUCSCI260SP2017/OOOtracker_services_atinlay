package edu.xavier.csci260.atinlay.dal;

import edu.xavier.csci260.atinlay.domain.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/16/2017.
 */
@Component
@Repository
public class AuthorityDAOImpl implements AuthorityDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorityDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Authority getAuthorityByUsername(String username) {

        String sql = "SELECT * FROM authorities WHERE username = ?";

        return (Authority) jdbcTemplate.queryForObject(
                sql,
                new Object[] { username },
                new AuthorityRowMapper()
        );
    }

    @Override
    public void createAuthority(Authority authority) {

        String sqlStmt = "INSERT INTO authorities(username, authority) VALUES (?, ?)";

        jdbcTemplate.update(sqlStmt,
                authority.getUsername(),
                authority.getRole()
        );
    }

    @Override
    public void removeAuthority(Authority authority) {
        String sqlStmt = "DELETE FROM authorities WHERE authority = ?";

        jdbcTemplate.update(sqlStmt, authority.getRole());
    }

    @Override
    public void removeUserFromAuthorities(String username) {
        String sqlStmt = "DELETE FROM authorities WHERE username = ?";

        jdbcTemplate.update(sqlStmt, username);
    }
}
