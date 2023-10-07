package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;

public class SwitchSettings {
	
	public void changeFloatingSwitchStyle() {
		AqualityServices.getElementFactory().getButton(By.xpath("//label[@for='wppool-wp_dark_mode_switch[switch_style][2]']"), 
				"Switch Style").click();
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
	
	public void gotoAccessibilitySettings() {
		AqualityServices.getElementFactory().getButton(By.id("wp_dark_mode_accessibility-tab"), "Accessibility Settings").click();;
	}
}