package ObjectData.ResponseObject;

import ObjectData.UserDetailsObject.UserDetails;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseLoginSuccess {

    @JsonProperty("token")
    private String token;

    @JsonProperty("userDetails")
    private List<UserDetails> userDetails;

    public String getToken() {
        return token;
    }

    public List<UserDetails> getUserDetails() {
        return userDetails;
    }
}
