package controller.talent;

import java.util.ArrayList;
import java.util.Comparator;
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

public class ViewCommentController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ViewCommentController.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		if (request.getMethod().equals("GET")) { // GET request: 덧글 list 및 form 요청	
						
			HttpSession session = request.getSession();
			int commentWriterId = -1;
			String userEmail = null;
			String userNickname = null;
			
			CommentService manager = new CommentServiceImpl();
    		MemberService Mmanager = new MemberServiceImpl();
    		
			if (UserSessionUtils.hasLogined(session)) { // 로그인한 유저(그러니까 덧글 writer의 정보 받는 코드
				userEmail = UserSessionUtils.getLoginUserId(session);
				commentWriterId = Mmanager.getuserIdByEmail(userEmail);
				userNickname = Mmanager.getNicknameByUserId(commentWriterId);
			}
						
			//전달받은 현재 게시글 Id		
			int talentId = Integer.parseInt(request.getParameter("talentId"));
    		log.debug("Comment Get Request : {}", talentId);
    		
       		
			List<CommentDTO> commentList = manager.CommentListByTalentId(talentId);
			commentList.sort(Comparator.naturalOrder());
			List<String> userNicekname = new ArrayList<String>();
    		
    		for (int i = 0; i < commentList.size(); i++) {
    			int wId = commentList.get(i).getWriterId();
    			    			
    			//writerId 통해 nickname얻어오기
    			String nickname = Mmanager.getNicknameByUserId(wId);
    			userNicekname.add(nickname);
    		}
    		
    		//회원인지 비회원인지 전달하는 코드
			request.setAttribute("commentWriterId", commentWriterId);
			request.setAttribute("commentList", commentList);	
			request.setAttribute("nickList", userNicekname);
			request.setAttribute("talentId", talentId);
			request.setAttribute("userNicekname", userNickname);
			
			System.out.println(commentWriterId);
			System.out.println(talentId);
			
			return "/talent/view.jsp";
//			return "/talent/commentView.jsp";
 
	}

}
