package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.talent.DetailedSearchController;
import controller.talent.KeywordSearchController;
import controller.talent.RegisterTalentController;
import controller.talent.ViewTalentController;
import controller.user.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
        mappings.put("/", new ForwardController("myIndex.jsp"));
        mappings.put("/main", new ForwardController("/main/main.jsp"));
        mappings.put("/member/login/form", new ForwardController("/member/loginForm.jsp"));
        mappings.put("/member/login", new LoginController());
        mappings.put("/member/logout", new LogoutController());
//        mappings.put("/user/list", new ListUserController());
        mappings.put("/member/view", new ViewMemberController());
        mappings.put("/member/register", new RegisterMemberController());
        mappings.put("/member/register/form", new RegisterMemberController());

        mappings.put("/member/update/form", new UpdateMemberController());
        mappings.put("/member/update", new UpdateMemberController());
        mappings.put("/member/delete", new DeleteMemberController());    
        mappings.put("/member/matching", new MyMatchingListController());    
        
        mappings.put("/talent/register", new RegisterTalentController());
        mappings.put("/talent/view", new ViewTalentController());
        mappings.put("/talent/registerForm", new ForwardController("/talent/registerForm.jsp"));
        mappings.put("/talent/keywordSearch", new KeywordSearchController());
        mappings.put("/talent/detailedSearch", new DetailedSearchController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {
        return mappings.get(uri);
    }
}
