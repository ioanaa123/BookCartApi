package ObjectData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetails {
    @JsonProperty("userId")
    private String userId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("userTypeName")
    private String userTypeName;

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getUserTypeName() {
        return userTypeName;
    }
}
