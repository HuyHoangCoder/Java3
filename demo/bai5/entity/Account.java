package bai5.entity;

public class Account {
	private String username;
	private String pass;
	private String fullname;

	public Account() {
	}

	public Account(String username, String pass, String fullname) {
		this.username = username;
		this.pass = pass;
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public String toString() {
		return "Account{" + "username=" + username + ", pass=" + pass + ", fullname=" + fullname + '}';
	}
	
	
}
