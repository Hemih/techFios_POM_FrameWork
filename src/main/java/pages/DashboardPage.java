package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// WebElement list
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]")
	WebElement DASHBOARD_HEADER_ELE;
	// CUSTOMERS
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a")
	WebElement CUSTOMER_MENU_ELE;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")
	WebElement ADD_CUSTOMER_MENU_ELE;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")
	WebElement LIST_CUSTOMER_MENU_ELE;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[3]/a")
	WebElement CUSTOMER_GROUP_MENU_ELE;

	// TRANSACTIONS
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[5]/a")
	WebElement TRANSACTIONS_MENU_ELE;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[5]/ul/li[1]/a")
	WebElement NEW_DEPOSIT_MENU_ELE;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[5]/ul/li[2]/a")
	WebElement NEW_EXPENSE_MENU_ELE;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[5]/ul/li[3]/a")
	WebElement TRANSFER_MENU_ELE;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[5]/ul/li[4]/a")
	WebElement VIEW_TRANSACTIONS_MENU_ELE;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[5]/ul/li[5]/a")
	WebElement BALANCE_SHEET_MENU_ELE;

	// BANK AND CASH
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/a/span[1]")
	WebElement BANK_CASH_MENU_ELE;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a")
	WebElement NEW_ACCOUNT_MENU_ELE;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/ul/li[2]/a")
	WebElement LIST_ACCOUNT_MENU_ELE;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/ul/li[3]/a")
	WebElement ACCOUNT_BALANCE_MENU_ELE;

	// Corresponding method
	public void validateDashboardPage(String expectedTest) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(DASHBOARD_HEADER_ELE.getText(), expectedTest, "Dashboard page not found!!!");
	}

	/*--------Add Customer Test Case---------------------------------------------------------------------------*/
	public void clickCustomerMenuButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CUSTOMER_MENU_ELE.click();
	}

	public void clickAddCustomerMenuButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ADD_CUSTOMER_MENU_ELE.click();
	}

	public void clickListCustomerMenuButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LIST_CUSTOMER_MENU_ELE.click();
	}

	public void clickCustomerGroupMenuButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CUSTOMER_GROUP_MENU_ELE.click();
	}

	/*---------Add Account Test Case---------------------------------------------------------------------------*/

	public void clickBankCashMenuButton() {
		BANK_CASH_MENU_ELE.click();
	}

	public void clickNewAccountMenuButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		NEW_ACCOUNT_MENU_ELE.click();
	}

	public void clickListAccountMenuButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LIST_ACCOUNT_MENU_ELE.click();
	}

	/*---------Add Deposit Test Case---------------------------------------------------------------------------*/

	public void clickTransactionMenuButton() {
		TRANSACTIONS_MENU_ELE.click();
	}

	public void clickNewDepositMenuButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		NEW_DEPOSIT_MENU_ELE.click();
	}

	public void clickNewExpenseMenuButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		NEW_EXPENSE_MENU_ELE.click();
	}

	public void clickTransferMenuButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TRANSFER_MENU_ELE.click();
	}

	public void clickViewTransactionsMenuButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		VIEW_TRANSACTIONS_MENU_ELE.click();
	}

	public void clickBalanceSheetMenuButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BALANCE_SHEET_MENU_ELE.click();
	}

}
