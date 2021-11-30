package controller.user;

import java.util.ArrayList;
import java.util.List;

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

public class ViewMessageListController implements Controller {

	private static final Logger log = LoggerFactory.getLogger(ViewMemberController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
    		System.out.println("not Logined");
            return "redirect:/member/login/form";		// login form 요청으로 redirect
        }
    	
    	MemberService memberManager = new MemberServiceImpl();
    	MessageService messageManager = new MessageServiceImpl();
		String email = UserSessionUtils.getLoginUserId(request.getSession());
		
		log.debug("ViewMessageListController : {}", email);
		int userId = memberManager.getuserIdByEmail(email);
		
		//보낸 쪽지함 리스트 : send 기준 읽고, receiver의 nickname을 띄워야함
		//받은 쪽지함 리스트 : receive 기준 읽고, sender의 nickname을 띄워야함
		List<MessageDTO> sendList = null;
		List<MessageDTO> receiveList = null;
		List<String> sendListNicekname = null;
		List<String> receiveListNicekname = null;
    	
//    	try {
    		sendList = messageManager.SenderMessageList(userId);
    		receiveList = messageManager.ReceiverMessageList(userId);
    		
    		sendListNicekname = new ArrayList<String>();
    		receiveListNicekname = new ArrayList<String>();
    		
    		for (int i = 0; i < sendList.size(); i++) {
    			int receiverId = sendList.get(i).getReceiverId();
    			String nickname = memberManager.getNicknameByUserId(receiverId);
    			sendListNicekname.add(nickname);
    		}
    		
    		for (int i = 0; i < receiveList.size(); i++) {
    			int senderId = receiveList.get(i).getSenderId();
    			String nickname = memberManager.getNicknameByUserId(senderId);
    			receiveListNicekname.add(nickname);
    		}
//		} catch (SQLException e) {	
//	        return "redirect:/member/login/form";
//		}
    	
    	
    	request.setAttribute("sendList", sendList);
    	request.setAttribute("receiveList", receiveList);
    	request.setAttribute("sendListNicekname", sendListNicekname);
    	request.setAttribute("receiveListNicekname", receiveListNicekname);
    	
		return "/member/message/viewMessageList.jsp";				// 사용자 보기 화면으로 이동
	}

}
