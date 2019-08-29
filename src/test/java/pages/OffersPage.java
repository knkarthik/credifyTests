package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class OffersPage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//div[@data-fetching='true']")
    WebElement loadingSpinner;
    @FindBy(xpath = "//span[@data-auto='userLoanAmount']")
    WebElement loanAmount;
    @FindBy(xpath = "//div[@data-auto='HeroOfferBox0']//span[@data-auto='defaultMonthlyPayment']")
    WebElement defaultMonthlyPayment;
    @FindBy(xpath = "//div[@data-auto='HeroOfferBox0']//div[@data-auto='defaultLoanTerm']")
    WebElement defaultLoanTerm;
    @FindBy(xpath = "//div[@data-auto='HeroOfferBox0']//div[@data-auto='defaultLoanInterestRate']")
    WebElement defaultLoanInterestRate;
    @FindBy(xpath = "//div[@data-auto='HeroOfferBox0']//div[@data-auto='defaultMoreInfoAPR']//div")
    WebElement defaultAPR;

    public OffersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public List<String> getDefaultOfferDetails() {

        waitForSpinnertoDisappear();
        waitForElementToBeVisible(defaultMonthlyPayment);
        ArrayList<String> offer = new ArrayList<>();
        offer.add(defaultMonthlyPayment.getText());
        offer.add(defaultLoanTerm.getText());
        offer.add(defaultLoanInterestRate.getText());
        offer.add(defaultAPR.getText());
        return offer;
    }

    private void waitForSpinnertoDisappear() {
        waitFor(20L);
    }


    public void signOut() {
        waitFor(5000L);
        ((JavascriptExecutor) driver).executeScript("(document.evaluate(\"//a[contains(text(),'Sign Out')]\",document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).click();");
    }
}
