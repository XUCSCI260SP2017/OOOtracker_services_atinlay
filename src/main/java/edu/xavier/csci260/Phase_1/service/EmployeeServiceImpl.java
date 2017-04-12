/**
 * 
 */
package edu.xavier.csci260.Phase_1.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.xavier.csci260.Phase_1.dal.EmployeeDAO;
import edu.xavier.csci260.Phase_1.dal.EmployeeDAOImpl;
import edu.xavier.csci260.Phase_1.domain.Employee;
import edu.xavier.csci260.Phase_1.domain.Message;

/**
 * @author chris
 *
 */
@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(DataSource dataSource) {
		this.employeeDAO = new EmployeeDAOImpl(dataSource);
	}

	/* (non-Javadoc)
	 * @see edu.xavier.csci260.Phase_1.service.EmployeeService#createEmplyee()
	 */
	@Override
	public void createEmplyee(String user, String first, String last, String password) {
		employeeDAO.createUser(user, first, last, password);
	}

	/* (non-Javadoc)
	 * @see edu.xavier.csci260.Phase_1.service.EmployeeService#pushEmployee()
	 */
	// TODO Not sure what this is for
	@Override
	public boolean pushEmployee() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.xavier.csci260.Phase_1.service.EmployeeService#getNewMessages()
	 */
	@Override
	public List<Message> getNewMessages() {
		// TODO Auto-generated method
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.xavier.csci260.Phase_1.service.EmployeeService#getMessages()
	 */
	@Override
	public List<Message> getMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.xavier.csci260.Phase_1.service.EmployeeService#getMessage()
	 */
	@Override
	public Message getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
