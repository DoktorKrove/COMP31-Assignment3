package comp31.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import comp31.demo.model.User;
import comp31.demo.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import comp31.demo.service.LoginService;

/**
 * LoginController
 */
@Slf4j
@Controller
@SessionAttributes("currentUser")
public class LoginController {

    @Autowired
    UserRepo userRepo;
    @Autowired
    LoginService loginService;

    Logger logger = LoggerFactory.getLogger(LoginController.class);
    // @GetMapping({"/","/login"})
    @GetMapping("/")
    public String getLogin(Model model) {
        User currentUser = (User) model.getAttribute("currentUser");

        User user = new User();
        model.addAttribute("user", user);
        if(currentUser == null){
            log.info("No User is logged");
            model.addAttribute("currentUser", user);
            
        } else {
            log.info("User was logged");
            model.addAttribute("user", currentUser); 
        }
        return "login";

    }

    // @PostMapping("/login")
    @PostMapping("/")
    public String postLogin(User user, Model model) {
       
       
        String nextPage = "login";

        User currentUser = loginService.validate(user.getUserName());
        if (currentUser != null)
        {
            nextPage = currentUser.getUserRole() + "page";
            model.addAttribute("currentUser", currentUser);
        }
        else 
        {
            user.setUserName("");
            model.addAttribute("newUser", user);
        }
        return nextPage;
    }

    @GetMapping("/logout")
    public String getLogout(Model model)
    {
        User user = new User();
        model.addAttribute("currentUser", null);
        model.addAttribute("newUser", user);
        return "login";
    }

}