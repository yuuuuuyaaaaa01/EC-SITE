package jp.co.rakus.stockmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.stockmanagement.domain.Member;
import jp.co.rakus.stockmanagement.form.LoginForm;
import jp.co.rakus.stockmanagement.service.MemberService;

@Controller
@RequestMapping("/login")
public class LoginController {
	//form が使用される前に、リクエストスコープに配置しておく
	@ModelAttribute
	private LoginForm setUpForm() {
		return new LoginForm();
	}
	@Autowired
	public MemberService service;
	
	@RequestMapping("/loginform")
	public String loginform() {
		return "login/loginForm";
	}
	
	@RequestMapping("/login")
	public String login(@Validated LoginForm form,BindingResult result,Model model) {
		
		//メールアドレスがあれば、値が返却される。
		Member member = service.findByEmail(form.getMailAddress() );
		if( member == null ) {
			result.rejectValue("mailAddress","","アドレスが違います");
			return "login/loginForm";
		}
		//パスワードの比較。あっていれば、trueが返却される	
		Boolean matchingPass = service.isMatchPassword(form.getPassword(),member.getPassword());
		if( !(matchingPass) ) {
			result.rejectValue("password","","パスワードが違います。");
			return "login/loginForm";
		}
		// resultにすべてのエラーが入るように if has 文を最後に置く
		if(result.hasErrors()) {
			return "login/loginForm";
		}
	
		// mail と　パスワードが一致していれば、
		return "redirect:/order/order";
	}
	
	
	
}
