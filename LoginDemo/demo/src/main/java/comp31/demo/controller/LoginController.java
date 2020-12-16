// Edited by Ravneet Singh
package comp31.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import comp31.demo.model.User;
import comp31.demo.repo.UserRepo;
import comp31.demo.service.LoginService;


@Controller
@SessionAttributes("currentUser")
public class LoginController {

    @Autowired
    UserRepo userRepo;
    @Autowired
    LoginService loginService;

 
 @GetMapping({"/","/login"})
 public String getLogin(Model model) 
 {
    User user = new User();
    model.addAttribute("newUser", user);
    return "login";

}

 @PostMapping("/login")
 public String postLogin(User user, Model model) 
 {
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

    // Written below by Ravneet Singh
    @GetMapping("/hint")
    public String getHint()
    {
        return"hint";
    }
    @GetMapping("/customerpage")
    public String getCust()
    {
        return"customerpage";
    }
    @GetMapping("/managerpage")
    public String getManPage()
    {
        return"managerpage";
    }
    @GetMapping("/employeepage")
    public String getEmpPage()
    {
        return"employeePage";
    }
    @GetMapping("/insertnew")
    public String insertnew()
    {
        return"insertnew";

    }
    @GetMapping("/addnew")
    public String addUser(User user)
    {
        userRepo.save(user);//This save the data
        return"insertnew";
    } 
    @GetMapping("/hint1")
    public String hint1()
    {
        return "hint1";
    }
    @GetMapping("/signUp")
    public String sign()
    {
        return "insertnew";
    }

}