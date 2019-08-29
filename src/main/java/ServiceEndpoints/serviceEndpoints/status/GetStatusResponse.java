package ServiceEndpoints.serviceEndpoints.status;

import entities.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetStatusResponse extends BaseResponse {

    private List<State> states;

    @Getter
    @Setter
    public static class State {
        private String label;
        private String abbreviation;
        private double minLoanAmount;
        private int minAge;

    }
}
