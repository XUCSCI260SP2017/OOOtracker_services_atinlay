package edu.xavier.csci260.atinlay.dal;

import edu.xavier.csci260.atinlay.domain.Message;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface MessageDAO {
	
	/**
	 * returns messages that have the specified employee as the sender
	 * 
	 * @param id
	 * @return list of messages
	 */
	List<Message> getMessagesBySender(String id);

	/**
	 * returns messages that have the specified recipient
	 * 
	 * @param id
	 * @return list of messages
	 */
	List<Message> getMessagesByRecipient(String id);

	List<Message> getMessageById(Long id);

	/**
	 * creates a new message
	 * @param message
	 */
	void createMessage(Message message);

	class MessageRowMapper implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Message message = new Message();

			message.setId(rs.getLong("id"));
			message.setFrom(rs.getString("from_id"));
			message.setTo(rs.getString("to_id"));
			message.setSubject(rs.getString("subject"));
			message.setBody(rs.getString("body"));
			message.setCreated(rs.getTimestamp("created"));

			return message;
		}
	}
}
