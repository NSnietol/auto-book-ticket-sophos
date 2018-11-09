package tasks;


import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.List;
import java.util.Random;

import org.json.simple.JSONObject;

import exceptions.PersonalizedException;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;
import user_interfaces.BookingConfirmationPage;
import user_interfaces.FlightPage;
import user_interfaces.MercuryTourHome;
import user_interfaces.SearchResultsPage;

public class LogOut implements Task {


	public LogOut() {


	}

	

	@Step("{0} press click in button sing out")
	public <T extends Actor> void performAs(T actor) {
		
		actor.attemptsTo(Click.on(BookingConfirmationPage.BUTTON_SIGN_OFF));
		
		
	}

	public static LogOut ofPage() {
		return instrumented(LogOut.class);

	}
}
