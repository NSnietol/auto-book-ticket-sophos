package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.Keys;

import exceptions.PersonalizedException;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;
import user_interfaces.BookFlightPage;
import user_interfaces.FlightPage;
import user_interfaces.MercuryTourHome;
import user_interfaces.RegisterPage;
import user_interfaces.SearchResultsPage;

public class BookTicket implements Task {

	BookFlightPage bookFlightPage;
	RegisterPage registerUserPage;
	JSONObject dataTest;

	public BookTicket(JSONObject dataTest) {

		this.dataTest = (JSONObject) dataTest.get("usuario");
		bookFlightPage = new BookFlightPage();

	}

	public void fillOutCreditCardInformation(Actor actor) {

		JSONObject creditCardInfo = (JSONObject) dataTest.get("tarjeta");

		try {

			actor.attemptsTo(SelectFromOptions.byVisibleText(creditCardInfo.get("tipoTarjeta").toString())
					.from(BookFlightPage.SELECT_CREDIT_CARD));

		} catch (Exception e) {
			throw new PersonalizedException("El tipo de tarjeta solicitada no fue ubicada", e);
		}

		actor.attemptsTo(Enter.theValue(creditCardInfo.get("numeroTarjeta").toString())
				.into(BookFlightPage.INPUT_CREDIT_NUMBER));

		actor.attemptsTo(Enter.theValue(creditCardInfo.get("nombre").toString())
				.into(BookFlightPage.INPUT_CREDIT_CARD_FIRST_NAME));

		actor.attemptsTo(Enter.theValue(creditCardInfo.get("segundoNombre").toString())
				.into(BookFlightPage.INPUT_CREDIT_CARD_MIDDLE_NAME));

		actor.attemptsTo(Enter.theValue(creditCardInfo.get("apellido").toString())
				.into(BookFlightPage.INPUT_CREDIT_CARD_LAST_NAME));

	}

	public void fillOutBillingAddressInformation(Actor actor) {

		JSONObject billingAddress = (JSONObject) dataTest.get("direccionFactura");

		actor.attemptsTo(Enter.theValue(billingAddress.get("direccion1").toString())
				.into(BookFlightPage.INPUT_BILLING_ADDRESS_1));

		actor.attemptsTo(Enter.theValue(billingAddress.get("direccion2").toString())
				.into(BookFlightPage.INPUT_BILLING_ADDRESS_2));

		actor.attemptsTo(Enter.theValue(billingAddress.get("cuidad").toString())
				.into(BookFlightPage.INPUT_BILLING_ADDRESS_CITY));

		actor.attemptsTo(Enter.theValue(billingAddress.get("estado").toString())
				.into(BookFlightPage.INPUT_BILLING_ADDRESS_STATE));

		actor.attemptsTo(Enter.theValue(billingAddress.get("codigoPostal").toString())
				.into(BookFlightPage.INPUT_BILLING_ADDRESS_ZIP));

		try {

			actor.attemptsTo(SelectFromOptions.byVisibleText(billingAddress.get("pais").toString())
					.from(BookFlightPage.SELECT_BILLING_ADDRESS_COUNTRY));

		} catch (Exception e) {
			throw new PersonalizedException("El pais solicitado no fue ubicado", e);
		}

	}

	@Step("{0} fill out the passanger information ")
	public void fillOutPassangerInformation(Actor actor) {

		JSONArray passangerInformation = null;
		try {

			JSONObject flightInformation = (JSONObject) dataTest.get("vuelo");

			System.out.println(flightInformation.toJSONString());
			passangerInformation = (JSONArray) flightInformation.get("pasajeros");

		} catch (Exception e) {
			throw new PersonalizedException("No se pudo leer la informacion sobre los pasajeros ", e);
		}

		List<WebElementFacade> listFirstName = bookFlightPage.getInputsFirstNamePassanger();
		List<WebElementFacade> listLastName = bookFlightPage.getInputsLastNamePassanger();
		List<WebElementFacade> listPreferences = bookFlightPage.getInputsPreferencePassanger();

		if (listFirstName.size() != passangerInformation.size()) {
			throw new PersonalizedException(
					"El numero de pasajeros cargados no coincide con la lista de campos disponibles", null);
		}

		try {
			for (int index = 0; index < listFirstName.size(); index++) {

				actor.attemptsTo(Enter.theValue(((JSONObject) passangerInformation.get(index)).get("nombre").toString())
						.into(listFirstName.get(index)));

				actor.attemptsTo(
						Enter.theValue(((JSONObject) passangerInformation.get(index)).get("apellido").toString())
								.into(listLastName.get(index)));

				actor.attemptsTo(SelectFromOptions
						.byVisibleText(((JSONObject) passangerInformation.get(index)).get("preferencia").toString())
						.from(listPreferences.get(index)));

			}

		} catch (Exception e) {
			throw new PersonalizedException("Error al escribir la informacion sobre los pasajeros", e);

		}

	}


	@Step("{0} press click in purchase secure ")
	public void clickInPurchaseSecure(Actor actor) {
		
		actor.attemptsTo(Click.on(BookFlightPage.BUTTON_BUY_FLIGHTS));
		
	}

	
	
	@Step("{0} fill out the book form  ")
	public <T extends Actor> void performAs(T actor) {
		try {

			BookFlightPage.FORM_BOOKING_SUMMARY.resolveFor(actor).waitUntilVisible();

			fillOutPassangerInformation(actor);

			fillOutCreditCardInformation(actor);
			
			
			fillOutBillingAddressInformation(actor);
			
			// Marcar  Same as Billing Address, para reducir la cantidad de datos a ingresar
			actor.attemptsTo(Click.on(bookFlightPage.getCheckBoxsBook().get(1)));

		} catch (Exception e) {
			throw new PersonalizedException("Inconvenientes con el resumen de reserva", e);

		}
	}

	public static BookTicket chosen(JSONObject dataTest) {
		return instrumented(BookTicket.class, dataTest);
	}
}
