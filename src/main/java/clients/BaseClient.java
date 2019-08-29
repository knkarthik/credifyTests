package clients;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import properties.Properties;

public class BaseClient {

    protected Response post(String url, RequestSpecification specification) {

        specification.header("Content-Type", "application/json").header("Accept-Language", Properties.language);

        return specification.post(url);
    }

    protected Response get(String url, RequestSpecification specification) {

        specification.header("Content-Type", "application/json").header("Accept-Language", Properties.language);

        return specification.get(url);
    }

    protected Response delete(String url, RequestSpecification specification) {

        specification.header("Content-Type", "application/json").header("Accept-Language", Properties.language);

        return specification.delete(url);
    }

    protected Response put(String url, RequestSpecification specification) {

        specification.header("Content-Type", "application/json").header("Accept-Language", Properties.language);

        return specification.put(url);
    }

    protected Response patch(String url, RequestSpecification specification) {

        specification.header("Content-Type", "application/json").header("Accept-Language", Properties.language);

        return specification.patch(url);
    }
}
