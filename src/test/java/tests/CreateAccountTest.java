package tests;

import Actions.AccountActions;
import ObjectData.RequestObject.RequestUserRegistration;
import PropertyUtility.PropertyUtility;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateAccountTest {

    public AccountActions accountActions;

    @Test
    public void testMethod(){
        System.out.println("Step1: Create new account");
        createAccount();
        System.out.println("End of step 1");
    }

    public void createAccount(){
        accountActions = new AccountActions();

        PropertyUtility propertyUtility = new PropertyUtility("RequestData/createAccountData");
        RequestUserRegistration requestAccountBody = new RequestUserRegistration(propertyUtility.getAllData());
        accountActions.userRegistrationAccount(requestAccountBody);

//        System.out.println(response.getStatusCode());
//        System.out.println(response.getStatusLine());
    }
}
