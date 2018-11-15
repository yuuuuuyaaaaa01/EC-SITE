package jp.co.rakus.stockmanagement.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.stockmanagement.domain.Pizza;
import jp.co.rakus.stockmanagement.repository.PizzaRepository;

@Service
public class PizzaService {
	
	@Autowired
	public PizzaRepository repository;
	
	@Autowired
	public HttpSession session;
	
	
	public List<Pizza> findAll() {
		return repository.findAll();
	}
	public Pizza findById(Integer id) {
		return repository.findById(id);
	}
	
	/**
	 * カートに入っている合計金額を返却する.
	 * 
	 * @return
	 */
	public Integer AllPrice() {
		List<Pizza> cartItems = (List<Pizza>) session.getAttribute("cartItems");
		
		Integer totalPrice = 0;
		for(Pizza cartItem:cartItems) {
			 totalPrice += Integer.parseInt(cartItem.getPrice());
		}
		return totalPrice;
	}
	
	
}
