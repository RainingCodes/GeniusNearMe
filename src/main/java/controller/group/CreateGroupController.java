package controller.group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.GroupService;
import service.GroupServiceImpl;
import service.dto.GroupDTO;
import service.dto.MatchingDTO;
import service.dto.TalentDTO;

public class CreateGroupController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(CreateGroupController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		GroupService groupService = new GroupServiceImpl();
		MatchingDTO matching = new MatchingDTO();
		GroupDTO group = new GroupDTO();
		log.debug("Create group : {}", group);
		
		GroupService manager = new GroupServiceImpl();
		
		manager.insertGroup(group, talent.getTalentId());
	    return "redirect:/talent/group/list";	
	}

}
