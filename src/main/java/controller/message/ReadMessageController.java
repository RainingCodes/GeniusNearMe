package controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.MemberService;
import service.MemberServiceImpl;
import service.MessageService;
import service.MessageServiceImpl;
import service.dto.MessageDTO;

public class ReadMessageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String type = request.getParameter("type");
		int messageId = Integer.parseInt(request.getParameter("message"));
		
		System.out.println(type+", "+messageId);
		
		MessageService manager = new MessageServiceImpl();
    	MessageDTO dto = manager.ViewMessage(messageId);
    	
    	MemberService Mmanager = new MemberServiceImpl();
    	String nickname = null;
    	
    	request.setAttribute("message", dto);
		
		if (type.equals("receive")) { //받은 쪽지함(내가 받았으니 받은사람(sender)따로 있고 나는 receiver)
			if (!manager.isReadByReceiver(messageId)) { // 아직 안읽혔으면
				int result = manager.readByReceiver(messageId); // 읽힌걸로 상태 변경하고
				
				nickname = Mmanager.getNicknameByUserId(dto.getSenderId());//보낸사람 닉네임 가져와
				request.setAttribute("nickname", nickname);
				System.out.println("읽힌걸로 상태 변경"+result);
			}
			return "/message/receiveviewMessage.jsp";
			
			
		} else if (type.equals("send")) { //보낸 쪽지함(단순히 그냥 보여주기만 하면된다, 내가 보냈음(sender))
			nickname = Mmanager.getNicknameByUserId(dto.getReceiverId());
			request.setAttribute("nickname", nickname);
			return "/message/sendviewMessage.jsp";
		}
		
		return "redirect:/main";
	}

}
