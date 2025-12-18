package Service.InterfaceService;

import ObjectData.RequestObject.RequestUserRegistration;
import ObjectData.RequestObject.RequestLogin;
import io.restassured.response.Response;

public interface AccountServiceInterface {

    Response createAccount(RequestUserRegistration body);

    Response loginAccount(RequestLogin body);
}
