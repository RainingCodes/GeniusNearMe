package service;

import java.util.List;

import persistence.DAOFactory;
import persistence.dao.MessageDAO;
import service.dto.MessageDTO;

public class MessageServiceImpl implements MessageService {
private MessageDAO dao = null;
	
	public MessageServiceImpl() {
		DAOFactory factory = new DAOFactory();
		dao = factory.getMessageDAO();
	}
	
	public List<MessageDTO> SenderMessageList(int senderId) {
		return dao.getMessageListBySenderId(senderId);
	}
	public List<MessageDTO> ReceiverMessageList(int receiverId) {
		return dao.getMessageListByReceiverId(receiverId);
	}
	public MessageDTO ViewMessage(int messageId) {
		return dao.getMessageById(messageId);
	}
	public int sendMessage(MessageDTO messageDTO) {
		return dao.InsertMessage(messageDTO);
	}
	public boolean isReadByReceiver(int messageId) {
		if (dao.stateByMessageId(messageId) == 0)
			return false;
		else
			return true;
	}
	public int readByReceiver(int messageId) {
		return dao.updateMessageStateToRead(messageId);
	}
	public int deleteMessage(int messageId) {
		return dao.DeleteMessage(messageId);
	}

}
