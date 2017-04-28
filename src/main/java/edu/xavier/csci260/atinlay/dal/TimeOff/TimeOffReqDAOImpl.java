package edu.xavier.csci260.atinlay.dal.TimeOff;

import edu.xavier.csci260.atinlay.domain.TimeOff.TimeOffReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/23/2017.
 */

@Component
@Repository
public class TimeOffReqDAOImpl implements TimeOffReqDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TimeOffReq> getTimeOffReqsByEmployee(String employee) {

        final String sql = "SELECT * FROM timeOffRequests WHERE employee = ?";

        return (List<TimeOffReq>) jdbcTemplate.query(
                sql,
                new Object[]{ employee },
                new RequestRowMapper()
        );
    }

    @Override
    public List<TimeOffReq> getTimeOffReqsByManager(String manager) {

        final String sql = "SELECT * FROM timeOffRequests WHERE manager = ?";

        return (List<TimeOffReq>) jdbcTemplate.query(
                sql,
                new Object[]{ manager },
                new RequestRowMapper()
        );
    }

    @Override
    public List<TimeOffReq> getAllTimeOffReqs() {

        final String sqlStmt = "SELECT * FROM timeOffRequests";

        return (List<TimeOffReq>) jdbcTemplate.query(sqlStmt, new RequestRowMapper());
    }

    @Override
    public List<TimeOffReq> getTimeOffReqById(Long id) {

        final String sql = "SELECT * FROM timeOffRequests WHERE id = ?";

        return (List<TimeOffReq>) jdbcTemplate.query(
                sql,
                new Object[]{ id },
                new RequestRowMapper()
        );
    }

    @Override
    public void createTimeOffReq(TimeOffReq timeOffReq) {

        final String sql = "INSERT INTO timeOffRequests (employee, manager, reason, description, startTimestamp, " +
                "endTimestamp) VALUES (?,?,?,?,?,?)";

        jdbcTemplate.update(sql,
                timeOffReq.getEmployee(),
                timeOffReq.getManager(),
                timeOffReq.getReason(),
                timeOffReq.getDescription(),
                timeOffReq.getStartTimestamp(),
                timeOffReq.getEndTimestamp()
        );
    }

    @Override
    public void removeTimeOffReq(TimeOffReq timeOffReq) {

        final String sqlStmt = "DELETE FROM timeOffRequests WHERE id = ?";

        jdbcTemplate.update(sqlStmt, timeOffReq.getId());
    }
}
