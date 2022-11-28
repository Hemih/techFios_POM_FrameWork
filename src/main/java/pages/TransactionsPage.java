package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TransactionsPage {
	WebDriver driver;

	public TransactionsPage(WebDriver driver) {
		this.driver = driver;

	}

	// WebElement list
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Transactions')]")
	WebElement TRANSACTIONS_HEADER_ELE;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]")
	WebElement TRANSACTION_ADDED_SUCCESSFULLY_HEADER_ELE;

	// TRANSACTIONS
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement ACCOUNT_DROPDOWN_ELE;

	@FindBy(how = How.XPATH, using = "//*[@id=\"date\"]")
	WebElement DATE_INPUT_ELE;

	@FindBy(how = How.XPATH, using = "//*[@id=\"description\"]")
	WebElement DEPOSIT_DESCRIPTION_INPUT_ELE;

	@FindBy(how = How.XPATH, using = "//*[@id=\"amount\"]")
	WebElement AMOUNT_INPUT_ELE;

	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement DEPOSIT_SUBMIT_BUTTON_ELE;

	// Corresponding method
	public void validateTransactionsPage(String expectedTest) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(TRANSACTIONS_HEADER_ELE.getText(), expectedTest, "Transactions page not found!!!");
	}
	public void transactionAddedSuccessfullyPage(String expectedTest) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(TRANSACTION_ADDED_SUCCESSFULLY_HEADER_ELE.getText(), expectedTest,
				"New Account was not Created try again !!!");
	}
	/*---------Add Deposit Test Case---------------------------------------------------------------------------*/

	public void selectAccountDropdown(WebElement element, String visibleText) {
		BasePage basePage = PageFactory.initElements(driver, BasePage.class);
		basePage.selectFromDropdown(ACCOUNT_DROPDOWN_ELE, visibleText);

	}

	public void insertDepositDate(String date) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		DATE_INPUT_ELE.sendKeys(date);

	}

	public void insertDepositDescription(String description) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		DEPOSIT_DESCRIPTION_INPUT_ELE.sendKeys(description);
	}

	public void insertDepositAmount(String amount) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		AMOUNT_INPUT_ELE.sendKeys(amount);
		;
	}

	public void clickSubmitDeposit() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		DEPOSIT_SUBMIT_BUTTON_ELE.click();
	}

}
