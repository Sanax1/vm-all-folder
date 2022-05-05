package org.base;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Fbloginpojo extends BaseClass {

	public Fbloginpojo() {
PageFactory.initElements(d, this);
}
	
	
	@FindBy(id ="email")
	private WebElement emailtxt;
	@FindBy(name = "pass")
	private WebElement password;
	@FindBy(name ="login")
	private WebElement loginbtn;
	public WebElement getEmailtxt() {
		return emailtxt;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
