package ObjectData.RequestObject;

import ObjectData.RequestPreparation;

import java.util.HashMap;

public class RequestAccount implements RequestPreparation {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String gender;

    public RequestAccount(HashMap<String, String> testData) {
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
                case "confirmPassword":
                    setConfirmPassword(testData.get(key));
                    break;
                case "firstName":
                    setFirstname(testData.get(key));
                    break;
                case "lastName":
                    setLastName(testData.get(key));
                    break;
                case "gender":
                    setGender(testData.get(key));
                    break;
            }
        }
        adjustObjectVariable();
    }

    private void adjustObjectVariable() {
        username = username + System.currentTimeMillis();
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
