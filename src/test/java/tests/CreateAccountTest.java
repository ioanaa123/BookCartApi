package tests;

import ObjectData.RequestAccount;
import PropertyUtility.PropertyUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateAccountTest {
    @Test
    public void testMethod(){
        // definim configurarile pt client
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://bookcart.azurewebsites.net/api");
        requestSpecification.contentType("application/json");

        // definim request-ul
        PropertyUtility propertyUtility = new PropertyUtility("RequestData/createAccountData");
        RequestAccount requestAccountBody = new RequestAccount(propertyUtility.getAllData());

        requestSpecification.body(requestAccountBody);

        // interactionam cu raspunsul
        Response response=requestSpecification.post("/User");
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        ResponseBody responseBody = response.getBody();
        System.out.println(responseBody.asString());

    }
}
