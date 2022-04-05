package org.ncu.ecommerWebsite.controller;

import java.util.HashMap;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
	
	@NotEmpty(message = "This field cannot be Empty")
private String fname;
	
	
	@NotEmpty(message = "This field cannot be Empty")
private String lname;
	
	
	@NotEmpty(message = "This field cannot be Empty")
private String uname;
	
	
	@NotEmpty(message = "This field cannot be Empty")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$")
	@Size(min=8,max=22)
private String pass;
	
	
	@NotEmpty(message = "This field cannot be Empty")
	@Email
private String email;
	
	
	@NotEmpty(message = "This field cannot be Empty")
private String utype;
	
	
	@NotEmpty(message = "This field cannot be Empty")
private HashMap<String, String> utypeOptions;
	

public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public HashMap<String, String> getUtypeOptions() {
	return utypeOptions;
}
public void setUtypeOptions(HashMap<String, String> utypeOptions) {
	this.utypeOptions = utypeOptions;
}

public String getUtype() {
	return utype;
}
public void setUtype(String utype) {
	this.utype = utype;
}
public Customer() {
	// TODO Auto-generated constructor stub
	utypeOptions = new HashMap<String, String>();
	utypeOptions.put("seller", "Seller");
	utypeOptions.put("customer", "Customer");
}


}
