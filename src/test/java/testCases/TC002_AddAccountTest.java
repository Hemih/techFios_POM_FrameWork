package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.AccountsPage;
import pages.BasePage;
import pages.DashboardPage;
import pages.LoginPage;
import util.BrowserFactory;
import util.ReadExcel;

public class TC002_AddAccountTest {
	
	WebDriver driver;
	
	ReadExcel exlRead = new ReadExcel("mockData\\HomeWork _ Test Cases _ Test Data.xlsx");
	//TestData
	String username = exlRead.getCellData("Test Cases","Test Data Info",4); //username in test data
	String password = exlRead.getCellData("Test Cases","Test Data Info",5);//password in test data
	String dashboardValidText = exlRead.getCellData("Test Cases", "Test Data Info", 7);//Dashboard
	String accountsValidText = exlRead.getCellData("AddAccount","PageValidation",2);
	String acctTitle = exlRead.getCellData("AddAccount","Enter Account Title (Required)",2);
	String acctDescription = exlRead.getCellData("AddAccount","Enter Description",2);
	String initalBalance = exlRead.getCellData("AddAccount","Enter Initial Balance",2);
	String acctNum = exlRead.getCellData("AddAccount","Enter Account Number",2);
	String contactName = exlRead.getCellData("AddAccount","Enter Contact Person",2);
	String contactNum = exlRead.getCellData("AddAccount","Enter Phone no.",2);
	String bankURL = exlRead.getCellData("AddAccount","Enter Internet Banking URL",2);
	String accounts_created_successfully_ValidText = exlRead.getCellData("AddAccount","PageValidation",3);
	String acctTitle02 = exlRead.getCellData("AddAccount","Enter Account Title (Required)",3);
	String acctDescription02 = exlRead.getCellData("AddAccount","Enter Description",3);
	String initalBalance02 = exlRead.getCellData("AddAccount","Enter Initial Balance",3);
	String acctNum02 = exlRead.getCellData("AddAccount","Enter Account Number",3);
	String contactName02 = exlRead.getCellData("AddAccount","Enter Contact Person",3);
	String contactNum02 = exlRead.getCellData("AddAccount","Enter Phone no.",3);
	String bankURL02 = exlRead.getCellData("AddAccount","Enter Internet Banking URL",3);
	
	@Test (priority = 1)
	public void userShouldBeAbleToAddAccount() {
		driver = BrowserFactory.init();
		BasePage basePage = PageFactory.initElements(driver, BasePage.class);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		AccountsPage accountsPage = PageFactory.initElements(driver, AccountsPage.class);
		
		int randoNum2 = basePage.generateRndomNum(99);
		int randoNum3 = basePage.generateRndomNum(999);
		int randoNum4 = basePage.generateRndomNum(9999);
		int randoNum5 = basePage.generateRndomNum(99999);
		
		// Login
		loginPage.insertUserName(username);
		loginPage.insertPassword(password);
		loginPage.clickSignInButton();
		dashboardPage.validateDashboardPage(dashboardValidText);
		//Go to Accounts Page
		dashboardPage.clickBankCashMenuButton();
		dashboardPage.clickNewAccountMenuButton();
		//Fill in Account info 
		accountsPage.validateAccountsPage(accountsValidText);
		accountsPage.insertAccountTitle(acctTitle + randoNum3);
		accountsPage.insertAccountDescription(acctDescription + randoNum2);
		accountsPage.insertInitialBal(initalBalance + randoNum4);
		accountsPage.insertAccountNumber(acctNum + randoNum5);
		accountsPage.insertContactPerson(contactName);
		accountsPage.insertContactPhone(contactNum + randoNum4);
		accountsPage.insertBankURL(bankURL);
		basePage.takeScreenshot(driver);
		//Submit
		accountsPage.clickSubmitAccount();
		//Account created Successfully
		accountsPage.validateAccountCreatedSuccessfullyPage(accounts_created_successfully_ValidText);
		basePage.takeScreenshot(driver);
		//Close Browser
		BrowserFactory.tearDown();
		
	}

	@Test (priority = 2)
	public void userShouldBeAbleToAddAccount_tc02() {
		driver = BrowserFactory.init();
		BasePage basePage = PageFactory.initElements(driver, BasePage.class);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		AccountsPage accountsPage = PageFactory.initElements(driver, AccountsPage.class);
		int randoNum2 = basePage.generateRndomNum(99);
		int randoNum3 = basePage.generateRndomNum(999);
		int randoNum4 = basePage.generateRndomNum(9999);
		int randoNum5 = basePage.generateRndomNum(99999);
		// Login
		loginPage.insertUserName(username);
		loginPage.insertPassword(password);
		loginPage.clickSignInButton();
		dashboardPage.validateDashboardPage(dashboardValidText);
		//Go to Accounts Page
		dashboardPage.clickBankCashMenuButton();
		dashboardPage.clickNewAccountMenuButton();
		//Fill in Account info 
		accountsPage.validateAccountsPage(accountsValidText);
		accountsPage.insertAccountTitle(acctTitle02 + randoNum3 );
		accountsPage.insertAccountDescription(acctDescription02);
		accountsPage.insertInitialBal(initalBalance02 +randoNum5);
		accountsPage.insertAccountNumber(acctNum02 + randoNum4 + randoNum2);
		accountsPage.insertContactPerson(contactName02);
		accountsPage.insertContactPhone(contactNum02+randoNum3 + " - "+ randoNum4);
		accountsPage.insertBankURL(bankURL02);
		basePage.takeScreenshot(driver);
		//Submit
		accountsPage.clickSubmitAccount();
		//Account created Successfully
		accountsPage.validateAccountCreatedSuccessfullyPage(accounts_created_successfully_ValidText);
		basePage.takeScreenshot(driver);
		//Close Browser
		BrowserFactory.tearDown();
		
	}
}
