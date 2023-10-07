package utils;

import org.openqa.selenium.By;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ITextBox;
import io.github.cdimascio.dotenv.Dotenv; // Import the Dotenv class

public class LoginUtils {
    private static final Dotenv dotenv = Dotenv.configure().load();

    public static final String USER = dotenv.get("USER");
    public static final String PASSWORD = dotenv.get("PASSWORD");

    public void login() {
        ITextBox userName = AqualityServices.getElementFactory().getTextBox(By.id("user_login"), "Username");
        userName.sendKeys(USER);
        ITextBox password = AqualityServices.getElementFactory().getTextBox(By.id("user_pass"), "Password");
        password.sendKeys(PASSWORD);
        AqualityServices.getElementFactory().getButton(By.id("wp-submit"), "Submit").clickAndWait();
    }
}