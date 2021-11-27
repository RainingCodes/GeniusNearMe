package controller.talentTest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import service.MemberService;
import service.MemberServiceImpl;
import service.TalentTestService;
import service.TalentTestServiceImpl;
import service.dto.TalentTestDTO;

public class ResultTalentTestController implements Controller  {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userNickname = null;
		String email = null;
		int userId = -1;

    	if (!UserSessionUtils.hasLogined(request.getSession())) { // 로그인 안되면
    		System.out.println("not Logined");
    		email = "-1";
    		userNickname = "-1";
        } else { // 로그인 되면
        	email = UserSessionUtils.getLoginUserId(request.getSession());
        	MemberService manager = new MemberServiceImpl();
        	userId = manager.getuserIdByEmail(email);
        	userNickname = manager.getNicknameByUserId(userId);
        }
    	
		
		int[] result = new int[4];
		String type = "";
		for (int i = 0; i < result.length; i++) {
			String tmp = "result"+i;
			result[i] = Integer.parseInt(request.getParameter(tmp));
			type += result[i];
		}
		System.out.println(type);
		
		String myType = null;
		String myCategory = null;
		
		if (type.equals("0000") || type.equals("0001") || type.equals("0011")) {
			myType = "철두철미 완벽주의자형";
			myCategory = "law";
		} else if (type.equals("0010") || type.equals("0111") || type.equals("1001")) {
			myType = "논리적인 전략가형";
			myCategory = "it";
		} else if (type.equals("0101") || type.equals("0110") || type.equals("0111")) {
			myType = "게으른 예술가형";
			myCategory = "art";
		} else if (type.equals("1001") || type.equals("1011")) {
			myType = "지적인 사교가형";
			myCategory = "cook";
		} else if (type.equals("1010") || type.equals("1110") || type.equals("1111")) {
			myType = "열정적인 활동가형";
			myCategory = "sport";
		} else if (type.equals("1100") || type.equals("1101")) {
			myType = "신나는 베짱이형";
			myCategory = "foreignLanguage";
		}
		
		System.out.println(myType);
		
		
		String lastType = null;
		
		TalentTestService manager = new TalentTestServiceImpl();
		TalentTestDTO lastDTO = manager.talentTestResultByUserId(userId);
		TalentTestDTO newDTO = new TalentTestDTO(myCategory, myType, userId);
		
		if (lastDTO != null) { // 이전 검색 결과 있을시 update
			lastType = lastDTO.getResultCategory();
			int insert = manager.updateTalent(newDTO);
			System.out.println("update결과 : "+insert);
		} else { // 이전 검색 결과 없을시 insert
			int update = manager.updateTalent(newDTO);
			System.out.println("insert결과 : "+update);
		}
		
		request.setAttribute("myCategory", myCategory);
		request.setAttribute("myType", myType);
		request.setAttribute("userId", userId);
		request.setAttribute("nickName", userNickname);
		request.setAttribute("lastType", lastType);
		
		return "/talentTest/talentTestResult.jsp";
	}

}
