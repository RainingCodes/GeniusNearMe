package service;

import java.util.List;

import service.dto.MessageDTO;

public interface MessageService {
	//보낸사람 메세지함
	public List<MessageDTO> SenderMessageList(int senderId);
	//받은사람 메세지함
	public List<MessageDTO> ReceiverMessageList(int receiverId);
	//메세지 하나 내용 보기
	public MessageDTO ViewMessage(int messageId);
	
	//메세지를 보내는 주체는 sender
	public int sendMessage(MessageDTO messageDTO);
	
	//받은 사람이 메세지를 확인했냐
	public boolean isReadByReceiver(int messageId);
	//받은 사람이 메세지 읽었으니까 DB반영해라
	public int readByReceiver(int messageId);
	//메세지 DB 삭제하기
	public int deleteMessage(int messageId);
}
