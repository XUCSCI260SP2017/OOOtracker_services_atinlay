package edu.xavier.csci260.atinlay.dal;

import edu.xavier.csci260.atinlay.domain.Authority;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/16/2017.
 */
public interface AuthorityDAO {

    Authority getAuthorityByUsername(String username);

    void createAuthority(Authority authority);

    void removeAuthority(Authority authority);

    void removeUserFromAuthorities(String username);


        /**
         * Custom RowMapper to correctly handle employee requests to the database
         */
    class AuthorityRowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

            Authority authority = new Authority();

            authority.setUsername(rs.getString("username"));
            authority.setRole(rs.getString("authority"));

            return authority;
        }
    }
}
