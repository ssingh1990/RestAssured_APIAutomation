package stepDefinations;
/**
${Satendra Singh}
*/
import io.cucumber.java.en.Given;
import pojo.AuthorizationRequest;
import resources.TestContext;

public class AccountSteps extends BaseStep {

    public AccountSteps(TestContext testContext){
    	super(testContext);
    }

    @Given("^I am an authorized user$")
    public void iAmAnAuthorizedUser() {
        AuthorizationRequest authRequest = new AuthorizationRequest("Test", "Test@@123");
        getEndPoints().authenticateUser(authRequest);
    }

}
