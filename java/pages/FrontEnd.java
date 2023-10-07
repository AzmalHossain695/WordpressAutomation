package pages;

import org.openqa.selenium.By;
import aquality.selenium.browser.AqualityServices;

public class FrontEnd {
	
	public boolean isDarkModeWorking() {
		return AqualityServices.getElementFactory().getButton(By.xpath("//div[@class='wp-dark-mode-switcher wp-dark-mode-ignore style-2 floating left_bottom active']"), 
				"Dark Mode Button").state().isDisplayed();
	}
}