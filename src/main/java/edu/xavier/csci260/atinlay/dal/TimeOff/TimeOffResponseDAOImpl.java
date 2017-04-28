package edu.xavier.csci260.atinlay.dal.TimeOff;

import edu.xavier.csci260.atinlay.domain.TimeOff.TimeOffResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/24/2017.
 */

@Component
@Repository
public class TimeOffResponseDAOImpl implements TimeOffResponseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TimeOffResponse> getTimeOffResById(Long id) {

        final String sql = "SELECT * FROM timeOffResponses WHERE id = ?";

        return (List<TimeOffResponse>) jdbcTemplate.query(
                sql,
                new Object[]{ id },
                new ResponseRowMapper()
        );
    }

    @Override
    public List<TimeOffResponse> getTimeOffResByManager(String manager) {

        final String sql = "SELECT * FROM timeOffResponses WHERE manager = ?";

        return (List<TimeOffResponse>) jdbcTemplate.query(
                sql,
                new Object[]{ manager },
                new ResponseRowMapper()
        );
    }

    @Override
    public List<TimeOffResponse> getAllTimeOffRes() {

        final String sql = "SELECT * FROM timeOffResponses";

        return (List<TimeOffResponse>) jdbcTemplate.query(sql, new ResponseRowMapper());
    }

    @Override
    public void createTimeOffResponse(TimeOffResponse timeOffResponse) {

        final String sql = "INSERT INTO timeOffResponses (id, manager, reason, description, approved) VALUES (?,?,?,?,?)";

        jdbcTemplate.update(sql,
                timeOffResponse.getId(),
                timeOffResponse.getManager(),
                timeOffResponse.getReason(),
                timeOffResponse.getDescription(),
                timeOffResponse.getApproved()
        );
    }

    @Override
    public void removeTimeOffResponse(TimeOffResponse timeOffResponse) {

        final String sqlStmt = "DELETE FROM timeOffResponses WHERE id = ?";

        jdbcTemplate.update(sqlStmt, timeOffResponse.getId());
    }
}
