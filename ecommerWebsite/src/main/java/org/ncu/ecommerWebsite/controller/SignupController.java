package org.ncu.ecommerWebsite.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("Seller")
@RequestMapping("/SignupController")
public class SignupController {
	@ModelAttribute("Customer")
	public Customer fetchedData() {
		return new Customer();
	}
	
	
	@ModelAttribute("Seller")
	public Seller fetchedSellingData() {
		return new Seller();
	}
	
	
	
	@RequestMapping("/SignupMe")
	public String showSignupform() {
		return "Signup-form";
	}
	
	@RequestMapping("/buyItem")
	public String buyThis(HttpSession session1,Model model,HttpServletRequest request) {
		request.getSession();
		double n = (int) session1.getAttribute("ProductPrice");
		model.addAttribute("proP",n);
		double tax = n*(0.18);
		n = n+tax;
		model.addAttribute("aftertax",n);
		model.addAttribute("sname",session1.getAttribute("SellerName"));
		model.addAttribute("cate",session1.getAttribute("Category"));
		model.addAttribute("ProN",session1.getAttribute("ProductName"));
		model.addAttribute("Qty",session1.getAttribute("Quantity"));
		model.addAttribute("proD",session1.getAttribute("ProductDescription"));

model.addAttribute("id",session1.getAttribute("ItemId"));
		return "checkOut";
	}
	
	
	@RequestMapping("/SellMe")
	public String UploadNewItems(Model M,@CookieValue("name")String name) {
		/*
		 * Cookie[] cookie = request.getCookies(); String name=" "; int n =
		 * cookie.length; for(int i=0;i<n;i++) { if (cookie[i].equals("uname")) { name =
		 * cookie[i].getValue(); } }
		 */
		M.addAttribute("name",name);
		return "AddnewItems";
	}
	
	@RequestMapping("/HomePage")
	public String directHome() {
		return "HomePage";
	}
	
	
	@RequestMapping("/BuyMe")
	public String SeeItems(HttpSession session1,Model model) {
		model.addAttribute("sname",session1.getAttribute("SellerName"));
		model.addAttribute("cate",session1.getAttribute("Category"));
		model.addAttribute("ProN",session1.getAttribute("ProductName"));
		model.addAttribute("Qty",session1.getAttribute("Quantity"));
		model.addAttribute("proD",session1.getAttribute("ProductDescription"));
model.addAttribute("proP",session1.getAttribute("ProductPrice"));
model.addAttribute("id",session1.getAttribute("ItemId"));
		
		return "ViewItems";
	}
	
	@RequestMapping(value="/Addme")
	public String AddNewItems(@Valid @ModelAttribute("Seller")Seller seller,BindingResult result,Model M,HttpSession session1,HttpServletRequest request) throws IOException {
		
		if(result.hasErrors()) {
			return "AddnewItems";
	     }else {
	    	 int random = (int)(Math.random()*(999-2+1)+2);  
	    	 M.addAttribute("itemId",random);
	    	 FileWriter fw=new FileWriter("E:\\Downloads\\items.txt", true);
	    	 fw.write(seller.getSname());
	    	 fw.write(" | ");
	           fw.write(seller.getProname());
	           fw.write(" | ");
	           fw.write(seller.getPrice());
	           fw.write(" |");
	           fw.close(); 
	           request.getSession();
	           ArrayList<String> list = new ArrayList<String>();
	          
	          session1.setAttribute("SellerName",seller.getSname() ); 
	          session1.setAttribute("Category",seller.getCategory() ); 
	          session1.setAttribute("ProductName",seller.getProname() ); 
	          session1.setAttribute("Quantity",seller.getQuantity() ); 
	          session1.setAttribute("ProductDescription",seller.getProdesc() ); 
	          session1.setAttribute("ProductPrice",seller.getPrice() ); 
	          session1.setAttribute("ItemId",random); 
	    	 return "ItemStatus";
	    	 }
	}
	
	
	@RequestMapping("/SignupStatus")
	public String showSignupStatus(@Valid @ModelAttribute("Customer")Customer cstm,BindingResult result,Model M,HttpServletResponse response) throws IOException {
		Cookie namecookie = new Cookie("name", cstm.getFname());
		namecookie.setMaxAge(60);
		response.addCookie(namecookie);
		
		Cookie usernamecookie = new Cookie("uname", cstm.getUname());
		usernamecookie.setMaxAge(100);
		response.addCookie(usernamecookie);
		
		Cookie passwordcookie = new Cookie("pass", cstm.getPass());
		passwordcookie.setMaxAge(100);
		response.addCookie(passwordcookie);
		
		 if(result.hasErrors()) {
	         return "Signup-form";
	     }else {
	    	     
	    	 if (cstm.getUtype().equals("seller")) {
	    		 
	    		 FileWriter fw=new FileWriter("E:\\Downloads\\fileOne.txt",true);    
		           fw.write(cstm.getUname());
		           fw.write("\n ");
		           fw.write(cstm.getPass());
		           fw.write("\n");
		           fw.close(); 
		           M.addAttribute("username",cstm.getFname() );
				return "HomePage";
			}else {
				FileWriter fw=new FileWriter("E:\\Downloads\\file.txt",true);    
		           fw.write(cstm.getUname()+"\n");
		           fw.write("\n");
		           fw.write(cstm.getPass());
		           fw.write("\n");
		           fw.close(); 
				return "HomePageCustomer";
			}
	    	 
	    	
		}
	}
	
	
	@RequestMapping("/LoginMe")
	public String showLoginform( Model M,HttpSession session,HttpServletRequest request) throws FileNotFoundException {
		
		String unameString = request.getParameter("fname");
		String passString = request.getParameter("lname");
			File file = new File("E:\\Downloads","file.txt");
			boolean First = false;
			boolean Second = false;
			try (Scanner myReader = new Scanner(file)) {
				while (myReader.hasNext()) {
					String string = (String) myReader.next();
					if (string.equals(unameString)) {
						System.out.println(unameString);
						First = true;
					}
					if (string.equals(passString)) {
						System.out.println(passString);
						Second = true;
					}
				}
			}
			if (First==true && Second==true) {
				request.getSession();
				session.setAttribute("customerUserName", unameString);
				session.setAttribute("customerPassword", passString);
M.addAttribute("username",unameString);
				return "HomePageCustomer";
			}else {
				System.out.println(unameString);
				System.out.println(passString);
				return "Invalid";
			}
		}
		
		
	
	
	@RequestMapping("/ExpireSession")
	public String expireSession(@ModelAttribute("Customer")Customer cstm,Model M,HttpSession session) {

		M.addAttribute("customername",cstm.getFname());
		return "Logout";
	}
	
	@RequestMapping("/expiremySession")
	public String expiremySession(@ModelAttribute("Customer")Customer cstm,Model M,HttpSession session) {
session.invalidate();
		M.addAttribute("customername",cstm.getFname());
		return "Logout";
	}
	
}
