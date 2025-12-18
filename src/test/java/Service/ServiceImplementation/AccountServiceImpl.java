package Service.ServiceImplementation;

import Service.InterfaceService.AccountServiceInterface;
import ObjectData.RequestObject.RequestUserRegistration;
import ObjectData.RequestObject.RequestLogin;
import Service.ApiService.AccountApiService;
import io.restassured.response.Response;

public class AccountServiceImpl implements AccountServiceInterface {

    private AccountApiService accountApiService;

    public AccountServiceImpl() {
        accountApiService = new AccountApiService();
    }

    @Override
    public Response createAccount(RequestUserRegistration body) {
        return accountApiService.post(body, "/User");
    }

    @Override
    public Response loginAccount(RequestLogin body) {
        return accountApiService.post(body, "/Login");
    }
}
