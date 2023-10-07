package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;

public class GeneralSettings {
	
	public void enableBackendDarkMode() {
		AqualityServices.getElementFactory().getButton(By.xpath("//label[@for='wppool-wp_dark_mode_general[enable_backend]']"), 
				"Enable Backend Dark Mode").click();
	}
	
	public void navigateToDashboard() {
		AqualityServices.getElementFactory().getButton(By.xpath("//div[@class='wp-menu-name' and contains (text(), 'Dashboard')]"), 
				"Dashboard").clickAndWait();
	}
	
	public void gotoSwitchSettings() {
		AqualityServices.getElementFactory().getButton(By.id("wp_dark_mode_switch-tab"), 
				"Switch settings").clickAndWait();
	}		
	
	public void saveSettings() {
		AqualityServices.getElementFactory().getButton(By.id("save_settings"), "Save Settings").clickAndWait();
	}
	
	public void customSwitchSize() {
		IButton custom = AqualityServices.getElementFactory().getButton(By.xpath("//span[@class='active' and contains(text(), 'Custom')]"), 
				"Custom");
		custom.getJsActions().scrollIntoView();
		custom.clickAndWait();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) AqualityServices.getBrowser().getDriver();
        jsExecutor.executeScript("document.querySelector('.wppool-slider').setAttribute('data-value', '" + 220 + "');");   
        jsExecutor.executeScript("document.getElementById('wp_dark_mode_switch[switcher_scale]').value = '" + 220 + "';");
        AqualityServices.getElementFactory().getButton(By.xpath("//div[@class='wppool-slider-handle ui-slider-handle ui-corner-all ui-state-default']"), "Slider Handle").click();
	}
	
	public void changeFloatingSwitchPosition() {
		WebElement dropDownElement = AqualityServices.getBrowser().getDriver().findElement(By.id("wp_dark_mode_switch[switcher_position]"));
	    Select dropDown = new Select(dropDownElement);
	    dropDown.selectByValue("left_bottom");	    
	}	
}