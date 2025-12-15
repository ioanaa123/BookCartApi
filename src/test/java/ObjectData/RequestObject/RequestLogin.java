package ObjectData.RequestObject;

import ObjectData.RequestPreparation;

import java.util.HashMap;

public class RequestLogin implements RequestPreparation {

    private String username;
    private String password;

    public RequestLogin(HashMap<String, String> testData) {
        prepareObject(testData);
    }

    @Override
    public void prepareObject(HashMap<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "username":
                    setUsername(testData.get(key));
                    break;
                case "password":
                    setPassword(testData.get(key));
                    break;
            }
        }
    }

    private void adjustObjectVariable() {
        username = username;
        System.out.println(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
