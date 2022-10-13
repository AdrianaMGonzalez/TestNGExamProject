package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DuplicatedCategoryPage { //THIS IS THE METHOD 

	WebDriver driver;

	public DuplicatedCategoryPage(WebDriver driver) { //THIS IS A CONSTRUCTOR
		this.driver = driver; //THIS IS A CONSTRUCTOR
	}

	// WebElements:
	@FindBy(how = How.XPATH, using = "//input[@name='categorydata']")
	WebElement AddCategoryTextbox;

	@FindBy(how = How.XPATH, using = "//input[@value='Add category']")
	WebElement AddCategoryButton;

	@FindBy(how = How.XPATH, using = ("//*[contains(text(),'The category you want to add already exists')]"))
	WebElement DuplicatedCategory;

	// Interacting With WebElements:

	public void addCategoryTextbox(String NEWTEST310) throws InterruptedException {
		AddCategoryTextbox.sendKeys(NEWTEST310);
		Thread.sleep(2000);
		AddCategoryButton.click();

	}

	public void waitTime() {
		waitForElement(DuplicatedCategory, driver);

	}

	public void waitForElement(WebElement duplicatedCategory, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(DuplicatedCategory));
	}

	public boolean isDuplicatedMessageDisplayed() {
		try {
			waitTime();
			return true;
		} catch (Exception e) {

		}
		return false;
	}

}
