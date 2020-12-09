package comp31.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import comp31.demo.model.User;
import comp31.demo.model.order;
import comp31.demo.repo.OrderRepo;
import comp31.demo.repo.UserRepo;

@Controller
@SessionAttributes({"currentUser","orderList"})

public class EmployeeController {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    UserRepo userRepo;

    @GetMapping("/employee")
    public String goToClerkPage(Model model){
    String nextPage= "login";
    User currentUser = (User) model.getAttribute("currentUser");

    List<order> orderList = null;

    orderList= orderRepo.findAll();
    model.addAttribute("currentUser", currentUser);
    model.addAttribute("orderList", orderList);
    return nextPage;
    
    }

    

    
}
