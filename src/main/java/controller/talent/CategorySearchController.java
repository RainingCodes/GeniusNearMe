package controller.talent;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.TalentService;
import service.TalentServiceImpl;
import service.dto.TalentDTO;

public class CategorySearchController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] category = request.getParameterValues("category");
		System.out.println(category[0]);
		TalentService manager = new TalentServiceImpl();
		
		List<TalentDTO> talentList;
		if(category.length == 1 && category[0].equals("all"))
			talentList = manager.ListingTalents();
		else 
			talentList = manager.getTalentByTalentCategory(category);
		
		request.setAttribute("talentList", talentList);
		
		return "/talent/categorySearch/list.jsp";
	}
	
}
