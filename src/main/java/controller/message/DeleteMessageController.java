package controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.MessageService;
import service.MessageServiceImpl;

public class DeleteMessageController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(SendMessageController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//보내는 사람 입장이므로 senderId가 userId랑 일맥상통함
		int messageId = Integer.parseInt(request.getParameter("messageId"));
			    
		log.debug("DeleteMessageController Request : {}", messageId);
		MessageService manager = new MessageServiceImpl();
		int i = manager.deleteMessage(messageId);
		System.out.println("메세지 삭제 결과 : "+i);
		return "redirect:/member/messageList";
	}

}
