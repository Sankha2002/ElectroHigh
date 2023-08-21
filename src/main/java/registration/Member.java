package registration;

public class Member {
	private String name,mn,password,email;
	

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Member(String name, String mn, String password, String email) {
		super();
		this.name = name;
		this.mn = mn;
		this.password = password;
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMn() {
		return mn;
	}


	public void setMn(String mn) {
		this.mn = mn;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	

	
	
}
