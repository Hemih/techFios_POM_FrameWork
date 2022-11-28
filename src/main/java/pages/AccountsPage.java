package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AccountsPage {
	WebDriver driver;

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}

	// WebElement list
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Accounts')]")
	WebElement ACCOUNTS_HEADER_ELE;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]")
	WebElement ACCOUNTS_CREATED_SUCCESSFULLY_HEADER_ELE;

	// BANK AND CASH
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement ACCOUNT_TITLE_INPUT_ELE;

	@FindBy(how = How.XPATH, using = "//*[@id=\"description\"]")
	WebElement ACOUNT_DESCRIPTION_INPUT_ELE;

	@FindBy(how = How.XPATH, using = "//*[@id=\"balance\"]")
	WebElement INITIAL_BALANCE_INPUT_ELE;

	@FindBy(how = How.XPATH, using = "//*[@id=\"account_number\"]")
	WebElement ACCOUNT_NUMBER_INPUT_ELE;

	@FindBy(how = How.XPATH, using = "//*[@id=\"contact_person\"]")
	WebElement CONTACT_PERSON_INPUT_ELE;

	@FindBy(how = How.XPATH, using = "//*[@id=\"contact_phone\"]")
	WebElement CONTACT_PHONE_INPUT_ELE;

	@FindBy(how = How.XPATH, using = "//*[@id=\"ib_url\"]")
	WebElement BANK_URL_INPUT_ELE;

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button")
	WebElement ACCOUNT_SUBMIT_ELE;

	// Corresponding method
	public void validateAccountsPage(String expectedTest) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(ACCOUNTS_HEADER_ELE.getText(), expectedTest, "Accounts page not found!!!");
	}

	public void validateAccountCreatedSuccessfullyPage(String expectedTest) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(ACCOUNTS_CREATED_SUCCESSFULLY_HEADER_ELE.getText(), expectedTest,
				"New Account was not Created try again !!!");
	}

	/*---------Add Account Test Case---------------------------------------------------------------------------*/

	public void insertAccountTitle(String acctTitle) {
		ACCOUNT_TITLE_INPUT_ELE.sendKeys(acctTitle);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void insertAccountDescription(String acctDescription) {
		ACOUNT_DESCRIPTION_INPUT_ELE.sendKeys(acctDescription);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void insertInitialBal(String initalBalance) {
		INITIAL_BALANCE_INPUT_ELE.sendKeys(initalBalance);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void insertAccountNumber(String acctNum) {
		ACCOUNT_NUMBER_INPUT_ELE.sendKeys(acctNum);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void insertContactPerson(String contactName) {
		CONTACT_PERSON_INPUT_ELE.sendKeys(contactName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void insertContactPhone(String contactNum) {
		CONTACT_PHONE_INPUT_ELE.sendKeys(contactNum);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void insertBankURL(String bankURL) {
		BANK_URL_INPUT_ELE.sendKeys(bankURL);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickSubmitAccount() {
		ACCOUNT_SUBMIT_ELE.click();
	}

}
