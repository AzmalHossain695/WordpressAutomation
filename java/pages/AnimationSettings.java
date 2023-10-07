package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import aquality.selenium.browser.AqualityServices;

public class AnimationSettings {
	
	public void enableDarkModeToggleAnimationAndChangeAnimationEffect() {
		AqualityServices.getElementFactory().getButton(By.xpath("//label[@for='wppool-wp_dark_mode_animation[toggle_animation]']"), 
				"Disable keyboard shortcut").clickAndWait();
		WebElement dropdownElement = AqualityServices.getBrowser().getDriver().findElement(By.id("wp_dark_mode_animation[animation]"));
	    Select dropdown = new Select(dropdownElement);	    
	    List<WebElement> options = dropdown.getOptions();	    
	    for (WebElement option : options) {
	        if (!option.getText().equals("Fade In")) {
	            dropdown.selectByVisibleText(option.getText());
	            break; 
	        }
	    } 
	}
	
	public void gotoFrontend() {
		AqualityServices.getBrowser().getDriver().get("http://localhost/wordpress/");
	}
}