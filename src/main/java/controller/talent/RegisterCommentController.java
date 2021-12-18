package controller.talent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Comment;
import service.CommentService;
import service.CommentServiceImpl;

public class RegisterCommentController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RegisterCommentController.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
					
		int talentId = Integer.parseInt(request.getParameter("talentId"));	
		Comment comment = new Comment(
			talentId,
   	    	request.getParameter("content"),
   	    	Integer.parseInt(request.getParameter("commentWriterId"))
   		);
    	  		
    	log.debug("RegisterCommentController Request : {}", comment);
    	    	
    	CommentService manager = new CommentServiceImpl();
    	int i = manager.insertComment(comment);		
    	System.out.println("수정결과:"+i);
    	
    	
    	request.setAttribute("talentId", talentId);
		String src = "/talent/view?talentId=" +talentId; 
		System.out.println(src);
		return src;
    	

	}

}
