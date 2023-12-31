package com.Equarz.Testcases;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Pageobjects.Login_Functionality;
import com.Pageobjects.Searchdrop_Functionality;
import com.base.Testbase;

public class SearchTest extends Testbase {
	Searchdrop_Functionality sf;
	Login_Functionality Login;

	public SearchTest() {
		super();

	}

	@BeforeClass
	public void initialize() throws Throwable {
		Setup();
		Login = new Login_Functionality(driver);
		sf = new Searchdrop_Functionality(driver);
		Login.validateLogin();
	}

	@Test
	public void search1() throws Throwable {
		sf.search();
	}

	@Test
	public void drop() throws Throwable {
		sf.dropdown();
	}

	@AfterClass
	public void shutdown() {
		driver.close();
	}
   @AfterSuite
	
	public void report() throws IOException, InterruptedException {
	   Desktop.getDesktop().browse(new File("Extent.html").toURI());
		 //Desktop.getDesktop().browse(new File("C:/Users/Admin/git/Equarz/com.Equarz.Ecommerce/test-output/Extent.html").toURI());
		 Thread.sleep(3000);
		 driver.navigate().refresh();
	//file:///C:/Users/Admin/git/Equarz/com.Equarz.Ecommerce/test-output/Extent.html

}
}
