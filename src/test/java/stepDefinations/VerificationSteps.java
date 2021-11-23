package stepDefinations;
/**
${Satendra Singh}
*/
import resources.IRestResponse;
import pojo.Book;
import pojo.UserAccount;
import resources.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

public class VerificationSteps extends BaseStep {

    public VerificationSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("^The book is added$")
    public void bookIsAdded() {
    	Book book = (Book) getScenarioContext().getContext(Context.BOOK);
    	String userId = (String) getScenarioContext().getContext(Context.USER_ID);
        IRestResponse<UserAccount> userAccountResponse = (IRestResponse<UserAccount>) getScenarioContext().getContext(Context.USER_ACCOUNT_RESPONSE);

        Assert.assertTrue(userAccountResponse.isSuccessful());
        Assert.assertEquals(201, userAccountResponse.getStatusCode());

        Assert.assertEquals(userId, userAccountResponse.getBody().userID);
        Assert.assertEquals(book.isbn, userAccountResponse.getBody().books.get(0).isbn);
    }

    @Then("^The book is removed$")
    public void bookIsRemoved() {
    	String userId = (String) getScenarioContext().getContext(Context.USER_ID);
        Response response = (Response) getScenarioContext().getContext(Context.BOOK_REMOVE_RESPONSE);

        Assert.assertEquals(204, response.getStatusCode());

        IRestResponse<UserAccount> userAccountResponse = getEndPoints().getUserAccount(userId);
        Assert.assertEquals(200, userAccountResponse.getStatusCode());

        Assert.assertEquals(0, userAccountResponse.getBody().books.size());
    }
}
