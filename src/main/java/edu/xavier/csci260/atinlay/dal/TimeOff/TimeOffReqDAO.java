package edu.xavier.csci260.atinlay.dal.TimeOff;

import edu.xavier.csci260.atinlay.domain.TimeOff.TimeOffReq;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/23/2017.
 */
public interface TimeOffReqDAO {

    /**
     * returns tor's that have the specified employee as the sender
     *
     * @param id
     * @return list of tor's
     */
    List<TimeOffReq> getTimeOffReqsByRequester(String id);

    /**
     * returns tor's that have the specified recipient
     *
     * @param id
     * @return list of tor's
     */
    List<TimeOffReq> getTimeOffReqsByRecipient(String id);

    List<TimeOffReq> getTimeOffReqsById(Long id);

    /**
     * This function returns all of the TOR's that have not been reviewed so that a manager may decide to approve them
     * @param id of the manager who will review the request
     * @return List of all of the unreviewed TOR's
     */
    List<TimeOffReq> getUnreviewedTimeOffReqsByManager(String id);

    List<TimeOffReq> getUnreviewedTimeOffReqsByEmployee(String id);

    /**
     * creates a new TimeOffReq
     *
     * @param timeOffReq
     */
    void createTimeOffReq(TimeOffReq timeOffReq);

    void removeTimeOffReq(TimeOffReq timeOffReq);

    class TORRowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            TimeOffReq timeOffReq = new TimeOffReq();

            timeOffReq.setId(rs.getLong("id"));
            timeOffReq.setEmployee(rs.getString("employee"));
            timeOffReq.setManager(rs.getString("manager"));
            timeOffReq.setStartTimestamp(rs.getTimestamp("startTimestamp"));
            timeOffReq.setEndTimestamp(rs.getTimestamp("endTimestamp"));
            timeOffReq.setCreated(rs.getTimestamp("created"));
            timeOffReq.setDescription(rs.getString("description"));
            timeOffReq.setReason(rs.getString("reason"));

            return timeOffReq;
        }
    }
}
