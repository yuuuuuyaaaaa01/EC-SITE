package jp.co.rakus.stockmanagement.form;

import javax.validation.constraints.NotEmpty;

public class LoginForm {
	@NotEmpty(message="必須項目です")
	private String mailAddress;
	@NotEmpty(message="必須項目です")
	private String password;
	
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	
	
}
