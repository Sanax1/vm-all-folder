package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends Baseclassexcel {
	//private static final String string = null;
	protected static WebDriver d;
	
public 	static Alert al;

	public static void calledgedriver() {
		WebDriverManager.edgedriver().setup();
		d = new EdgeDriver();
	}

	public static void calldropdownbyindex(WebElement element, int index) {
		Select dropdown =new Select(element);
		dropdown.selectByIndex(index);
	}
	
	
	public static void callchromedriver() {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
	}

	public static void callscreenshot(String picname) throws WebDriverException, IOException {
		TakesScreenshot tk = (TakesScreenshot) d;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\SANAX\\eclipse-workspace\\Testnj\\screenshot\\" + picname + ".png");
		FileUtils.copyFile(src,des);
	}

	public static void callMaxwindow() {
		d.manage().window().maximize();
	}

	public static void callTitle() {
		System.out.println("The Title is \n " + d.getTitle());
	}

	public static void callurl(String pgurl) {
		d.get(pgurl);
	}

	public static String callcurrentUrl() {
		String url = d.getCurrentUrl();
		System.out.println("The current url \n" + url);
	return url;
	
	}
	
	public static void callwait(long sec) {
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	public static void callrefresh() {
		d.navigate().refresh();
	}

	public static void callsleep(int msec) throws InterruptedException {
		Thread.sleep(msec);
	}

	public static void callclose() {
		d.quit();
	}

	public static void callsendtext(WebElement element, String text) {
		element.sendKeys(text);
	}

	public static void callclick(WebElement refnameorelement) {
		refnameorelement.click();
	}

	public static String callAttributevale(WebElement element, String attname) {
		String s = element.getAttribute(attname);
		System.out.println("The "+attname+" is :\t" + s);
		return s;
	}
	public static void callmouseover(WebElement target) {
		Actions ac = new Actions(d);
		ac.moveToElement(target).perform();
	}

	public static void callrobotenter(int numberoftime) throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i < numberoftime; i++) {
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
	}

	public static void callalertok() {
		al = d.switchTo().alert();
		al.accept();
	}

	public static void callalretcancel() {
		Alert al = d.switchTo().alert();
		al.dismiss();
	}

	public static void callalerttext() {
		Alert al = d.switchTo().alert();
		System.out.println(al.getText());
	}

	public static void callalertsendk(String txt) {
		Alert al = d.switchTo().alert();
		al.sendKeys(txt);
	}

	public static void callscrolldown(WebElement refelmenttoscroll) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].scrollIntoView(true)", refelmenttoscroll);

	}

	public static void callscrollup(WebElement refelmenttoscroll) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].scrollIntoView(false)", refelmenttoscroll);

	}

	public static void callswitchframe(WebElement frameref) {
		d.switchTo().frame(frameref);
	}

	static Scanner s;

	public static void callscanner() {
		s = new Scanner(System.in);
	}

	public static String callgetstringfromuser() {

		String nextLine = s.nextLine();
		return nextLine;
	}

	
	}


