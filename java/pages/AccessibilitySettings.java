package pages;

import org.openqa.selenium.By;
import aquality.selenium.browser.AqualityServices;

public class AccessibilitySettings {
	
	public void disableKeyboardShortcut() {
		AqualityServices.getElementFactory().getButton(By.xpath("//label[@for='wppool-wp_dark_mode_accessibility[keyboard_shortcut]']"), 
				"Disable keyboard shortcut").clickAndWait();
	}
	
	public void gotoAnimationSettings() {
		AqualityServices.getElementFactory().getButton(By.id("wp_dark_mode_animation-tab"), "Animation Settings").click();;
	}
}