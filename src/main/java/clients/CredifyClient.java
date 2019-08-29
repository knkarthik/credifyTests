package clients;

import ServiceEndpoints.core.utility.RequestHandler;
import ServiceEndpoints.serviceEndpoints.status.GetStatusEndpoint;
import ServiceEndpoints.serviceEndpoints.status.GetStatusResponse;
import io.restassured.response.Response;
import org.testng.Reporter;

public class CredifyClient extends BaseClient {

    public GetStatusResponse getStatus() {
        GetStatusEndpoint getStatusEndpoint = new GetStatusEndpoint();
        Response response = new RequestHandler().processRequest(getStatusEndpoint);
        Reporter.log("Get status response --> " + response.asString(), true);
        return response.as(GetStatusResponse.class);
    }
}
