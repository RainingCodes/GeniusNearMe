package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.matching.*;
import controller.talent.*;
import controller.talentTest.*;
import controller.user.*;
import controller.group.*;
import controller.message.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
        mappings.put("/", new ForwardController("myIndex.jsp"));
        mappings.put("/main", new ForwardController("/main/main.jsp"));
        
        mappings.put("/member/login/form", new ForwardController("/member/loginForm.jsp"));
        mappings.put("/member/login", new LoginController());
        mappings.put("/member/logout", new LogoutController());
        mappings.put("/member/view", new ViewMemberController());
        mappings.put("/member/register", new RegisterMemberController());
        mappings.put("/member/register/form", new RegisterMemberController());
        mappings.put("/member/update/form", new UpdateMemberController());
        mappings.put("/member/update", new UpdateMemberController());
        mappings.put("/member/delete", new DeleteMemberController());    
        mappings.put("/member/ApplyMatching", new ApplyMyMatchingListController());    
        mappings.put("/member/ReceiveMatching", new ReceiveMyMatchingListController());
        mappings.put("/member/myTalentList", new MyTalentListController());
        mappings.put("/member/wishList", new WishListController());
        mappings.put("/member/deleteWish", new DeleteWishController());
        
        mappings.put("/talent/register", new RegisterTalentController());
        mappings.put("/talent/view", new ViewTalentController());
        mappings.put("/talent/registerForm", new ForwardController("/talent/registerForm.jsp"));
        mappings.put("/talent/keywordSearch", new KeywordSearchController());
        mappings.put("/talent/categorySearch", new CategorySearchController());
        mappings.put("/talent/detailedSearch", new DetailedSearchController());
        mappings.put("/talent/update", new UpdateTalentController());
        mappings.put("/talent/group", new ForwardController("/talent/groupMatching.jsp"));
        mappings.put("/group/register", new CreateGroupController());
        mappings.put("/talent/group/match", new InsertGroupMemberController());
        mappings.put("/talent/comment", new ViewCommentController());
        mappings.put("/talent/comment/register", new RegisterCommentController());
        mappings.put("/talent/comment/delete", new DeleteCommentController());
        
        mappings.put("/message", new SendMessageController());
        mappings.put("/member/messageList", new ViewMessageListController());
        
        mappings.put("/matching/talent", new ApplicationMatchingController());
        mappings.put("/matching/choose", new ChooseMatchingController());
        
        mappings.put("/talentTest", new ForwardController("/talentTest/talentTest.jsp"));
        mappings.put("/talentTest/result", new ResultTalentTestController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {
        return mappings.get(uri);
    }
}
