package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.talent.RegisterTalentController;
import controller.user.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
//        mappings.put("/", new ForwardController("index.jsp"));
        mappings.put("/user/login/form", new ForwardController("/user/loginForm.jsp"));
        mappings.put("/user/login", new LoginController());
        mappings.put("/user/logout", new LogoutController());
//        mappings.put("/user/list", new ListUserController());
        mappings.put("/user/view", new ViewMemberController());
        mappings.put("/user/register/form", new ForwardController("/user/registerForm.jsp"));
        mappings.put("/talent/register", new RegisterTalentController());
        mappings.put("/user/update/form", new UpdateMemberController());
        mappings.put("/user/update", new UpdateMemberController());
        mappings.put("/user/delete", new DeleteMemberController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {
        return mappings.get(uri);
    }
}
