package sg.iss.CAPS_TEAM6.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class MenuList {
	
	private String sessionId = null;
private ArrayList<String> menuname;
private HashMap<String, String> link;

public String getSessionId() {
	return sessionId;
}
public void setSessionId(String sessionId) {
	this.sessionId = sessionId;
}
public MenuList(String sessionId, ArrayList<String> menuname, HashMap<String, String> link) {
	super();
	this.sessionId = sessionId;
	this.menuname = menuname;
	this.link = link;
}
public MenuList() {
	super();
	// TODO Auto-generated constructor stub
}
public ArrayList<String> getMenuname() {
	return menuname;
}
public void setMenuname(ArrayList<String> menuname) {
	this.menuname = menuname;
}
public HashMap<String, String> getLink() {
	return link;
}
public void setLink(HashMap<String, String> h) {
	this.link = h;
}




}
