package ServiceEndpoints.serviceEndpoints.status;

import ServiceEndpoints.core.entity.Param;
import ServiceEndpoints.core.entity.RequestBody;
import ServiceEndpoints.core.template.HttpMethod;
import ServiceEndpoints.core.template.IServiceEndpoint;
import ServiceEndpoints.core.template.UserType;
import properties.CredifyProperties;

import java.util.ArrayList;
import java.util.List;

public class GetStatusEndpoint implements IServiceEndpoint {

    @Override
    public String url() {

        return CredifyProperties.GET_STATUS_API;
    }

    @Override
    public HttpMethod httpMethod() {

        return HttpMethod.GET;
    }

    @Override
    public UserType userType() {

        return UserType.FREE_USER;
    }

    @Override
    public List<Param> queryParameters() {
        return null;
    }

    @Override
    public List<Param> pathParameters() {
        return null;
    }

    @Override
    public List<Param> headers() {

        List<Param> headers = new ArrayList<>();
        headers.add(new Param("Content-Type", "application/json"));
//        headers.add(new Param("Accept", "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3"));
        return headers;
    }

    @Override
    public RequestBody body() {

        return null;
    }
}
