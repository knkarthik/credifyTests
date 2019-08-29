package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RateCheckPage extends BasePage {

    WebDriver driver;

    @FindBy(name = "desiredAmount")
    WebElement amountInput;
    @FindBy(xpath = "//select[@data-auto='dropLoanPurpose']")
    WebElement selectLoanPurpose;
    @FindBy(xpath = "//button[@data-auto='CheckYourRate']")
    WebElement checkYourRateButton;


    public RateCheckPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkRateFor(String amount, String purpose) {
        waitFor(5000L);
        waitForElementToBeVisible(amountInput);
        amountInput.sendKeys(amount);
        Select loanPurpose = new Select(selectLoanPurpose);
        loanPurpose.selectByVisibleText(purpose);
        checkYourRateButton.click();

    }

}
