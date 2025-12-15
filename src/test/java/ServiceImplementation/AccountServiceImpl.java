package ServiceImplementation;

import InterfaceService.AccountServiceInterface;
import ObjectData.RequestObject.RequestAccount;
import ObjectData.RequestObject.RequestLogin;
import Service.ApiService.AccountApiService;
import io.restassured.response.Response;

public class AccountServiceImpl implements AccountServiceInterface {

    private AccountApiService accountApiService;

    public AccountServiceImpl() {
        accountApiService = new AccountApiService();
    }

    @Override
    public Response createAccount(RequestAccount body) {
        return accountApiService.post(body, "/User");
    }

    @Override
    public Response loginAccount(RequestLogin body) {
        return accountApiService.post(body, "/Login");
    }
}
