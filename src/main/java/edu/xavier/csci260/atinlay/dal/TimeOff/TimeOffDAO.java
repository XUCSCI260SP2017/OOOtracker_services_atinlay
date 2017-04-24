package edu.xavier.csci260.atinlay.dal.TimeOff;

import edu.xavier.csci260.atinlay.domain.TimeOff.TimeOff;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/24/2017.
 */
public interface TimeOffDAO {

    List<TimeOff> getTimeOffById(Long id);

    List<TimeOff> getTimeOffByEmployee(String employee);

    /**
     * @return List of all of the time off for all employees. This should be order by date.
     */
    List<TimeOff> getAllTimeOff();

    /**
     * creates a new TimeOff
     *
     * @param timeOff
     */
    void createTimeOff(TimeOff timeOff);

    void removeTimeOff(TimeOff timeOff);

    class TimeOffRowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            TimeOff timeOff = new TimeOff();

            timeOff.setId(rs.getLong("id"));
            timeOff.setEmployee(rs.getString("employee"));
            timeOff.setStartTimestamp(rs.getTimestamp("startTimestamp"));
            timeOff.setEndTimestamp(rs.getTimestamp("endTimestamp"));
            timeOff.setReason(rs.getString("reason"));

            return timeOff;
        }
    }
}
