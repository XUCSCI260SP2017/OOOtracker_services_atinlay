package edu.xavier.csci260.atinlay.dal.TimeOff;

import edu.xavier.csci260.atinlay.domain.TimeOff.TimeOffResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/24/2017.
 */
public interface TimeOffResponseDAO {

    List<TimeOffResponse> getTimeOffResById(Long id);

    List<TimeOffResponse> getTimeOffResByManager(String manager);

    /**
     * @return List of all of the time off for all employees. This should be order by date.
     */
    List<TimeOffResponse> getAllTimeOffRes();

    /**
     * creates a new TimeOffResponse
     *
     * @param timeOffResponse
     */
    void createTimeOffResponse(TimeOffResponse timeOffResponse);

    void removeTimeOffResponse(TimeOffResponse timeOffResponse);

    class ResponseRowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            TimeOffResponse timeOffResponse = new TimeOffResponse();

            timeOffResponse.setId(rs.getLong("id"));
            timeOffResponse.setManager(rs.getString("manager"));
            timeOffResponse.setReason(rs.getString("reason"));
            timeOffResponse.setDescription(rs.getString("description"));
            timeOffResponse.setApproved(rs.getBoolean("approved"));
            timeOffResponse.setClosed(rs.getTimestamp("closed"));

            return timeOffResponse;
        }
    }

}
