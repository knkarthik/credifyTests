package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {

    WebDriver driver;
    @FindBy(name = "username")
    WebElement login;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//button[@data-auto='login']")
    WebElement form;

    public SignInPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signIn(String username, String password) {

        waitForElementToBeVisible(login);
        login.sendKeys(username);
        this.password.sendKeys(password);
        form.click();
    }
}
