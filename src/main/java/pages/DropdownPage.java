package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

	WebDriver driver;

	public DropdownPage(WebDriver driver) {
		this.driver = driver;

	}

	// WebElement:
	@FindBy(how = How.CSS, using = "body:nth-child(2) div.advance-controls:nth-child(4) span:nth-child(3) > select:nth-child(3)")
	WebElement MonthsDropdown;

	public List<String> getListOfMonthsDropdown() {
		List<String> actualDropdownValues = new ArrayList<String>();
		Select dropdown = new Select(MonthsDropdown);
		List<WebElement> dropdownValues = dropdown.getOptions();
		for (int i = 0; i < dropdownValues.size(); i++) {
			actualDropdownValues.add(i, dropdownValues.get(i).getText());
		}
		return actualDropdownValues;

	}

}
