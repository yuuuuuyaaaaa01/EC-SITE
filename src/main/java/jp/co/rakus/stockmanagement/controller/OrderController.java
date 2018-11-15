package jp.co.rakus.stockmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.stockmanagement.domain.Pizza;
import jp.co.rakus.stockmanagement.service.PizzaService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private PizzaService service;
	
	//sessionスコープを作成
	@Autowired
	private HttpSession session;
	
	//カートにアイテムを追加する。
	List<Pizza> cartItems = new ArrayList<>();
	
	
	@RequestMapping("/order")
	public String order(Model model) {
		//カートのアイテムを複数いれるためのリストを容易
		session.setAttribute("cartItems",cartItems);
		
		List<Pizza> pizzas = service.findAll();
		model.addAttribute("pizzas",pizzas);
		return "order/order";
	}
	
	//カートに入れる処理
	@RequestMapping("/cart")
	public String cart(Integer id) {
		
		System.out.println("id"+id);
		Pizza pizza = service.findById(id);
		System.out.println("pizzacart"+pizza.toString());
		
		List<Pizza> cartItems = (List<Pizza>) session.getAttribute("cartItems");
		cartItems.add(pizza);
		
		return "redirect:/order/cartList";
	}
	
	//カートの中身を見る
	@RequestMapping("/cartList")
	public String cartList() {
		Integer totalPrice = service.AllPrice();
		session.setAttribute("totalPrice",totalPrice);
		return "order/cartlist";
	}
	
	/**
	 * sessionスコープに入っている一時的なカートの中身を削除する.
	 * 
	 * @param index
	 * @return
	 */
	@RequestMapping("/delete")
	public String deleteCartItem(int index) {
		List<Pizza> cartItems = (List<Pizza>) session.getAttribute("cartItems");
		cartItems.remove(index);	
		return "redirect:/order/cartList";
	}
	
	
	
}
