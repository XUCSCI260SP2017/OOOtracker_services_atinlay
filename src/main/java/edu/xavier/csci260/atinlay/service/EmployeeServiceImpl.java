/**
 * 
 */
package edu.xavier.csci260.atinlay.service;

import edu.xavier.csci260.atinlay.dal.EmployeeDAO;
import edu.xavier.csci260.atinlay.dal.MessageDAO;
import edu.xavier.csci260.atinlay.domain.Authority;
import edu.xavier.csci260.atinlay.domain.Employee;
import edu.xavier.csci260.atinlay.domain.EmployeeModels.HumanResourcesManager;
import edu.xavier.csci260.atinlay.domain.EmployeeModels.Manager;
import edu.xavier.csci260.atinlay.domain.EmployeeModels.Worker;
import edu.xavier.csci260.atinlay.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chris
 *
 */
@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	private MessageDAO messageDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO, MessageDAO messageDAO) {
		this.employeeDAO = employeeDAO;
		this.messageDAO = messageDAO;
	}

	/* (non-Javadoc)
	 * @see edu.xavier.csci260.atinlay.service.EmployeeService#createEmplyee()
	 */
	@Override
	public void createWorker(String username, String first_name, String last_name, String password, String manager_id) {
		employeeDAO.createEmployee(new Worker(username, first_name, last_name, password, manager_id));
	}

	/* (non-Javadoc)
	 * @see edu.xavier.csci260.atinlay.service.EmployeeService#createEmplyee()
	 */
	@Override
	public void createManager(String username, String first_name, String last_name, String password) {
		employeeDAO.createEmployee(new Manager(username, first_name, last_name, password));
	}

	/* (non-Javadoc)
	 * @see edu.xavier.csci260.atinlay.service.EmployeeService#createEmplyee()
	 */
	@Override
	public void createHR(String username, String first_name, String last_name, String password, String manager_id) {
		employeeDAO.createEmployee(new HumanResourcesManager(username, first_name, last_name, password, manager_id));
	}

	/* (non-Javadoc)
	 * @see edu.xavier.csci260.atinlay.service.EmployeeService#getNewMessages()
	 */
	@Override
	public List<Message> getNewMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getInbox(Employee to) {
		return messageDAO.getMessagesByRecipient(to.getUsername());
	}

	@Override
	public List<Message> getOutbox(Employee from) {
		return messageDAO.getMessagesBySender(from.getUsername());
	}

	@Override
	public Employee getEmployee(String username) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployeeByUsername(username);
	}

	@Override
	public void createMessage(String from, String to, String body, String subject) {
		messageDAO.createMessage(new Message(from, to, body, subject));
	}

	@Override
	public Authority getAuthority(Employee employee) {
		return null;
	}
}
