package ServiceEndpoints.core.utility;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Reporter;
import ServiceEndpoints.core.entity.Param;
import ServiceEndpoints.core.entity.RequestBody;
import ServiceEndpoints.core.template.HttpMethod;
import ServiceEndpoints.core.template.IServiceEndpoint;

import static io.restassured.RestAssured.given;

public class RequestHandler {

     public Response processRequest(IServiceEndpoint iServiceEndpoint) {
        RestAssured.registerParser("text/plain", Parser.JSON);
        String endpointName = iServiceEndpoint.getClass().getSimpleName().replaceAll("Endpoint", "");
        String url = iServiceEndpoint.url();
        HttpMethod httpMethod = iServiceEndpoint.httpMethod();
        RequestBody body = iServiceEndpoint.body();
        RequestSpecification requestSpecification = formRequestSpecification(iServiceEndpoint);
        Response response = null;

        logRequestDetailsWithCurl(iServiceEndpoint, endpointName, url, httpMethod, body);
        response = makeAPIRequestAsPerHTTPMethod(url, httpMethod, requestSpecification, response);

        Reporter.log(String.format(endpointName + " Response Status Code --- (%s)", response.getStatusCode()), true);

        return response;
    }

    private void logRequestDetailsWithCurl(IServiceEndpoint iServiceEndpoint, String endpointName, String url, HttpMethod httpMethod, RequestBody body) {
        Reporter.log(String.format("\n" + endpointName + " URL --- %s %s", httpMethod.toString(), url), true);

        if (iServiceEndpoint.headers() != null) {
            for (Param p : iServiceEndpoint.headers()) {
                Reporter.log(String.format(endpointName + " Header --- [ %s : %s ]", p.getKey(), p.getValue()), true);
            }
        }

        if (body != null)
            Reporter.log(String.format(endpointName + " Request --- %s", body.getBodyString()), true);

        Reporter.log(String.format(endpointName + " Curl --- %s", new CurlBuilder(iServiceEndpoint).getCurlString()), true);
    }

    private Response makeAPIRequestAsPerHTTPMethod(String url, HttpMethod httpMethod, RequestSpecification requestSpecification, Response response) {
        switch (httpMethod) {
            case GET:
                response = requestSpecification.get(url);
                break;
            case POST:
                response = requestSpecification.post(url);
                break;
            case PUT:
                response = requestSpecification.put(url);
                break;
            case PATCH:
                response = requestSpecification.patch(url);
                break;
            case DELETE:
                response = requestSpecification.delete(url);
        }
        return response;
    }


    private RequestSpecification formRequestSpecification(IServiceEndpoint iServiceEndpoint) {
        RequestSpecification request = given();


        if (iServiceEndpoint.headers() != null) {
            iServiceEndpoint.headers().forEach(h -> request.header(h.getKey(), h.getValue()));
        }

        if (iServiceEndpoint.queryParameters() != null) {
            iServiceEndpoint.queryParameters().forEach(q -> request.queryParam(q.getKey(), q.getValue()));
        }

        if (iServiceEndpoint.pathParameters() != null) {
            iServiceEndpoint.pathParameters().forEach(p -> request.pathParam(p.getKey(), p.getValue()));
        }

        if (iServiceEndpoint.body() != null)
            request.body(iServiceEndpoint.body().getBodyString());

        return request;
    }
}
