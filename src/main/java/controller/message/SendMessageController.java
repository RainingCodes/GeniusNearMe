package controller.message;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.MemberService;
import service.MemberServiceImpl;
import service.MessageService;
import service.MessageServiceImpl;
import service.dto.MessageDTO;

public class SendMessageController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(SendMessageController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// GET request : 쪽지 form 요청	
		if (request.getMethod().equals("GET")) {	
    		
			int senderId = Integer.parseInt(request.getParameter("senderId"));
			int receiverId = Integer.parseInt(request.getParameter("receiverId"));

    		log.debug("Send Message Get Request : {}", senderId, receiverId);
    		
    		MemberService manager = new MemberServiceImpl();
    		String reciverNickname = manager.getNicknameByUserId(receiverId);	
    		    		
    		request.setAttribute("rNickname", reciverNickname);
    		request.setAttribute("senderId", senderId);
    		request.setAttribute("receiverId", receiverId);
          
			return "/message/messageSend.jsp";	// 사용자 보기 화면으로 이동 (forwarding)
	    }
    	
		
		//보내는 사람 입장이므로 senderId가 userId랑 일맥상통함
		int senderId = Integer.parseInt(request.getParameter("senderId"));
		int receiverId = Integer.parseInt(request.getParameter("receiverId"));
		long miliseconds = System.currentTimeMillis();
	    Date current = new Date(miliseconds);
	    
    	// POST request (회원정보가 parameter로 전송됨)
    	MessageDTO dto = new MessageDTO(
   	    	request.getParameter(request.getParameter("content")),
   	    	current,
   	    	senderId,
   	    	receiverId
   		);
    	
    	MessageService manager = new MessageServiceImpl();
    	int i = manager.sendMessage(dto);
    	
    	System.out.println("메세지 전송 결과 : "+i);
    	return "redirect:/member/messageList";
    	
    	
//    	try {    		
//    	    log.debug("Update User : {}", updateMember.getEmail());
//    	    	
//    	    MemberService manager = new MemberServiceImpl();
//    		int i = manager.updateMember(updateMember);		
//    		System.out.println("수정결과:"+i);
//    		return "redirect:/member/view";
//	        
//		} catch (ExistingUserException e) {	// 예외 발생 시 수정 form으로 forwarding
//			
//			System.out.println("수정불가");
//            request.setAttribute("updateFailed", true);
//			request.setAttribute("exception", e);
//			request.setAttribute("member", updateMember);
//			return "/member/updateForm.jsp";
//		}
	}

}
