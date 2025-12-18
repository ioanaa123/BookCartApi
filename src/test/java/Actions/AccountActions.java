package Actions;

import ObjectData.RequestObject.RequestLogin;
import ObjectData.RequestObject.RequestUserRegistration;
import ObjectData.ResponseObject.ResponseLoginSuccess;
import ObjectData.ResponseObject.ResponseUserRegistrationSuccess;
import RestClient.ResponseStatus;
import Service.ServiceImplementation.AccountServiceImpl;
import io.restassured.response.Response;
import org.testng.Assert;

public class AccountActions {

    private AccountServiceImpl accountServiceImpl;

    public AccountActions() {

        accountServiceImpl = new AccountServiceImpl();
    }

    public ResponseUserRegistrationSuccess userRegistrationAccount(RequestUserRegistration userRegistrationAccount){
        Response response = accountServiceImpl.createAccount(userRegistrationAccount);
        Assert.assertEquals(response.getStatusCode(), ResponseStatus.OK);
        ResponseUserRegistrationSuccess responseAccountBody = response.body().as(ResponseUserRegistrationSuccess.class);

        return responseAccountBody;
    }
    public ResponseLoginSuccess loginAccount(RequestLogin requestLogin){
        Response response = accountServiceImpl.loginAccount(requestLogin);
        Assert.assertEquals(response.getStatusCode(), ResponseStatus.OK);
        ResponseLoginSuccess responseAccountBody = response.body().as(ResponseLoginSuccess.class);
        Assert.assertEquals(requestLogin.getUsername(), requestLogin.getUsername());

        return responseAccountBody;
    }


}
