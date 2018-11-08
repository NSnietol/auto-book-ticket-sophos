package step_definition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import co.linio.tasks.OpenTheBrowser;
import co.linio.tasks.RegistrerUser;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import user_interfaces.MercuryTourHome;
import user_interfaces.RegisterPage;
import util.JsonManager;

@RunWith(Cucumber.class)
public class BookTicketsDefinitions {


	@Managed(driver = "chrome")
	private WebDriver herBrowser;
	
	
	Actor anna = Actor.named("Anna");



	//Referencia al home de la sitio web
	private MercuryTourHome mercuryTourHome;

	

	
	@Before
	public void setup() {
		System.out.println("Config");
		anna.can(BrowseTheWeb.with(herBrowser));
		System.out.println("Config ok");

	}

    @Given("^the user opened  Mercury tours home page$")
    public void the_user_opened_mercury_tours_home_page() throws Throwable {
   
		anna.wasAbleTo(OpenTheBrowser.at(mercuryTourHome));
     

 
    }
    @And("^the user logs into the page$")
    public void the_user_logs_into_the_page() throws Throwable {
		anna.attemptsTo(RegistrerUser.inPage(JsonManager.getInstance().getJsonReader()));

        //throw new PendingException();
    }

    @When("^the user searches for a flight$")
    public void the_user_searches_for_a_flight() throws Throwable {
       // throw new PendingException();
    }

    @Then("^The flight confirmation is displayed on the page$")
    public void the_flight_confirmation_is_displayed_on_the_page() throws Throwable {
      //  throw new PendingException();
    }

  

    @And("^the user booked the flight$")
    public void the_user_booked_the_flight() throws Throwable {
        //throw new PendingException();
    }

}