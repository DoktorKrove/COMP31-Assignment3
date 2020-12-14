/* Leif Lang */
package comp31.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        if (currentUser == null)
            return "redirect:login";
        else if (!currentUser.getUserRole().equals("customer"))
            return "redirect:login";
        List<order> orderList = orderRepo.findByUserId(currentUser);
        List<String> toppingsList = new ArrayList<String>();
        for (order order : orderList) 
        {
            toppingsList.add(GetLocalizedToppings(order));
        }
        model.addAttribute("orderList", orderList);
        model.addAttribute("toppings", toppingsList);
        return "/customerorders";
    }

    @GetMapping("/createOrder")
    public String createOrder(User user, Model model)
    {
        User currentUser = (User)model.getAttribute("currentUser");
        if (currentUser == null)
            return "redirect:login";
        else if (!currentUser.getUserRole().equals("customer"))
            return "redirect:login";
        order newOrder = new order();
        //set default values
        newOrder.setPizzaNumber(1);
        newOrder.setPizzaSize("LARGE");
        List<topping> toppingsList = toppingRepo.findAll();
        model.addAttribute("toppingsList", toppingsList);
        model.addAttribute("newOrder", newOrder);
        return "/customercreateorder";
    }

    @PostMapping("/orderData")
    public String postOrder(order order, Model model, @RequestBody String req)
    {
        User currentUser = (User)model.getAttribute("currentUser");
        if (currentUser == null)
            return "redirect:login";
        else if (!currentUser.getUserRole().equals("customer"))
            return "redirect:login";
        float total = 0.0f;
        String[] toppingArray = req.split("&topping=");
        StringBuilder toppings = new StringBuilder();
        java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
        //convert the array of topping into a string of toppingIDs
        if (toppingArray.length == 1)
            return "/customererror";
        for (int i = 1; i < toppingArray.length; i++)
        {
            toppings.append(("00" + toppingArray[i]).substring(toppingArray[i].length()) + ",");
            total += toppingRepo.findById(Integer.parseInt(toppingArray[i])).get().getToppingPrice();
        }

        //Get the total for the pizza
        switch (order.getPizzaSize()) {
            case "SMALL":
                total += 5f;
                break;
            case "MEDIUM":
                total += 6f;
                break;
            case "LARGE":
                total += 7f;
                break;
            case "X-LARGE":
                total += 8f;
                break;
            default:
                total += 5f;
                break;
        }
        //multiply the total by the number of pizzas to get the grand total
        total *= order.getPizzaNumber();
        order.setToppings(toppings.toString());
        order.setOrderDate(today);
        order.setOrderTotal(total);
        order.setUserId(currentUser);
        order.setOrderStatus("PENDING");
        orderRepo.save(order);
        return "redirect:showOrders";
    }

    @GetMapping("/orderData")
    public String getOrder()
    {  
            return "redirect:login";
    }

    @GetMapping("/customerPage")
    public String getCustomerPage(Model model)
    {
        User currentUser = (User)model.getAttribute("currentUser");
        if (currentUser == null)
            return "redirect:login";
        else if (!currentUser.getUserRole().equals("customer"))
            return "redirect:login";
        else
            return "customerpage";
    }

    //converts the topping IDs into a list or topping names
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