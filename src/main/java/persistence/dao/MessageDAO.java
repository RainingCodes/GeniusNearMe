package persistence.dao;

import java.util.List;

import service.dto.MessageDTO;

public interface MessageDAO {
	
	//1.senderId로 메세지 목록 가져오기
	public List<MessageDTO> getMessageListBySenderId(int senderId);
	
	//2.receiverId로 메세지 목록 가져오기
	public List<MessageDTO> getMessageListByReceiverId(int receiverId);
	
	//3.messageId로 메세지 하나 가져오기
	public MessageDTO getMessageById(int messageId);
	
	
	//4.메세지 insert하기(insert에선 state 무조건 0임)
	public int InsertMessage(MessageDTO message);
	
	//5.메세지 state read로 update하기(insert에선 무조건 0임)
	public int updateMessageStateToRead(int messageId);
	
	//6.메세지 delete하기
	public int DeleteMessage(int messageId);
	
	//7.메세지 id로 state감별
	public int stateByMessageId(int messageId);
		
}
