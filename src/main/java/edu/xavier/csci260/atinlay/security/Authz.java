package edu.xavier.csci260.atinlay.security;

import edu.xavier.csci260.atinlay.domain.Message;
import edu.xavier.csci260.atinlay.domain.User;
import org.springframework.stereotype.Component;

/**
 * @author Rob Winch
 * @Modiefied by Luke McNamee for the OOOtracker project
 */
@Component
public class Authz {

	public boolean check(Long userId, User user) {
		return userId.equals(user.getId());
	}

	public boolean check(Message message, User user) {
		if(message == null) {
			return true;
		}
		if(user == null) {
			return false;
		}
		return check(message.getTo().getId(), user) || check(message.getFrom().getId(), user);
	}
}
