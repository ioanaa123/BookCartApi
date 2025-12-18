package tests;

import ObjectData.RequestObject.RequestLogin;
import ObjectData.ResponseObject.ResponseLoginSuccess;
import PropertyUtility.PropertyUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class LoginTest {

    public String userId;
    @Test
    public void testMethod() {
        System.out.println("Step1: Login account");
        loginAccount();
        System.out.println("End of step 1");

    }

    public void loginAccount(){
        // definim configurarile pt client
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://bookcart.azurewebsites.net/api");
        requestSpecification.contentType("application/json");

        PropertyUtility propertyUtility = new PropertyUtility("RequestData/loginAccountData");
        RequestLogin loginAccountBody = new RequestLogin(propertyUtility.getAllData());
        requestSpecification.body(loginAccountBody);

        Response response = requestSpecification.post("/Login");
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());

        ResponseLoginSuccess responseLoginSuccess = response.body().as(ResponseLoginSuccess.class);

        System.out.println(responseLoginSuccess.getToken());
        System.out.println(responseLoginSuccess.getUserDetails().getUserId());
        System.out.println(responseLoginSuccess.getUserDetails().getUsername());
        System.out.println(responseLoginSuccess.getUserDetails().getUserTypeName());
    }
}
