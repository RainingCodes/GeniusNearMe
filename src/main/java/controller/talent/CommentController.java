package controller.talent;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.UserSessionUtils;
import service.CommentService;
import service.CommentServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;
import service.dto.CommentDTO;

public class CommentController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(CommentController.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if (request.getMethod().equals("GET")) { // GET request: 덧글 list 및 form 요청	
						
			HttpSession session = request.getSession();
			int commentWriterId = -1;
			
			if (UserSessionUtils.hasLogined(session)) {
				commentWriterId = Integer.parseInt(UserSessionUtils.getLoginUserId(session));
			}
			request.setAttribute("commentWriterId", commentWriterId);	
			
			int talentId = Integer.parseInt(request.getParameter("talnetId"));
    		log.debug("Comment Get Request : {}", talentId);
    		
    		CommentService manager = new CommentServiceImpl();
    		MemberService Mmanager = new MemberServiceImpl();
    		
			List<CommentDTO> commentList = manager.CommentListByTalentId(talentId);
			List<String> userNicekname = new ArrayList<String>();
    		
    		for (int i = 0; i < commentList.size(); i++) {
    			int wId = commentList.get(i).getWriterId();
    			    			
    			//writerId 통해 nickname얻어오기
    			String nickname = Mmanager.getNicknameByUserId(wId);
    			userNicekname.add(nickname);
    		}
			
			request.setAttribute("commentList", commentList);	
			request.setAttribute("nickList", userNicekname);	
			
			System.out.print(userNicekname);
			
			return "/talent/commentView.jsp";	
	    }
    	
		
    	// POST request : 덧글 작성시 등록 (회원만 가능하게)
		String talentId = request.getParameter("talentId");
		System.out.println(talentId);
		CommentDTO comment = new CommentDTO(
   	    	Integer.parseInt(talentId),
   	    	request.getParameter("content"),
   	    	Integer.parseInt(request.getParameter("commentWriterId"))
   		);
    	
//    	try {    		
    	    log.debug("Comment Post Request : {}", comment);
    	    	
    	    CommentService manager = new CommentServiceImpl();
    		int i = manager.insertComment(comment);		
    		System.out.println("수정결과:"+i);
	        
//		} catch (ExistingUserException e) {	// 예외 발생 시 수정 form으로 forwarding
//			
//			System.out.println("수정불가");
//            request.setAttribute("updateFailed", true);
//			request.setAttribute("exception", e);
//			request.setAttribute("member", updateMember);
//		}
    	
    	
		String src = "/talent/view/comment?talentId="+talentId; 
		System.out.println(src);
	    return src;
	}

}
