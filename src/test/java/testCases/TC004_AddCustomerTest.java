package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.AccountsPage;
import pages.BasePage;
import pages.ContactsPage;
import pages.DashboardPage;
import pages.LoginPage;
import util.BrowserFactory;
import util.ReadExcel;

public class TC004_AddCustomerTest {
	WebDriver driver;
	WebElement element;

	ReadExcel exlRead = new ReadExcel("mockData\\HomeWork _ Test Cases _ Test Data.xlsx");
	// TestData
	String username = exlRead.getCellData("Test Cases", "Test Data Info", 4); 
	String password = exlRead.getCellData("Test Cases", "Test Data Info", 5);
	String dashboardValidText = exlRead.getCellData("Test Cases", "Test Data Info", 7);
	
	String accountsValidText = exlRead.getCellData("AddAccount","PageValidation",2);
	String acctTitle = exlRead.getCellData("AddAccount","Enter Account Title (Required)",2);
	String acctDescription = exlRead.getCellData("AddAccount","Enter Description",2);
	String initalBalance = exlRead.getCellData("AddAccount","Enter Initial Balance",2);
	String acctNum = exlRead.getCellData("AddAccount","Enter Account Number",2);
	String contactName = exlRead.getCellData("AddAccount","Enter Contact Person",2);
	String contactNum = exlRead.getCellData("AddAccount","Enter Phone no.",2);
	String bankURL = exlRead.getCellData("AddAccount","Enter Internet Banking URL",2);
	String accounts_created_successfully_ValidText = exlRead.getCellData("AddAccount","PageValidation",3);
	
	String contactValidText = exlRead.getCellData("AddContactInfo", "PageValidation", 2);
	String fullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
	String companyName = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlRead.getCellData("AddContactInfo", "Email", 2);
	String address = exlRead.getCellData("AddContactInfo", "Address", 2);
	String city = exlRead.getCellData("AddContactInfo", "City", 2);
	String country = exlRead.getCellData("AddContactInfo", "Country", 2);
	String state = exlRead.getCellData("AddContactInfo", "State", 2);
	String zip = exlRead.getCellData("AddContactInfo", "Zip", 2);
	String tag = exlRead.getCellData("AddContactInfo", "Tag", 2);
	String group = exlRead.getCellData("AddContactInfo", "Group", 2);
	String password01 = exlRead.getCellData("AddContactInfo", "Password", 2);
	String password02 = exlRead.getCellData("AddContactInfo", "Confirm Password", 2);
	String currency = exlRead.getCellData("AddContactInfo", "Currency", 2);

	@Test(priority = 1)
	public void userShouldBeAbleToAddCustomer() {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		BasePage basePage = PageFactory.initElements(driver, BasePage.class);
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		ContactsPage contactsPage = PageFactory.initElements(driver, ContactsPage.class);
		AccountsPage accountsPage = PageFactory.initElements(driver, AccountsPage.class);
		
		int randoNum2 = basePage.generateRndomNum(99);
		int randoNum3 = basePage.generateRndomNum(999);
		int randoNum4 = basePage.generateRndomNum(9999);
		int randoNum5 = basePage.generateRndomNum(99999);
		String phone = contactNum + randoNum4 ;
		String fullName01 = acctTitle + randoNum3 +fullName ;
		String newContact = fullName01;
		
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
		//ScreenShot Data created
		basePage.takeScreenshot(driver);
		//Submit
		accountsPage.clickSubmitAccount();
		//Account created Successfully
		accountsPage.validateAccountCreatedSuccessfullyPage(accounts_created_successfully_ValidText);
		basePage.takeScreenshot(driver);
		
		//Go to Contacts page
		dashboardPage.clickCustomerMenuButton();
		dashboardPage.clickAddCustomerMenuButton();
		//Fill in Account info 
		contactsPage.validateContactsPage(contactValidText);
		contactsPage.insertFullName(fullName01);
		contactsPage.selectCompanyDropdown(element, companyName);
		contactsPage.insertEmail(email+randoNum4 + "@gmail.com");
		contactsPage.insertPhone(phone);
		contactsPage.insertAddress(address);
		contactsPage.insertCity(city);
		contactsPage.insertState(state);
		contactsPage.insertZip(zip);
		contactsPage.selectCountryDropdown(element, country);
		contactsPage.enterTags(element, tag);
		contactsPage.selectCurrencyDropdown(element, currency);
		contactsPage.selectGroupDropdown(element, group);
		contactsPage.enterPassword(password01);
		contactsPage.enterConfirmPassword(password02);
		basePage.takeScreenshot(driver);
		//Submit
		contactsPage.clickSaveButton();
		//Contact created Successfully
		contactsPage.createdSuccessfullyContactsPage(newContact);
		basePage.takeScreenshot(driver);
		//Close Browser
		BrowserFactory.tearDown();
	}
}
