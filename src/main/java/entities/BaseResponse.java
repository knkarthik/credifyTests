package entities;

import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;

@Getter
@Setter
public class BaseResponse {

    private int httpStatusCode;

    public void assertHttpStatusToBe(int httpStatusCode) {
        assertEquals(getHttpStatusCode(), httpStatusCode, "HTTP Status code is not matching");
    }

}