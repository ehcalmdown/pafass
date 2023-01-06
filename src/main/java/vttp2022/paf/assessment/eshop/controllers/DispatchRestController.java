package vttp2022.paf.assessment.eshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp2022.paf.assessment.eshop.models.LineItem;
import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.respositories.OrderRepository;

@RestController
@RequestMapping(path = "http://paf.chuklee.com/dispatch/{orderId}")
public class DispatchRestController {
    @Autowired
    private OrderRepository orderRepo;

    @PostMapping
    public String postDispatch(@RequestBody MultiValueMap<String, String> form, Model model){
        String orderId = form.getFirst("orderId");
        String name = form.getFirst("name");
        String address = form.getFirst("address");
        String email = form.getFirst("email");
        LineItem li = new LineItem(
            name, 
        );
        Order dispatchedOrder = orderRepo.saveOrderDetails
        
    }
}
