package jp.co.rakus.stockmanagement.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.stockmanagement.domain.Pizza;

@Repository
public class PizzaRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private static final RowMapper<Pizza> PIZZA_MAPPER = (rs,i) -> {
		Pizza pizza = new Pizza();
		pizza.setId(rs.getInt("id"));
		pizza.setName(rs.getString("name"));
		pizza.setPrice(rs.getString("price"));
		pizza.setImage(rs.getString("image"));
		
		return pizza;
	};
	
	
	/**
	 * pizza のメニューを全件検索.
	 * 
	 * @return
	 */
	public List<Pizza> findAll() {
		String sql = "select id,name,price,image from pizza";
		List<Pizza> pizzas = jdbcTemplate.query(sql, PIZZA_MAPPER);
		return pizzas;	
	}
	/**
	 * idでpizzaを検索.
	 * 
	 * @return
	 */
	public Pizza findById(Integer id) {
		String sql = "select id,name,price,image from pizza where id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
		Pizza pizza = jdbcTemplate.queryForObject(sql, param, PIZZA_MAPPER);
		return pizza;
	}
	
	

	
	
	
	
}
