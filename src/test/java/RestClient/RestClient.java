package RestClient;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {
    private RequestSpecification prepareClient(RequestSpecification requestSpecification){
        requestSpecification.baseUri("https://bookcart.azurewebsites.net/api");
        //requestSpecification.contentType("application/json");

        return requestSpecification;
    }

    public Response performRequest(String requestType, RequestSpecification requestSpecification, String endPoint){
        switch (requestType) {
            case RequestType.REQUEST_POST:
                return prepareClient(requestSpecification).post(endPoint);
            case RequestType.REQUEST_PUT:
                return prepareClient(requestSpecification).put(endPoint);
            case RequestType.REQUEST_DELETE:
                return prepareClient(requestSpecification).delete(endPoint);
            case RequestType.REQUEST_GET:
                return prepareClient(requestSpecification).get(endPoint);
        }
        return null;
    }
}
