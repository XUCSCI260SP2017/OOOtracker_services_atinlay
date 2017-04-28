package edu.xavier.csci260.atinlay.dal.TimeOff;

import edu.xavier.csci260.atinlay.domain.TimeOff.TimeOff;
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
public class TimeOffDAOImpl implements TimeOffDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TimeOff> getTimeOffById(Long id) {

        final String sql = "SELECT * FROM timeOff WHERE id = ?";

        return (List<TimeOff>) jdbcTemplate.query(
                sql,
                new Object[]{ id },
                new TimeOffRowMapper()
        );
    }

    @Override
    public List<TimeOff> getTimeOffByEmployee(String employee) {

        final String sql = "SELECT * FROM timeOff WHERE employee = ?";

        return (List<TimeOff>) jdbcTemplate.query(
                sql,
                new Object[]{ employee },
                new TimeOffRowMapper()
        );
    }

    @Override
    public List<TimeOff> getAllTimeOff() {

        final String sqlStmt = "SELECT * FROM timeOff";

        return (List<TimeOff>) jdbcTemplate.query(sqlStmt, new TimeOffRowMapper());
    }

    @Override
    public void createTimeOff(TimeOff timeOff) {

        final String sql = "INSERT INTO timeOff (id, employee, reason, startTimestamp, endTimestamp) VALUES (?,?,?,?,?)";

        jdbcTemplate.update(sql,
                timeOff.getId(),
                timeOff.getEmployee(),
                timeOff.getReason(),
                timeOff.getStartTimestamp(),
                timeOff.getEndTimestamp()
        );
    }

    @Override
    public void removeTimeOff(TimeOff timeOff) {

        final String sqlStmt = "DELETE FROM timeOff WHERE id = ?";

        jdbcTemplate.update(sqlStmt, timeOff.getId());
    }
}
