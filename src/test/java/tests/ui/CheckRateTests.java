package tests.ui;

import Constants.LoanPurpose;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.OffersPage;
import pages.PersonalInformationPage;
import pages.RateCheckPage;
import pages.SignInPage;
import properties.CredifyProperties;
import testBases.UIBaseTest;
import utils.Commons;
import utils.CredfyCategories;

import java.util.List;

public class CheckRateTests extends UIBaseTest {

    @Test(groups = {CredfyCategories.UI})
    public void verifyOfferDetailsOnSuccessfulRegistration() {

        getUrl(CredifyProperties.CHECK_RATE_URL);
        new RateCheckPage(driver).checkRateFor("10000", LoanPurpose.CREDIT_CARD);

        String email = Commons.getRandomEmail();
        String password = Commons.getRandomPassword();
        String dob = Commons.getRandomDOB();
        new PersonalInformationPage(driver).enterInfo(
                Commons.getRandomFirstName(),
                Commons.getRandomLastName(),
                Commons.getRandomStreetName(),
                Commons.getRandomCity(),
                Commons.getrandomState(),
                Commons.getrandomZipCode(),
                dob,
                Commons.getRandomNumber(),
                Commons.getRandomNumber(),
                email,
                password
        );
        List<String> defaultOfferDetails = new OffersPage(driver).getDefaultOfferDetails();
        Reporter.log("Offer Details before Sign-In: "+defaultOfferDetails,true);

        new OffersPage(driver).signOut();

        getUrl(CredifyProperties.LOG_IN_URL);
        new SignInPage(driver).signIn(email, password);

        List<String> actualOfferDetails = new OffersPage(driver).getDefaultOfferDetails();

        Reporter.log("Offer Details after Sign-In: "+actualOfferDetails, true);
        Assert.assertTrue(defaultOfferDetails.equals(actualOfferDetails));

    }


}
