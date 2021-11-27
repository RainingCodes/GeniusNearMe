package controller.talentTest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class ResultTalentTestController implements Controller  {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String result0 = request.getParameter("result0");
		String result1 = request.getParameter("result1");
		String result2 = request.getParameter("result2");
		String result3 = request.getParameter("result3");
		
		System.out.println(result0+result1+result2+result3);
		
		return "/talentTest/talentTestResult.jsp";
	}

}
