package Actions;

import ObjectData.RequestObject.RequestAccount;
import ObjectData.RequestObject.RequestLogin;
import ObjectData.ResponseObject.ResponseLoginSuccess;
import RestClient.ResponseStatus;
import ServiceImplementation.AccountServiceImpl;
import io.restassured.response.Response;
import org.testng.Assert;

public class AccountActions {

    private AccountServiceImpl accountServiceImpl;

    public AccountActions() {

        accountServiceImpl = new AccountServiceImpl();
    }

    public ResponseLoginSuccess responseLoginSuccess(RequestLogin requestLogin){
        Response response = accountServiceImpl.loginAccount(requestLogin);
        Assert.assertEquals(response.getStatusCode(), ResponseStatus.OK);
        ResponseLoginSuccess responseAccountBody = response.body().as(ResponseLoginSuccess.class);
        Assert.assertEquals(requestLogin.getUsername(), requestLogin.getUsername());

        return responseAccountBody;
    }


}
