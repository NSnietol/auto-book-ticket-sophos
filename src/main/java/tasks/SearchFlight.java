package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.json.simple.JSONObject;
import org.openqa.selenium.Keys;

import exceptions.PersonalizedException;
import net.bytebuddy.asm.Advice.This;
import net.serenitybdd.core.exceptions.SerenityManagedException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import user_interfaces.FlightPage;
import user_interfaces.MercuryTourHome;
import user_interfaces.RegisterPage;

public class SearchFlight implements Task {

	MercuryTourHome homePage;
	FlightPage flightPage;
	JSONObject dataTest;

	public SearchFlight(JSONObject dataTest) {

		this.dataTest = (JSONObject) dataTest.get("vuelo");
		System.out.println(this.dataTest.toJSONString());

	}

	//@Step("{0} chooses the flight type")
	public void choosesType(Actor actor) {
		
		System.out.println("Tipo ."+dataTest.get("tipo").toString().equals("Round Trip"));
		System.out.println("Tipo ."+dataTest.get("tipo").toString().equalsIgnoreCase("Round Trip"));
		if (dataTest.get("tipo").toString().equals("Round Trip")) {
			actor.attemptsTo(Click.on(FlightPage.INPUT_ROUND_TRIP));
		}else if (dataTest.get("tipo").toString().equals("One Way")) {
			actor.attemptsTo(Click.on(FlightPage.INPUT_ONE_WAY));
		} else {
			throw new PersonalizedException(
					"El tipo de vuelo solicitado no está presente " + dataTest.get("tipo").toString(), null);
		}

	}
	
	//@Step("{0} chooses the number passanger ")
	public void choosesNumberPassanger(Actor actor) {
		
		
		try {
			actor.attemptsTo(SelectFromOptions.byVisibleText(dataTest.get("numPasajeros").toString())
					.from(FlightPage.SELECT_PASSENGER));
			
		} catch (Exception e) {
			throw new PersonalizedException(
					"El numero de pasajeros solicitado  no está presente " + dataTest.get("numPasajeros").toString(), null);
		}
		

	}
	
	
	public void choosesDeparting(Actor actor) {
		
		
		try {
			actor.attemptsTo(SelectFromOptions.byValue(dataTest.get("salida").toString())
					.from(FlightPage.SELECT_DEPARTING));
			
	
		} catch (Exception e) {
			throw new PersonalizedException(
					"la  salida solicitado no se pudo seleccionar " + dataTest.get("salida").toString(), e);
		}

	}
	
	public void choosesDepartingOn(Actor actor) {
		
		
		try {
			actor.attemptsTo(SelectFromOptions.byVisibleText(dataTest.get("mesSalida").toString())
					.from(FlightPage.SELECT_FROM_MONTH));
			
			actor.attemptsTo(SelectFromOptions.byValue(dataTest.get("diaSalida").toString())
					.from(FlightPage.SELECT_FROM_DAY));
			
			
		} catch (Exception e) {
			throw new PersonalizedException(
					"la fecha de salida solicitado no se pudo seleccionar " + dataTest.get("mesSalida").toString()+dataTest.get("diaSalida").toString(), e);
		}
		

	}
	
	public void choosesArraving(Actor actor) {
		
		
		try {
			actor.attemptsTo(SelectFromOptions.byValue(dataTest.get("llegada").toString())
					.from(FlightPage.SELECT_ARRIVING));
			
	
		} catch (Exception e) {
			throw new PersonalizedException(
					"la  llegada solicitada no se pudo seleccionar " + dataTest.get("llegada").toString(), e);
		}

	}
	
	
	public void choosesArravingOn(Actor actor) {
		
		
		try {
			actor.attemptsTo(SelectFromOptions.byVisibleText(dataTest.get("mesLlegada").toString())
					.from(FlightPage.SELECT_TO_MONTH));
			
			actor.attemptsTo(SelectFromOptions.byValue(dataTest.get("diaLlegada").toString())
					.from(FlightPage.SELECT_TO_DAY));
			
			
		} catch (Exception e) {
			throw new PersonalizedException(
					"la fecha de salida solicitado no se pudo seleccionar " + dataTest.get("mesSalida").toString()+dataTest.get("diaSalida").toString(), e);
		}
		

	}
	
	
	
	
	public void choosesPreference(Actor actor) {
		
		
		try {
			switch (dataTest.get("clase").toString()) {
			case "Economy class":{
				
				actor.attemptsTo(Click.on(FlightPage.INPUT_ECONOMY_CLASS));
				break;
				}
			
				
			case "Business class":
				actor.attemptsTo(Click.on(FlightPage.INPUT_BUSSINES_CLASS));

				break;
			case "First class":
				actor.attemptsTo(Click.on(FlightPage.INPUT_FIRST_CLASS));

				
				break;

			default:{
				throw new PersonalizedException(
						"La  clase del vuelo solicitada no está presente " + dataTest.get("clase").toString(), null);
				
				}
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new PersonalizedException(
					"La  clase del vuelo solicitada no está presente " + dataTest.get("clase").toString(), e);
		}
		
		//------------------------------Airline
		try {

			actor.attemptsTo(SelectFromOptions.byVisibleText(dataTest.get("aerolinea").toString())
					.from(FlightPage.SELECT_AIRLINE));
		} catch (Exception e) {
			// TODO: handle exception
			throw new PersonalizedException(
					"El aerolinea  vuelo solicitada no está presente " + dataTest.get("aerolinea").toString(), e);
		}
		
		
		
		
		
		
	}

	
	@Step("{0} press click in search")
	public void pressSearchFlight(Actor actor) {
		actor.attemptsTo(Click.on(FlightPage.BUTTON_CONTINUE));
	}
	
	@Step("{0} press click in flights")
	public void pressClickFlight(Actor actor) {
		actor.attemptsTo(Click.on(MercuryTourHome.BUTTON_FLIGHTS));
	}
	
	@Step("{0} fill out the flight register")
	public <T extends Actor> void performAs(T actor) {
		try {

			pressClickFlight(actor);
			

			choosesType(actor);
			
			choosesNumberPassanger(actor);
		
			choosesDeparting(actor);
			
			choosesDepartingOn(actor);
			
			if(dataTest.get("tipo").equals("Round Trip")) {
				choosesArraving(actor);
				
				choosesArravingOn(actor);
				
			}
			
			
			
				

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			// System.out.println("No encontro el elemento : "+e.getMessage());
			// e.printStackTrace();
		}
	}

	
	public static SearchFlight towards(JSONObject dataTest) {
		return instrumented(SearchFlight.class, dataTest);

	}
}
