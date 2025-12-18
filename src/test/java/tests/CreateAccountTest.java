package tests;

import Actions.AccountActions;
import ObjectData.RequestObject.RequestUserRegistration;
import PropertyUtility.PropertyUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAccountTest {

    private String username;
    private String password;
    public AccountActions accountActions;


    @BeforeClass
    public void setup() {
        // set your API base URI
        RestAssured.baseURI = "https://bookcart.azurewebsites.net/api";
    }

    @Test
    public void testMethod(){
        System.out.println("Step1: Create new account");
        createAccount();
        System.out.println("End of step 1");
    }

    public void createAccount(){
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
        Assert.assertNotNull(password, "password missing");    }
}
