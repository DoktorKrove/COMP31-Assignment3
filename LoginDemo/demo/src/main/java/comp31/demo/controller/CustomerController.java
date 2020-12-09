/* Leif Lang */
package comp31.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import comp31.demo.model.User;
import comp31.demo.model.order;
import comp31.demo.model.topping;
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

    @GetMapping("/showOrders")
    public String getLogin(User user, Model model) 
    {
        User currentUser = (User)model.getAttribute("currentUser");
        List<order> orderList = orderRepo.findByUserId(currentUser);
        List<String> toppingsList = new ArrayList<String>();
        for (order order : orderList) 
        {
            order.setToppings(GetLocalizedToppings(order));
        }
        model.addAttribute("orderList", orderList);
        model.addAttribute("toppings", toppingsList);
        return "/customerorders";
    }
 
 
    public String GetLocalizedToppings(order order)
    {
        StringBuilder localizedToppings = new StringBuilder();
        String[] splitToppings = order.getToppings().split(",");
        for (int i = 0; i < splitToppings.length; i++)
        {
            List<topping> name = toppingRepo.findByToppingId(Integer.parseInt(splitToppings[i]));
            if (name.size() != 1)
                System.err.println("Topping with ID: " + splitToppings[i] + " is an invalid ID.");
            localizedToppings.append(name.get(0).getToppingName() + ", ");
        }
        return localizedToppings.toString();
    }
}