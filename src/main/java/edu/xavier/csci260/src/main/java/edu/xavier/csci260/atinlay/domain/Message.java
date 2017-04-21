package edu.xavier.csci260.atinlay.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable {

	private Long id;

	private Timestamp created;

	private String from, to;

	private String body, subject;

	public Message() {}

	public Message(String from, String to, String body, String subject) {
		this.from = from;
		this.to = to;
		this.body = body;
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Message{" +
				"id=" + id +
				", created=" + created +
				", from='" + from + '\'' +
				", to='" + to + '\'' +
				", body='" + body + '\'' +
				", subject='" + subject + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Message message = (Message) o;

		if (getId() != null ? !getId().equals(message.getId()) : message.getId() != null) return false;
		if (getCreated() != null ? !getCreated().equals(message.getCreated()) : message.getCreated() != null)
			return false;
		if (!getFrom().equals(message.getFrom())) return false;
		if (!getTo().equals(message.getTo())) return false;
		if (!getBody().equals(message.getBody())) return false;
		return getSubject() != null ? getSubject().equals(message.getSubject()) : message.getSubject() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getCreated() != null ? getCreated().hashCode() : 0);
		result = 31 * result + getFrom().hashCode();
		result = 31 * result + getTo().hashCode();
		result = 31 * result + getBody().hashCode();
		result = 31 * result + (getSubject() != null ? getSubject().hashCode() : 0);
		return result;
	}

	/**
	 * @return the sender
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from_id the sender to set
	 */
	public void setFrom(String from_id) {
		this.from = from_id;
	}

	/**
	 * @return the recipient
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to_id the recipient to set
	 */
	public void setTo(String to_id) {
		this.to = to_id;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the subject to set
	 */
	public void setBody(String body) {
		this.body = body;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}
}
