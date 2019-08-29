package tests.api;

import Constants.ValidStates;
import ServiceEndpoints.serviceEndpoints.status.GetStatusResponse;
import clients.CredifyClient;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utils.CredfyCategories;

import java.util.List;
import java.util.stream.Collectors;

public class VoucherSmokeTests {

    @Test(groups = {CredfyCategories.SMOKE, CredfyCategories.API})
    public void createAndRedeemVoucherSmokeTest() {
        CredifyClient credifyClient = new CredifyClient();

        GetStatusResponse status = credifyClient.getStatus();

        long actualStateCount = status.getStates()
                .stream()
                .count();
        Assert.assertEquals(actualStateCount, 48);

        boolean b = status.getStates().stream()
                .allMatch(state -> ValidStates.stateNames.contains(state.getLabel())
                        && ValidStates.abbrv.contains(state.getAbbreviation())
                );
        Assert.assertTrue(b);

        List<String> stateWithMinAge19 = status.getStates().stream()
                .filter(state -> state.getMinAge() == 19)
                .map(GetStatusResponse.State::getLabel)
                .collect(Collectors.toList());
        Reporter.log("State with min Age of 19 is: " + stateWithMinAge19.get(0), true);

        boolean georgia = status.getStates().stream()
                .filter(state -> state.getMinLoanAmount() == 3005.00)
                .allMatch(state -> state.getLabel().equals("Georgia"));

        Assert.assertTrue(georgia);


    }
}
