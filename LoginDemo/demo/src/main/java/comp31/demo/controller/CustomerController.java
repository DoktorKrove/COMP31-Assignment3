package comp31.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import comp31.demo.model.User;
import comp31.demo.repo.UserRepo;
import comp31.demo.service.LoginService;

/**
 * LoginController
 */
@Controller
@SessionAttributes("currentUser")
public class CustomerController 
{

    @Autowired
    UserRepo userRepo;
    @Autowired
    LoginService loginService;

    @GetMapping("/order")
    public String getLogin(User user, Model model) 
    {
        User currentUser = loginService.validate(user.getUserName());
        return "customerpage";
    }

}