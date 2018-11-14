package jp.co.rakus.stockmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

	@RequestMapping("/order")
	public String order() {
		return "order/order";
	}
	
	
	
}
