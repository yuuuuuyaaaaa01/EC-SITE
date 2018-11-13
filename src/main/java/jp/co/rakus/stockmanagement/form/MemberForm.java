package jp.co.rakus.stockmanagement.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 *memberを新規作成するform.
 * 
 * @author yuya.nishikiori
 *
 */
public class MemberForm {
	@NotEmpty(message="必須項目です")
	private String name;
	@NotEmpty(message="必須項目です")
	private String password;
	
	@Email(message="Emailの形式で入力してください")
	@NotEmpty(message="必須項目です")
	private String mailAddress;
	@NotEmpty(message="必須項目です")
	private String confirmPassword;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
}
