package ServiceImplementation;

import RestClient.RequestType;
import RestClient.RestClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonApiService {

    public Response post(Object body, String endPoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(body);
        Response response = performRequest(RequestType.REQUEST_POST, requestSpecification, endPoint);
        return response;
    }

    private Response performRequest(String requestType, RequestSpecification requestSpecification, String endPoint) {
        return new RestClient().performRequest(requestType, requestSpecification, endPoint);
    }
}
