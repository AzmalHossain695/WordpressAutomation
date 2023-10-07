package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;

public class Dashboard {
	
	public void searchForWPDarkModePlugin() {
		AqualityServices.getElementFactory().getButton(By.xpath("//div[@class='wp-menu-name' and contains(text(),'Plugins')]"), 
				"Plugins").clickAndWait();
		AqualityServices.getElementFactory().getTextBox(By.id("plugin-search-input"), "Plugin Search").sendKeys("WP Dark Mode");	
		AqualityServices.getBrowser().setImplicitWaitTimeout(Duration.ofSeconds(5));
	}
	
	public boolean isWPDarkModeActivated() {
		ILabel deactivateButton = AqualityServices.getElementFactory().getLabel(By.id("deactivate-wp-dark-mode"), "Deactivate");
		deactivateButton.state().waitForDisplayed(Duration.ofSeconds(7));
		if (deactivateButton.state().isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void installDarkMode () {
		AqualityServices.getElementFactory().getButton(By.xpath("//a[@class='page-title-action' and contains (text(), 'Add New')]"), 
				"Add New").clickAndWait();
		AqualityServices.getElementFactory().getTextBox(By.id("search-plugins"), "New Plugin Search").sendKeys("WP Dark Mode");
		AqualityServices.getBrowser().setImplicitWaitTimeout(Duration.ofSeconds(10));
		AqualityServices.getElementFactory().getButton(By.xpath("//a[@data-slug='wp-dark-mode']"), "Add wp dark mode plugin").clickAndWait();
		AqualityServices.getBrowser().setImplicitWaitTimeout(Duration.ofSeconds(30));
	}
	
	public void activateDarkMode() {
		searchForWPDarkModePlugin();
		AqualityServices.getElementFactory().getButton(By.id("activate-wp-dark-mode"), "Activate WP Dark Mode").clickAndWait();
	}
	
	public void navigateToWPDarkMode() {
		AqualityServices.getElementFactory().getButton(By.xpath("//div[@class='wp-menu-name' and contains (text(), 'WP Dark Mode')]"), 
				"WP Dark Mode").clickAndWait();
	}
	
	public boolean isDarkModeWorking() {
		return AqualityServices.getElementFactory().getLabel(By.xpath("//h2[contains (text(), 'WP Dark Mode Usage')]"), 
				"Dark Mode Element").state().isDisplayed();
	}
}