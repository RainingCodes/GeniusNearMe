package service;

import java.util.List;

import service.dto.MessageDTO;

public interface MessageService {
	public List<MessageDTO> SenderMessageList(int senderId);
	public List<MessageDTO> ReceiverMessageList(int receiverId);
	public MessageDTO ViewMessage(int messageId);
	public int sendMessage(MessageDTO messageDTO);
	public boolean isReadByReceiver(int messageId);
	public int readByReceiver(int messageId);
	public int deleteMessage(int messageId);
}
