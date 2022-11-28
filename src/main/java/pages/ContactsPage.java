package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactsPage {
	WebDriver driver;

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
	}

	// WebElement list
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	WebElement CONTACTS_HEADER_ELE;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[2]/div[2]/div/div[1]/h5")
	WebElement NEWCONTACTS_HEADER_ELE;
	// CUSTOMERS
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULLNAME_INPUT_ELE;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_DROPDOWN_ELE;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_INPUT_ELE;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_INPUT_ELE;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_INPUT_ELE;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_INPUT_ELE;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_INPUT_ELE;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_INPUT_ELE;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTRY_DROPDOWN_INPUT_ELE;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tags\"]")
	WebElement TAGS_INPUT_ELE;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"currency\"]")
	WebElement CURRENCY_DROPDOWN_INPUT_ELE;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"group\"]")
	WebElement GROUP_DROPDOWN_INPUT_ELE;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	WebElement PASSWORD_INPUT_ELE;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"cpassword\"]")
	WebElement CONFIRM_PASSWORD_INPUT_ELE;
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SAVE_BUTTON_ELE;
	

	// Corresponding method
	public void validateContactsPage(String expectedTest) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(CONTACTS_HEADER_ELE.getText(), expectedTest, "Contacts page not found!!!");
	}
	public void createdSuccessfullyContactsPage(String expectedTest) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(NEWCONTACTS_HEADER_ELE.getText(), expectedTest, "Contacts page not found!!!");
	}

	/*--------Add Customer Test Case---------------------------------------------------------------------------*/
	// Corresponding method
		public void insertFullName(String fullName) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			FULLNAME_INPUT_ELE.sendKeys(fullName);
		}

		public void selectCompanyDropdown(WebElement element, String visibleText) {
			BasePage basePage = PageFactory.initElements(driver, BasePage.class);
			basePage.selectFromDropdown(COMPANY_DROPDOWN_ELE, visibleText);
		}
		

		public void insertEmail(String email) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			EMAIL_INPUT_ELE.sendKeys(email);
		}

		public void insertPhone(String phone) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			PHONE_INPUT_ELE.sendKeys(phone);
		}

		public void insertAddress(String address) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ADDRESS_INPUT_ELE.sendKeys(address);
		}

		public void insertCity(String city) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			CITY_INPUT_ELE.sendKeys(city);
		}

		public void insertState(String state) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			STATE_INPUT_ELE.sendKeys(state);
		}

		public void insertZip(String zip) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ZIP_INPUT_ELE.sendKeys(zip);
		}

		public void selectCountryDropdown(WebElement element, String visibleText) {
			BasePage basePage = PageFactory.initElements(driver, BasePage.class);
			basePage.selectFromDropdown(COUNTRY_DROPDOWN_INPUT_ELE, visibleText);
		}
		
		public void enterTags(WebElement element, String visibleText) {
			BasePage basePage = PageFactory.initElements(driver, BasePage.class);
			basePage.selectFromDropdown(TAGS_INPUT_ELE, visibleText);
		}
		public void selectCurrencyDropdown(WebElement element, String visibleText) {
			BasePage basePage = PageFactory.initElements(driver, BasePage.class);
			basePage.selectFromDropdown(CURRENCY_DROPDOWN_INPUT_ELE, visibleText);
		}
		public void selectGroupDropdown(WebElement element, String visibleText) {
			BasePage basePage = PageFactory.initElements(driver, BasePage.class);
			basePage.selectFromDropdown(GROUP_DROPDOWN_INPUT_ELE, visibleText);
		}
		public void enterPassword(String password01) {
			PASSWORD_INPUT_ELE.sendKeys(password01);
			
		}
		public void enterConfirmPassword(String password02) {
			CONFIRM_PASSWORD_INPUT_ELE.sendKeys(password02);
		}
		
		
		
		
		public void clickSaveButton() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			SAVE_BUTTON_ELE.click();
		}
}