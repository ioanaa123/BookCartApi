package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class aTest {
    @Test
    public void testMethod(){
        // definim configurarile pt client
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://petstore.swagger.io/");
        requestSpecification.contentType("application/json");

        // definim request-ul
        JSONObject createUserBody = new JSONObject();
        createUserBody.put("id", "P@ssw0rd!2");
        createUserBody.put("userName", "AutomationTest");
        createUserBody.put("password", "P@ssw0rd!2");
        requestSpecification.body(createUserBody);

        // interactionam cu raspunsul 
        Response response=requestSpecification.post("/user");






    }
}
