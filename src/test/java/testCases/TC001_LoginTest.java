package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.DashboardPage;
import pages.LoginPage;
import util.BrowserFactory;
import util.ReadExcel;

public class TC001_LoginTest {

	WebDriver driver;
	
	ReadExcel exlRead = new ReadExcel("mockData\\HomeWork _ Test Cases _ Test Data.xlsx");
	//TestData
	String username = exlRead.getCellData("Test Cases","Test Data Info",4); //username in test data
	String password = exlRead.getCellData("Test Cases","Test Data Info",5);//password in test data
	String dashboardValidText = exlRead.getCellData("Test Cases", "Test Data Info", 7);//Dashboard
	
	@Test (priority = 1)
	public void userShouldBeAbleToLogin(){
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		BasePage basePage = PageFactory.initElements(driver, BasePage.class);
		//Login
		loginPage.insertUserName(username);
		loginPage.insertPassword(password);
		loginPage.clickSignInButton();
		//Validate Successful Login to Dashboard Page
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardValidText);
		basePage.takeScreenshot(driver);
		//Close Browser
		BrowserFactory.tearDown();
		
	}

}
