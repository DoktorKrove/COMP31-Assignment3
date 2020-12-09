package comp31.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import comp31.demo.model.User;
import comp31.demo.model.order;
import comp31.demo.repo.UserRepo;
import comp31.demo.repo.ToppingRepo;
import comp31.demo.repo.OrderRepo;

/**
 * LoginController
 */
@Controller
@SessionAttributes("currentUser")
public class CustomerController 
{

    @Autowired UserRepo userRepo;
    @Autowired ToppingRepo toppingRepo;
    @Autowired OrderRepo orderRepo;

    @GetMapping("/order")
    public String getLogin(User user, Model model) 
    {
        User currentUser = (User)model.getAttribute("currentUser");
        List<order> orderList = orderRepo.findByUserId(currentUser);
        model.addAttribute("orderList", orderList);
        return "customerpage";
    }

}