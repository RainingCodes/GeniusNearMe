package controller.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.GroupService;
import service.GroupServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;
import service.dto.GroupDTO;
import service.dto.MemberDTO;
import service.dto.MyMatchingDTO;

public class MyGroupMatchingListController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MyGroupMatchingListController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!UserSessionUtils.hasLogined(request.getSession())) {
    		System.out.println("not Logined");
            return "redirect:/member/login/form";		// login form 요청으로 redirect
        }
    	
    	
    	MemberService manager = new MemberServiceImpl();
    	GroupService gService = new GroupServiceImpl();
		String email = UserSessionUtils.getLoginUserId(request.getSession());
		
		log.debug("apply my group matching User : {}", email);
		
		
		int userId = manager.getuserIdByEmail(email);
		List<MyMatchingDTO> myApplyMatchingInfo = null;
		List<MemberDTO> matchingWriterInfo = null; // 매칭글 작성자 info를 가져오기 위해 이렇게 짬
		List<Integer> receiveGroupIds = new ArrayList<Integer>();
		List<Integer> applyGroupIds = new ArrayList<Integer>();
		HashMap<Integer, String[]> groupMemberList = new HashMap<Integer, String[]>();
		HashMap<Integer, String[]> groupMemberList2 = new HashMap<Integer, String[]>();
		HashMap<Integer, Integer[]> headList = new HashMap<Integer, Integer[]>(); 
		HashMap<Integer, Integer[]> headList2 = new HashMap<Integer, Integer[]>(); 
		Integer[] head = null;
		List<String> ApplyUserNicekname = null;
		
    	try {
    		myApplyMatchingInfo =  manager.ListingApplyMyGroupMatchingByUserId(userId);	// 사용자 정보 검색
    		
    		matchingWriterInfo = new ArrayList<MemberDTO>();
    		
    		ApplyUserNicekname = new ArrayList<String>();
    		
    		for (int i = 0; i < myApplyMatchingInfo.size(); i++) {
    			//탤런트Id로 writerId 불러오기
    			int writerId = manager.getWriterIdByTalentId(myApplyMatchingInfo.get(i).getTalentId());
    			int mId = myApplyMatchingInfo.get(i).getMatchingId();
    			
    			List<GroupDTO> groupList = gService.GroupList(myApplyMatchingInfo.get(i).getTalentId());
    			
    			for(int j = 0; j < groupList.size(); j++) {
	    			Integer[] id = gService.getGroupMembers(groupList.get(j).getGroupId());
	    			head = new Integer[2];
	    			head[0] = gService.getGroup(groupList.get(j).getGroupId()).getMembers();
	    			if(head[0] > 0) {
		        		head[1] = gService.getGroup(groupList.get(j).getGroupId()).getHeadCount();
		    			applyGroupIds.add(groupList.get(j).getGroupId());
		    			if(id != null) {
		    				ArrayList<String> groupMembersNick = new ArrayList<String>();
		    				for(int k = 0; k< id.length; k++) {
		    					groupMembersNick.add(manager.getNicknameByUserId(id[k]));
		    				}
		    				groupMemberList2.put(groupList.get(j).getGroupId(), groupMembersNick.toArray(new String[groupMembersNick.size()]));
		    				headList2.put(groupList.get(j).getGroupId(), head);;
		    			} 
	    			}
	    		}
    			for(int j = 0; j < headList2.size(); j++)
        			System.out.println(headList2.get(i) + "오로롤ㄹ");
    			
        		//유저Id 바탕으로 member Info 가져오기
    			MemberDTO m = manager.getMember(writerId);
    			int mUserId = manager.getUserIdByMatchingId(mId);
    			String nickname = manager.getNicknameByUserId(mUserId);
    			ApplyUserNicekname.add(nickname);
    			matchingWriterInfo.add(m);
    		}
    		
    		
		} catch (SQLException e) {	
	        return "redirect:/member/login/form";
		}
    	
    	
    	log.debug("receive my group matching User : {}", email);
		
		List<MyMatchingDTO> myReceiveMatchingInfo = null;
		List<String> ReceiveUserNicekname = null;
		
    	try {
    		myReceiveMatchingInfo =  manager.ListingReceiveMyGroupMatchingByUserId(userId);	// 사용자 정보 검색
    		
    		ReceiveUserNicekname = new ArrayList<String>();
    		
    		for (int i = 0; i < myReceiveMatchingInfo.size(); i++) {
    			int mId = myReceiveMatchingInfo.get(i).getMatchingId();
    			
    			
    			List<GroupDTO> groupList = gService.GroupList(myReceiveMatchingInfo.get(i).getTalentId());
	    		for(int j = 0; j < groupList.size(); j++) {
	    			Integer[] id = gService.getGroupMembers(groupList.get(j).getGroupId());
	    			head = new Integer[2];
	    			head[0] = gService.getGroup(groupList.get(j).getGroupId()).getMembers();
	    			if(head[0] > 0) {
		        		head[1] = gService.getGroup(groupList.get(j).getGroupId()).getHeadCount();
		    			receiveGroupIds.add(groupList.get(j).getGroupId());
		    			if(id != null) {
		    				ArrayList<String> groupMembersNick = new ArrayList<String>();
		    				for(int k = 0; k< id.length; k++) {
		    					groupMembersNick.add(manager.getNicknameByUserId(id[k]));
		    				}
		    				groupMemberList.put(groupList.get(j).getGroupId(), groupMembersNick.toArray(new String[groupMembersNick.size()]));
		    				headList.put(groupList.get(j).getGroupId(), head);
		    			} 
	    			}
	    		}
    		
    			
    			//매칭 아이디 통해서 userId 구해오고, userNickname 구해오기 (와 진짜 미친 조인)
    			int mUserId = manager.getUserIdByMatchingId(mId);
    			String nickname = manager.getNicknameByUserId(mUserId);
    			
    			ReceiveUserNicekname.add(nickname);
    		}
    		
		} catch (SQLException e) {	
	        return "redirect:/member/login/form";
		}
    	

    	//receive 받은
    	request.setAttribute("receiveList", myReceiveMatchingInfo);		// 사용자 정보 저장	
    	request.setAttribute("nickList", ReceiveUserNicekname);
    	request.setAttribute("groupMemberList", groupMemberList);
    	request.setAttribute("headList", headList);
    	request.setAttribute("receiveGroupIds", receiveGroupIds);
    	
    	//apply 신청
    	request.setAttribute("applyList", myApplyMatchingInfo);		// 사용자 정보 저장	
    	request.setAttribute("headList2", headList2);
    	request.setAttribute("nickList2", ApplyUserNicekname);
    	request.setAttribute("groupMemberList2", groupMemberList2);
    	request.setAttribute("matchingWriterInfo", matchingWriterInfo);
    	request.setAttribute("applyGroupIds", applyGroupIds);
    	
    	
		return "/member/groupMatching/viewGroupMatchingList.jsp";				// 사용자 보기 화면으로 이동
	}

}

