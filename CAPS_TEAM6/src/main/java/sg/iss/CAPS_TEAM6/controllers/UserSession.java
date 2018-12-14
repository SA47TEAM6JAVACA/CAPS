package sg.iss.CAPS_TEAM6.controllers;

public class UserSession {
private int usid;
	public int getUsid() {
	return usid;
}

public void setUsid(int usid) {
	this.usid = usid;
}

	private String username;
	private String pass;
	
	private String role;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserSession(String username, String pass, String role) {
		super();
		this.username = username;
		this.pass = pass;
		this.role = role;
	}

	public UserSession() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
