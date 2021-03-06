package org.task;

import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;
import java.util.Date;

import javax.swing.SpringLayout.Constraints;

import org.base.BaseClass;
import org.base.Fbloginpojo;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Return;

public class Allannotations extends BaseClass {
	// Fbloginpojo f = new Fbloginpojo();

	int i = 0;

	@BeforeClass
	public void start() {
		callchromedriver();
		callurl("https://www.facebook.com/");
		callwait(10);
		callMaxwindow();
		Allannotations a = new Allannotations();

	}



	@AfterMethod
	private void endtime() throws WebDriverException, IOException {
		Date d = new Date();
		System.err.println("test case end time" + d);
		callscreenshot("testcase" + i + "end");
	}

	@BeforeMethod
	private void Starttime() throws WebDriverException, IOException {
		Date d = new Date();
		System.out.println("test case start time" + d);
		i++;
		callscreenshot("testcase" + i + "start");
	}

	@AfterClass
	private void AtEnd() {
		callclose();
	}
static Fbloginpojo f;
	@Test
	public static void tc1() {
		Fbloginpojo f = new Fbloginpojo();
		callsendtext(f.getEmailtxt(), "forevershankar@gmail.com");
	}

	@Test
	public void tc2() {
	//Fbloginpojo f = new Fbloginpojo();
		callsendtext(f.getPassword(), "password");
	}

	@Test
	public void tc3() {
		//Fbloginpojo f = new Fbloginpojo();
		callclick(f.getLoginbtn());
	}

	@Test
	private void tc4() {
		
		String curl = callcurrentUrl();
		boolean b = curl.contains("privacy_mutation_token");
		Assert.assertFalse(b, "check the username and password");
		System.out.println("The facebook login is sucessfull");
		callTitle();
	}

}
