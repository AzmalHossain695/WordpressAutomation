package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dashboard;
import utils.*;
import pages.*;

public class WordpressAutomation extends BaseTest {
	LoginUtils login = new LoginUtils();
	Dashboard dashboard = new Dashboard();
	GeneralSettings generalSettings = new GeneralSettings();
	SwitchSettings switchSettings = new SwitchSettings();
	AccessibilitySettings accessibilitySettings = new AccessibilitySettings();
	AnimationSettings animationSettings = new AnimationSettings();
	FrontEnd frontEnd = new FrontEnd();
	
	@Test
	public void WPAutomation() {
		login.login();
		dashboard.searchForWPDarkModePlugin();
		boolean isDarkModeActivated = dashboard.isWPDarkModeActivated();
		if (isDarkModeActivated == false) {
			dashboard.installDarkMode();
			dashboard.activateDarkMode();		
		}
		dashboard.navigateToWPDarkMode();
		generalSettings.enableBackendDarkMode();
		generalSettings.saveSettings();
		generalSettings.navigateToDashboard();
		Assert.assertTrue(dashboard.isDarkModeWorking(), "Dark Mode is not working");
		dashboard.navigateToWPDarkMode();
		generalSettings.gotoSwitchSettings();
		switchSettings.changeFloatingSwitchStyle();
		generalSettings.saveSettings();
		generalSettings.gotoSwitchSettings();
		switchSettings.customSwitchSize();
		generalSettings.saveSettings();
		dashboard.navigateToWPDarkMode();
		generalSettings.gotoSwitchSettings();
		switchSettings.changeFloatingSwitchPosition();
		generalSettings.saveSettings();
		switchSettings.gotoAccessibilitySettings();
		accessibilitySettings.disableKeyboardShortcut();
		generalSettings.saveSettings();
		accessibilitySettings.gotoAnimationSettings();
		animationSettings.enableDarkModeToggleAnimationAndChangeAnimationEffect();
		generalSettings.saveSettings();
		animationSettings.gotoFrontend();
		animationSettings.gotoFrontend();
		Assert.assertTrue(frontEnd.isDarkModeWorking(), "Dark Mode is not working in front end"); 
	}
}