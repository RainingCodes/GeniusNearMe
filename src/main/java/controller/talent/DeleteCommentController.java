package controller.talent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.DeleteMemberController;
import service.CommentService;
import service.CommentServiceImpl;

public class DeleteCommentController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(DeleteMemberController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		int commentId = Integer.parseInt(request.getParameter("commentId"));
	    log.debug("Delete commentId : {}", commentId);
	    	
	    CommentService manager = new CommentServiceImpl();
		int result = manager.deleteComment(commentId);
		System.out.println("덧글 삭제 결과 : "+result);
		
		String src = "/talent/view?talentId=" +request.getParameter("talentId"); 
		System.out.println(src);
		return src;
		
//		String src = "/talent/comment?talentId=" +Integer.parseInt(request.getParameter("talentId")); 
//		System.out.println(src);
//	    return src;
	}

}
