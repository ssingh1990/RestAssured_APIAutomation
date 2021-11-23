package stepDefinations;

import resources.Endpoints;
import resources.ScenarioContext;
import resources.TestContext;
/**
${Satendra Singh}
*/
public class BaseStep {
	private Endpoints endPoints;
	   private ScenarioContext scenarioContext;

	    public BaseStep(TestContext testContext) {
	    	endPoints = testContext.getEndPoints();
	    	scenarioContext = testContext.getScenarioContext();
	    }

	    public Endpoints getEndPoints() {
	        return endPoints;
	    }
	    
	    public ScenarioContext getScenarioContext() {
	        return scenarioContext;
	    }
	}
