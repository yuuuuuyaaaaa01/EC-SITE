package jp.co.rakus.stockmanagement.domain;

public class Member {
	private Integer id;
	private String name;
	private String password;
	private String mailAddress;
	
	
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", password=" + password + ", mailAddress=" + mailAddress + "]";
	}

	public Member() {};
	
	public Member(Integer id, String name, String password, String mailAddress) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
    

	
	
	
}
