package jp.co.rakus.stockmanagement.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.stockmanagement.domain.Member;
import jp.co.rakus.stockmanagement.form.MemberForm;
import jp.co.rakus.stockmanagement.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	
	//formを使用するため、自動的にリクエストスコープにmemberFormを作成する。
	@ModelAttribute
	public MemberForm setUpForm() {
		return new MemberForm();
	}
	//DBの処理のために　service を使う
	@Autowired
	public MemberService service;
	
	
	
	@RequestMapping("/input")
	public String input() {
		return "member/newmember";
	}
	
	//validateで制限をかけて、bindingresult でエラーをためる
	//formにエラーチェックをかける
	@RequestMapping("/create")
	public String create(@Validated MemberForm form,BindingResult result, Model model) {
		
		
		//パスワードと確認用パスワードが異なっていたらエラーを吐く
		if(  !form.getPassword().equals(form.getConfirmPassword())  ) {
			result.rejectValue("confirmPassword","","パスワードが異なります");
		}
		//メールアドレスが既に登録されているか確認
		Member confirmMemberEmail = service.findByEmail(form.getMailAddress());
		if( confirmMemberEmail != null) {
			result.rejectValue("mailAddress","","メールアドレスは既に登録されています。");
		}
		
		if(result.hasErrors()) {
			return "member/newmember";
		}
		
		
		//**  全てのエラーチェックが終わったら、正常処理に移る　　 **//
		
		
		//formの内容を memberにコピーする
		Member member = new Member();
		
		form.setPassword(service.encodePassword(form.getPassword()));
		BeanUtils.copyProperties(form,member);
		//serviceでメンバーを新規登録する
		service.save(member);
		
		return "member/newmember";
	}
	
	
}
