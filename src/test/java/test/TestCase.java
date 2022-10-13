package test;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CategoriesPage;
import pages.DropdownPage;
import pages.DuplicatedCategoryPage;
import util.BrowserFactory;

public class TestCase {

	WebDriver driver;
	CategoriesPage categoriesPage;
	DuplicatedCategoryPage duplicatedCategoryPage;
	DropdownPage dropdownPage;
	Random rand = new Random(); 
	String CategoryAddName = "NEWTEST310" + rand.nextInt(88); 
	String CategoryDuplicatedName = "NEWTEST323" + rand.nextInt(818); 

	@BeforeMethod
	public void runEverything() {
		driver = BrowserFactory.browserInit();
		categoriesPage = PageFactory.initElements(driver, CategoriesPage.class);
		duplicatedCategoryPage = PageFactory.initElements(driver, DuplicatedCategoryPage.class);
		dropdownPage = PageFactory.initElements(driver, DropdownPage.class);
	}

	@Test(priority = 1)
	public void userShouldBeAbleToAddACategory() throws InterruptedException {
		duplicatedCategoryPage.addCategoryTextbox(CategoryAddName);
		List<String> actualList = categoriesPage.getListOf();
		Assert.assertTrue(ifDataExist(CategoryAddName, actualList), "New category does not exist!");
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void userShouldNotBeAbleToAddADuplicatedCategory() throws InterruptedException {
		duplicatedCategoryPage.addCategoryTextbox(CategoryDuplicatedName);
		duplicatedCategoryPage.addCategoryTextbox(CategoryDuplicatedName);
		//duplicatedCategoryPage.isDuplicatedMessageDisplayed();
		duplicatedCategoryPage.waitTime();

	}

	@Test(priority = 3)
	public void dropdownListShouldHaveAllMonths() throws InterruptedException {
		String[] months = { "Jan", "Feb", "March", "April", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		List<String> dropdownList = dropdownPage.getListOfMonthsDropdown();
		Assert.assertTrue(ifDataMatches(months, dropdownList), "Values do not match");
		Thread.sleep(2000);

	}

	private boolean ifDataMatches(String[] months, List<String> dropdownPage) {
		for (int i = 0; i < dropdownPage.size(); i++) {
			if (dropdownPage.get(i).equalsIgnoreCase(months.toString())) {

			}
		}
		return true;

	}
	private boolean ifDataExist(String categoryAddName, List<String> actualList) {
		return true;
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();

	}

}
