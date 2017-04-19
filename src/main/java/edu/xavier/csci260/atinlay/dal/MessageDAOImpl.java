/**
 * 
 */
package edu.xavier.csci260.atinlay.dal;

import edu.xavier.csci260.atinlay.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chris
 *
 */
@Repository
@Component
public class MessageDAOImpl implements MessageDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* (non-Javadoc)
	 * @see edu.xavier.csci260.atinlay.dal.MessageDAO#getMessagesBySender(java.lang.String)
	 */
	@Override
	public List<Message> getMessagesBySender(String id) {

		final String sql = "SELECT * FROM messages WHERE from_id = ?";

		return (List<Message>) jdbcTemplate.query(
				sql,
				new Object[]{ id },
				new MessageRowMapper()
		);
	}

	/* (non-Javadoc)
	 * @see edu.xavier.csci260.atinlay.dal.MessageDAO#getMessagesByRecipient(java.lang.String)
	 */
	@Override
	public List<Message> getMessagesByRecipient(String id) {

		final String sql = "SELECT * FROM messages WHERE to_id = ?";

		return (List<Message>) jdbcTemplate.query(
				sql,
				new Object[]{ id },
				new MessageRowMapper()
		);
	}

	@Override
	public List<Message> getMessageById(Long id) {

		final String sql = "SELECT * FROM messages WHERE id = ?";

		return jdbcTemplate.query(
				sql,
				new Object[]{ id },
				new MessageRowMapper()
		);
	}

	/* (non-Javadoc)
         * @see edu.xavier.csci260.atinlay.dal.MessageDAO#createMessage(edu.xavier.csci260.atinlay.domain.EmployeeModels.EmployeeAbstract, edu.xavier.csci260.atinlay.domain.EmployeeModels.EmployeeAbstract)
         */
	@Override
	public void createMessage(Message message) {

		final String sql = "INSERT INTO messages (from_id, to_id, subject, body) VALUES (?,?,?,?)";

		jdbcTemplate.update(sql,
				message.getFrom(),
				message.getTo(),
				message.getSubject(),
				message.getBody()
		);
	}
}
