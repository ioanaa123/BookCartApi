package ObjectData.ResponseObject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseUserRegistrationSuccess {

    @JsonProperty("status")
    private String status;

    @JsonProperty("result")
    private String result;

    public String getStatus() {
        return status;
    }

    public String getResult() {
        return result;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
