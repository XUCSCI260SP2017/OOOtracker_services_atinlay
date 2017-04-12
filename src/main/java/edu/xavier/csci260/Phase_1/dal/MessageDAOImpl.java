/**
 * 
 */
package edu.xavier.csci260.Phase_1.dal;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import edu.xavier.csci260.Phase_1.domain.Employee;
import edu.xavier.csci260.Phase_1.domain.Message;
import edu.xavier.csci260.Phase_1.service.EmployeeService;

/**
 * @author chris
 *
 */
@Component
public class MessageDAOImpl implements MessageDAO {
	
	private JdbcTemplate jdbcTemplate;
	private EmployeeService employeeService;
	//private MessageService messageService;

	@Autowired
	public MessageDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		employeeService = new EmployeeServiceImpl(dataSource);
		//messageService = new MessageServiceImpl();
	}
	
	/* (non-Javadoc)
	 * @see edu.xavier.csci260.Phase_1.dal.MessageDAO#getMessagesBySender(java.lang.String)
	 */
	@Override
	public List<Message> getMessagesBySender(String username) {
		String sqlStmt = "SELECT sender_user_name, rec_user_name, msg_subject, msg_body FROM messages WHERE sender_user_name = ?";
		return jdbcTemplate.query(sqlStmt, 
				new Object[] {username}, 
				(rs, rowNum) ->
					// is it wrong to access a seperate DAO to get employees by username here?
					// @see edu.xavier.csci260.Phase_1.domain.Message#Message
					new Message(employeeService.getEmployeeByUsername(rs.getString("sender_user_name")), 
								employeeService.getEmployeeByUsername(rs.getString("rec_user_name")),
								rs.getString("msg_subject"),
								rs.getString("msg_body")
								));
	}

	/* (non-Javadoc)
	 * @see edu.xavier.csci260.Phase_1.dal.MessageDAO#getMessagesBySender(edu.xavier.csci260.Phase_1.domain.Employee)
	 */
	@Override
	public List<Message> getMessagesBySender(Employee sender) {
		return getMessagesBySender(sender.getUser_name());
	}

	/* (non-Javadoc)
	 * @see edu.xavier.csci260.Phase_1.dal.MessageDAO#getMessagesByRecipient(java.lang.String)
	 */
	@Override
	public List<Message> getMessagesByRecipient(String username) {
		String sqlStmt = "SELECT sender_user_name, rec_user_name, msg_subject, msg_body FROM messages WHERE rec_user_name = ?";
		return jdbcTemplate.query(sqlStmt, 
				new Object[] {username}, 
				(rs, rowNum) ->
					new Message(employeeService.getEmployeeByUsername(rs.getString("sender_user_name")), 
								employeeService.getEmployeeByUsername(rs.getString("rec_user_name")),
								rs.getString("msg_subject"),
								rs.getString("msg_body")
								));
	}

	/* (non-Javadoc)
	 * @see edu.xavier.csci260.Phase_1.dal.MessageDAO#getMessagesByRecipient(edu.xavier.csci260.Phase_1.domain.Employee)
	 */
	@Override
	public List<Message> getMessagesByRecipient(Employee recipient) {
		return getMessagesByRecipient(recipient.getUser_name());
	}

	/* (non-Javadoc)
	 * @see edu.xavier.csci260.Phase_1.dal.MessageDAO#createMessage(edu.xavier.csci260.Phase_1.domain.Employee, edu.xavier.csci260.Phase_1.domain.Employee)
	 */
	// TODO Message UID
	@Override
	public void createMessage(Employee sender, Employee recipient, String subject, String body) {
		jdbcTemplate.update("INSERT INTO messages (sender_user_name, rec_user_name, msg_subject, msg_body) VALUES (?,?,?,?)", 
							Arrays.asList(sender.getUser_name(), recipient.getUser_name(), subject, body));
	}

}
