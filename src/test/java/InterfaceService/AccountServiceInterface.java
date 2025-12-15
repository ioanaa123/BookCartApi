package InterfaceService;

import ObjectData.RequestObject.RequestAccount;
import ObjectData.RequestObject.RequestLogin;
import io.restassured.response.Response;

public interface AccountServiceInterface {
    Response createAccount(RequestAccount body);

    Response loginAccount(RequestLogin body);
}
