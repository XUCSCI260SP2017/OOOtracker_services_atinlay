package edu.xavier.csci260.Phase_1.domain;

import java.time.LocalDateTime;

public class Message {
	private Employee recipient;
	private Employee sender;
	private String msgBody;
	private String subject;
	private LocalDateTime timeSent;
	private LocalDateTime timeOpened;
	private Message parentMessage;
	
	public Message() {}
	
	public Message(Employee recipient, Employee sender, String msgBody, String subject, Message parentMessage) {
		this.recipient = recipient;
		this.sender = sender;
		this.msgBody = msgBody;
		this.subject = subject;
		this.parentMessage = parentMessage;
		this.timeSent = LocalDateTime.now();
	}
	
	// TODO find a way to uniquely identify messages
	public Message(Employee recipient, Employee sender, String msgBody, String subject) {
		this.recipient = recipient;
		this.sender = sender;
		this.msgBody = msgBody;
		this.subject = subject;
		//this.parentMessage = parentMessage;
		this.timeSent = LocalDateTime.now();
	}
	
	/**
	 * @return the recipient
	 */
	public Employee getRecipient() {
		return recipient;
	}
	/**
	 * @param recipient the recipient to set
	 */
	public void setRecipient(Employee recipient) {
		this.recipient = recipient;
	}
	/**
	 * @return the sender
	 */
	public Employee getSender() {
		return sender;
	}
	/**
	 * @param sender the sender to set
	 */
	public void setSender(Employee sender) {
		this.sender = sender;
	}
	/**
	 * @return the msgBody
	 */
	public String getMsgBody() {
		return msgBody;
	}
	/**
	 * @param msgBody the msgBody to set
	 */
	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the timeSent
	 */
	public LocalDateTime getTimeSent() {
		return timeSent;
	}

	/**
	 * @param timeSent the timeSent to set
	 */
	public void setTimeSent(LocalDateTime timeSent) {
		this.timeSent = timeSent;
	}

	/**
	 * @return the timeOpened
	 */
	public LocalDateTime getTimeOpened() {
		return timeOpened;
	}

	/**
	 * @param timeOpened the timeOpened to set
	 */
	public void setTimeOpened(LocalDateTime timeOpened) {
		this.timeOpened = timeOpened;
	}

	/**
	 * @return the parentMessage
	 */
	public Message getParentMessage() {
		return parentMessage;
	}

	/**
	 * @param parentMessage the parentMessage to set
	 */
	public void setParentMessage(Message parentMessage) {
		this.parentMessage = parentMessage;
	}

	
	
}
