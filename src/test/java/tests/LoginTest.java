package tests;

import ObjectData.RequestObject.RequestAccount;
import ObjectData.RequestObject.RequestLogin;
import ObjectData.ResponseObject.ResponseLoginSuccess;
import PropertyUtility.PropertyUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void testMethod() {
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
    }
}
