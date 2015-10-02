package qaworksTest;

import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import qaworksPages.ContactPage;

import com.google.inject.Inject;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.EventBrowser;
import framework.SeleniumCommands;

@Guice
public class QAworksTestsImpl {

	@Inject EventBrowser eb;
	@Inject SeleniumCommands sc;
	@Inject ContactPage cp;

	@Before
	public void beforeScenario() {
		eb.manage().deleteAllCookies();
	}

	@Given("^I open QAWorks page$")
	public void i_open_QAWorks_page() throws Throwable {
		cp.get();
	}

	@When("^I type my name \"(.*?)\" and email \"(.*?)\"$")
	public void i_type_my_name_and_email(String name, String email) throws Throwable {
		cp.typeName(name);
		cp.typeEmail(email);
	}

	@And("^type a message \"(.*?)\"$")
	public void type_a_message(String message) throws Throwable {
		cp.typeMessage(message);
	}

	@Then("^a confirmation message is displayed \"(.*?)\"$")
	public void a_confirmation_message_is_displayed(String message) throws Throwable {
		cp.clickSendButton();
		Assert.assertTrue(cp.confirmationMessageIsDisplayed(message),
				"Confirmation message not displayed");
	}


	@When("^I type (.*?) and (.*?) and (.*?)$")
	public void i_type(String name, String email, String message) throws Throwable {
		cp.typeName(name);
		cp.typeEmail(email);
		cp.typeMessage(message);
	}

	@Then("^an error message is displayed (.*?)$")
	public void an_error_message_is_displayed(String errorText) throws Throwable {
		cp.clickSendButton();
		Assert.assertTrue(cp.errorMessage(errorText),
				"Error message not displayed: " + errorText);
	}

	@After
	public void finish(Scenario scenario) {
		scenario.embed(sc.getScreenShot(), "image/png");
		eb.navigate().refresh();
	}
	@Test
	public void tt () {
		cp.get();
		cp.typeName("radu");
		cp.typeEmail("test@yopm.com");
		cp.typeMessage("test");
		cp.clickSendButton();
		Assert.assertTrue(cp.confirmationMessageIsDisplayed("confirm"),
				"Confirmation message not displayed");
		eb.navigate().refresh();
		cp.get();
		cp.typeName("ra");
	}
}
