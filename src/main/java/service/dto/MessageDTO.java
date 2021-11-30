package service.dto;
import java.util.Date;

public class MessageDTO {
	private int messageId;
	private int state;
	private String content;
	private Date writtenDate;
	private int senderId;
	private int receiverId;
	
	public MessageDTO(int messageId, int state, String content, Date writtenDate, int senderId, int receiverId) {
		this.messageId = messageId;
		this.state = state;
		this.content = content;
		this.writtenDate = writtenDate;
		this.senderId = senderId;
		this.receiverId = receiverId;
	}
	
	public MessageDTO(String content, Date writtenDate, int senderId, int receiverId) {
		super();
		this.content = content;
		this.writtenDate = writtenDate;
		this.senderId = senderId;
		this.receiverId = receiverId;
	}

	public MessageDTO() {
		this.messageId = -1;
		this.state = -1;
		this.content = null;
		this.writtenDate = null;
		this.senderId = -1;
		this.receiverId = -1;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWrittenDate() {
		return writtenDate;
	}

	public void setWrittenDate(Date writtenDate) {
		this.writtenDate = writtenDate;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	@Override
	public String toString() {
		return "MessageDTO [messageId=" + messageId + ", state=" + state + ", content=" + content + ", writtenDate="
				+ writtenDate + ", senderId=" + senderId + ", receiverId=" + receiverId + "]";
	}

	
}
