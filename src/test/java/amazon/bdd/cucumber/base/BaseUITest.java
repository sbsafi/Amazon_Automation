package amazon.bdd.cucumber.base;

import amazon.bdd.cucumber.utilities.CommonUtilites;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BaseUITest extends CommonUtilites{

	@Before
	public void setupTests() {
		super.setupBrowser();
	}
	
	
	@After
	public void closeTests(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenShot = takeScreenShotAsBytes();
			scenario.attach(screenShot, "image/png", scenario.getName() + "scenario Failed");
		}
		 slowDown();
		 super.quitBrowser();
	}
	
	
}
