package tests;

import Actions.AccountActions;
import ObjectData.RequestObject.RequestUserRegistration;
import ObjectData.ResponseObject.ResponseLoginSuccess;
import PropertyUtility.PropertyUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateAccountAndLoginTest {

    public AccountActions accountActions;

    private String username;
    private String password;
    private String userId;

    private String baseUri = "https://bookcart.azurewebsites.net/api";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = baseUri;
    }

    @Test
    public void testMethod() {
        System.out.println("Step1: Create new account");
        createAccount();
        System.out.println("End of step 1");
        System.out.println("Step2: Login with the created account");
        loginAccount();
        System.out.println("End of step 2");
    }

    public void createAccount() {
        accountActions = new AccountActions();

        PropertyUtility propertyUtility = new PropertyUtility("RequestData/createAccountData");
        RequestUserRegistration requestAccountBody = new RequestUserRegistration(propertyUtility.getAllData());
        RequestSpecification req = RestAssured.given().contentType("application/json").body(requestAccountBody);
        Response response = req.post("/User");
        int status = response.getStatusCode();

        System.out.println("Status code received: " + response.getStatusCode());

        Assert.assertTrue(status == 200 || status == 201, "CreateAccount failed: " + status);

        // extract credentials from the payload (adjust keys if your payload uses different names)
        this.username = (String) requestAccountBody.getUsername();
        this.password = (String) requestAccountBody.getPassword();
        Assert.assertNotNull(username, "username missing");
        Assert.assertNotNull(password, "password missing");

    }

    public void loginAccount() {

        RequestSpecification req = RestAssured.given();
        req.contentType("application/json");

        // build login body from created credentials
        Map<String, Object> loginBody = new HashMap<>();
        loginBody.put("username", username);
        loginBody.put("password", password);

        req.body(loginBody);
        Response response = req.post("/Login");
        Assert.assertEquals(response.getStatusCode(), 200);

        ResponseLoginSuccess responseLoginSuccess = response.body().as(ResponseLoginSuccess.class);

        System.out.println("Token: " + responseLoginSuccess.getToken());
        if (responseLoginSuccess.getUserDetails() != null) {
            System.out.println("UserId: " + responseLoginSuccess.getUserDetails().getUserId());
            System.out.println("Username: " + responseLoginSuccess.getUserDetails().getUsername());
            System.out.println("UserType: " + responseLoginSuccess.getUserDetails().getUserTypeName());
        }
    }


}
