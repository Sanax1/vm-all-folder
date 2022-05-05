package testnj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class NewTest {
  @Test
  public void f() {
	  System.err.println("dsssd");
  }
  @BeforeMethod
  public void beforeMethod() {
  System.err.println("asdas");
  }

  @AfterMethod
  public void afterMethod() {  System.err.println("asdas");

  }

  @BeforeClass
  public void beforeClass() {  System.err.println("asdas");

  }

  @AfterClass
  public void afterClass() {  System.err.println("asdas");

  }

}
