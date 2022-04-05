package org.ncu.ecommerWebsite.controller;

import java.util.ArrayList;

import javax.validation.constraints.NotEmpty;


public class Seller {
	
	@NotEmpty(message = "This field cannot be Empty")	
private String sname;
	@NotEmpty(message = "This field cannot be Empty")
private String category;
	
private ArrayList<String> categoryOptions;
@NotEmpty(message = "This field cannot be Empty")
private String proname;

private int quantity;
private String prodesc;

private int price;
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public ArrayList<String> getCategoryOptions() {
	return categoryOptions;
}
public void setCategoryOptions(ArrayList<String> categoryOptions) {
	this.categoryOptions = categoryOptions;
}
public String getProname() {
	return proname;
}
public void setProname(String proname) {
	this.proname = proname;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getProdesc() {
	return prodesc;
}
public void setProdesc(String prodesc) {
	this.prodesc = prodesc;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

public Seller() {
	// TODO Auto-generated constructor stub
	categoryOptions = new ArrayList<String>();
	categoryOptions.add("SmartPhones");

	categoryOptions.add("SmartTv");

	categoryOptions.add("Home Appliances");

	categoryOptions.add("Books");

	categoryOptions.add("Laptops");

	categoryOptions.add("Vegetables");

	categoryOptions.add("Fruits");

	categoryOptions.add("Desktops");
	
}
}
