package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.AccountsPage;
import pages.BasePage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.TransactionsPage;
import util.BrowserFactory;
import util.ReadExcel;

public class TC003_AddDepositTest {

	WebDriver driver;
	WebElement element;

	ReadExcel exlRead = new ReadExcel("mockData\\HomeWork _ Test Cases _ Test Data.xlsx");
	// TestData
	String username = exlRead.getCellData("Test Cases", "Test Data Info", 4);
	String password = exlRead.getCellData("Test Cases", "Test Data Info", 5);
	String dashboardValidText = exlRead.getCellData("Test Cases", "Test Data Info", 7);

	String accountsValidText = exlRead.getCellData("AddAccount", "PageValidation", 2);
	String acctTitle = exlRead.getCellData("AddAccount", "Enter Account Title (Required)", 3);
	String acctDescription = exlRead.getCellData("AddAccount", "Enter Description", 3);
	String initalBalance = exlRead.getCellData("AddAccount", "Enter Initial Balance", 3);
	String acctNum = exlRead.getCellData("AddAccount", "Enter Account Number", 3);
	String contactName = exlRead.getCellData("AddAccount", "Enter Contact Person", 3);
	String contactNum = exlRead.getCellData("AddAccount", "Enter Phone no.", 3);
	String bankURL = exlRead.getCellData("AddAccount", "Enter Internet Banking URL", 3);

	String accounts_created_successfully_ValidText = exlRead.getCellData("AddAccount", "PageValidation", 3);

	String transactionsValidText = exlRead.getCellData("AddDeposit", "PageValidation", 2);
	
	String description = exlRead.getCellData("AddDeposit", "Deposit Description", 2);
	String amount = exlRead.getCellData("AddDeposit", "Deposit Amount", 2);
	
	String transactionAddedSuccessfully = exlRead.getCellData("AddDeposit", "PageValidation", 3);
	

	@Test(priority = 1)
	public void userShouldBeAbleToAddDeposit() {
		driver = BrowserFactory.init();
		BasePage basePage = PageFactory.initElements(driver, BasePage.class);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		AccountsPage accountsPage = PageFactory.initElements(driver, AccountsPage.class);
		TransactionsPage transactionPage = PageFactory.initElements(driver, TransactionsPage.class);
		

		int randoNum2 = basePage.generateRndomNum(99);
		int randoNum3 = basePage.generateRndomNum(999);
		int randoNum4 = basePage.generateRndomNum(9999);
		int randoNum5 = basePage.generateRndomNum(99999);
		//Login
		loginPage.insertUserName(username);
		loginPage.insertPassword(password);
		loginPage.clickSignInButton();
		dashboardPage.validateDashboardPage(dashboardValidText);
		//Go to AccontsPage
		dashboardPage.clickBankCashMenuButton();
		dashboardPage.clickNewAccountMenuButton();
		String accountTitle = acctTitle + randoNum3 + " JAVA_TechFios";
		//Enter Create New Account
		accountsPage.validateAccountsPage(accountsValidText);
		accountsPage.insertAccountTitle(accountTitle);
		accountsPage.insertAccountDescription(acctDescription);
		accountsPage.insertInitialBal(initalBalance + randoNum5);
		accountsPage.insertAccountNumber(acctNum + randoNum4 + randoNum2);
		accountsPage.insertContactPerson(contactName);
		accountsPage.insertContactPhone(contactNum + randoNum3 + " - " + randoNum4);
		accountsPage.insertBankURL(bankURL);
		//Pull newly created account name to add deposit
		basePage.takeScreenshot(driver);
		String newAccountTitle = accountTitle;
//		String date = basePage.GetDate();
		//Verify Account Created Successfully
		accountsPage.clickSubmitAccount();
		accountsPage.validateAccountCreatedSuccessfullyPage(accounts_created_successfully_ValidText);
		//Go to Transactions Page
		dashboardPage.clickTransactionMenuButton();
		dashboardPage.clickNewDepositMenuButton();
		//Enter New Deposit info into newly created account
		transactionPage.validateTransactionsPage(transactionsValidText);
		transactionPage.selectAccountDropdown(element, newAccountTitle);
//		transactionPage.insertDepositDate(date);
		transactionPage.insertDepositDescription(description + randoNum3);
		transactionPage.insertDepositAmount(amount +randoNum3);
		basePage.takeScreenshot(driver);
		transactionPage.clickSubmitDeposit();
		transactionPage.transactionAddedSuccessfullyPage(transactionAddedSuccessfully);
		basePage.takeScreenshot(driver);
		
		BrowserFactory.tearDown();

	}
}
