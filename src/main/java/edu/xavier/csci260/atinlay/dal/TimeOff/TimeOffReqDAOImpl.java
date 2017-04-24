package edu.xavier.csci260.atinlay.dal.TimeOff;

import edu.xavier.csci260.atinlay.domain.TimeOff.TimeOffReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/23/2017.
 */
public class TimeOffReqDAOImpl implements TimeOffReqDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TimeOffReq> getTimeOffReqsByRequester(String id) {

        final String sql = "SELECT * FROM timeOffRequests WHERE employee = ?";

        return (List<TimeOffReq>) jdbcTemplate.query(
                sql,
                new Object[]{ id },
                new TORRowMapper()
        );
    }

    @Override
    public List<TimeOffReq> getTimeOffReqsByRecipient(String id) {

        final String sql = "SELECT * FROM timeOffRequests WHERE manager = ?";

        return (List<TimeOffReq>) jdbcTemplate.query(
                sql,
                new Object[]{ id },
                new TORRowMapper()
        );
    }

    @Override
    public List<TimeOffReq> getTimeOffReqsById(Long id) {

        final String sql = "SELECT * FROM timeOffRequests WHERE id = ?";

        return (List<TimeOffReq>) jdbcTemplate.query(
                sql,
                new Object[]{ id },
                new TORRowMapper()
        );
    }


    /**
     *
     * @param id of the manager who will review the request
     * @return
     */
    @Override
    public List<TimeOffReq> getUnreviewedTimeOffReqsByManager(String id) {

        final String sql = "SELECT * FROM timeOffRequests WHERE reviewed = FALSE AND id = ? ORDER BY created";

        return (List<TimeOffReq>) jdbcTemplate.query(
                sql,
                new Object[]{ id },
                new TORRowMapper()
        );
    }

    @Override
    public List<TimeOffReq> getUnreviewedTimeOffReqsByEmployee(String id) {

        final String sql = "SELECT * FROM timeOffRequests WHERE reviewed = FALSE AND id = ? ORDER BY created";

        return (List<TimeOffReq>) jdbcTemplate.query(
                sql,
                new Object[]{ id },
                new TORRowMapper()
        );
    }

    @Override
    public void createTimeOffReq(TimeOffReq timeOffReq) {

    }

    @Override
    public void removeTimeOffReq(TimeOffReq timeOffReq) {

    }
}
