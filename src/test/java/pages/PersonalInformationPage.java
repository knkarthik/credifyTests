package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInformationPage extends BasePage {

    WebDriver driver;

    @FindBy(name = "borrowerFirstName")
    WebElement borrowerFirstName;
    @FindBy(name = "borrowerLastName")
    WebElement borrowerLastName;
    @FindBy(name = "borrowerStreet")
    WebElement borrowerStreet;
    @FindBy(name = "borrowerCity")
    WebElement borrowerCity;
    @FindBy(name = "borrowerState")
    WebElement borrowerState;
    @FindBy(name = "borrowerZipCode")
    WebElement borrowerZipCode;
    @FindBy(name = "borrowerDateOfBirth")
    WebElement borrowerDateOfBirth;
    @FindBy(name = "borrowerIncome")
    WebElement borrowerIncome;
    @FindBy(name = "borrowerAdditionalIncome")
    WebElement borrowerAdditionalIncome;
    @FindBy(name = "username")
    WebElement email;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//input[@name = 'agreements']/../div")
    WebElement ToCCheckBox;
    @FindBy(xpath = "//button[@data-auto='submitPersonalInfo']")
    WebElement SubmitButton;

    public PersonalInformationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterInfo(String firstName, String lastName, String street, String city, String state, String zip,
                          String dob, String income, String additionalIncome, String email, String password) {
        borrowerFirstName.sendKeys(firstName);
        borrowerLastName.sendKeys(lastName);
        waitForElementToBeVisible(borrowerStreet);
        borrowerStreet.sendKeys(street);
        borrowerCity.sendKeys(city);
        waitForElementToBeVisible(borrowerState);
        borrowerState.sendKeys(state);
        borrowerZipCode.sendKeys(zip);
        borrowerDateOfBirth.sendKeys(dob);
        borrowerIncome.sendKeys(income);
        borrowerAdditionalIncome.sendKeys(additionalIncome);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        ToCCheckBox.click();
        SubmitButton.click();
    }
}
