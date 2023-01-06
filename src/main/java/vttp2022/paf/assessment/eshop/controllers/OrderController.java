package vttp2022.paf.assessment.eshop.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import jakarta.servlet.http.HttpSession;
import vttp2022.paf.assessment.eshop.exceptions.OrderExceptions;
import vttp2022.paf.assessment.eshop.models.LineItem;
import vttp2022.paf.assessment.eshop.models.Order;

@Controller
@RequestMapping(path = "/")
public class OrderController {

	//TODO: Task 3
	@PostMapping
	public String postOrder(@RequestBody MultiValueMap<String, String> form, Model model, HttpSession sess)throws OrderExceptions{
		List<LineItem> lineItem = (List<LineItem>) sess.getAttribute("order");
		if(null == lineItem){
			lineItem = new LinkedList<>();
			sess.setAttribute("order", lineItem);
		}

		String item = form.getFirst("item");
		Integer quantity = Integer.parseInt(form.getFirst("quantity"));
		lineItem.add(new LineItem());
		Order o = new Order();
		for(LineItem li : lineItem)
		o.setLineItems(lineItem);
		sess.setAttribute("dispatch", o);
		model.addAttribute("lineItem", lineItem);

		return "dispatch";

	}
	


}
