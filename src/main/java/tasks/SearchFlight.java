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
import user_interfaces.FlightPage;
import user_interfaces.MercuryTourHome;
import user_interfaces.SearchResultsPage;

public class SearchFlight implements Task {

	MercuryTourHome homePage;
	FlightPage flightPage;

	SearchResultsPage searchResultsPage;
	JSONObject dataTest;

	public SearchFlight(JSONObject dataTest) {

		this.dataTest = (JSONObject) dataTest.get("vuelo");
		System.out.println(this.dataTest.toJSONString());
		searchResultsPage = new SearchResultsPage();

	}

	
	/**
	 * Selecionando el tipo de reserva ( Ida y Vuelta o solo ida)
	 * */
	public void choosesType(Actor actor) {
		

		if (dataTest.get("tipo").toString().equals("Round Trip")) {
			actor.attemptsTo(Click.on(FlightPage.INPUT_ROUND_TRIP));
		}else if (dataTest.get("tipo").toString().equals("One Way")) {
			actor.attemptsTo(Click.on(FlightPage.INPUT_ONE_WAY));
		} else {
			throw new PersonalizedException(
					"El tipo de vuelo solicitado no está presente " + dataTest.get("tipo").toString(), null);
		}

	}
	
	/**
	 * Selecionando el numero de pasajes
	 * */
	public void choosesNumberPassanger(Actor actor) {
		
		
		try {
			actor.attemptsTo(SelectFromOptions.byVisibleText(dataTest.get("numPasajeros").toString())
					.from(FlightPage.SELECT_PASSENGER));
			
		} catch (Exception e) {
			throw new PersonalizedException(
					"El numero de pasajeros solicitado  no está presente " + dataTest.get("numPasajeros").toString(), null);
		}
		

	}
	
	/**
	 * Selecionando lugar de partida
	 * */
	public void choosesDeparting(Actor actor) {
		
		
		try {
			actor.attemptsTo(SelectFromOptions.byValue(dataTest.get("salida").toString())
					.from(FlightPage.SELECT_DEPARTING));
			
	
		} catch (Exception e) {
			throw new PersonalizedException(
					"la  salida solicitado no se pudo seleccionar " + dataTest.get("salida").toString(), e);
		}

	}
	
	/**
	 * Selecionando el mes y dia de salida 
	 * */
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
	
	/**
	 * Selecionando el lugar de regreso
	 * */
	public void choosesArraving(Actor actor) {
		
		
		try {
			actor.attemptsTo(SelectFromOptions.byValue(dataTest.get("llegada").toString())
					.from(FlightPage.SELECT_ARRIVING));
			
	
		} catch (Exception e) {
			throw new PersonalizedException(
					"la  llegada solicitada no se pudo seleccionar " + dataTest.get("llegada").toString(), e);
		}

	}
	
	
	/**
	 * Selecionando el mes y dia de llegada 
	 * */
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
	
	
	
	
	/**
	 * Escoger las preferencias del vuelo ( Clase y Aerolinea de preferencia)
	 * */
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
	
	
	@Step("{0} press click in confirm")
	public void pressClickContinue(Actor actor) {
		actor.attemptsTo(Click.on(SearchResultsPage.BUTTON_CONTINUE));
	}
	

	
	/**
	 * De las opciones que aparezcan se selecciona una al azar
	 * */
	@Step("{0} selects the flights")
	public void selectFlight(Actor actor) {
		
	
		
        
		try {
			
			SearchResultsPage.TABLE_RESULTS.resolveFor(actor).waitUntilVisible();
			
			List<WebElementFacade> listDepart =searchResultsPage.getDepartFlights();
			
			Random random = new Random();
			
			int optionDepart = random.nextInt(listDepart.size());
						
			// nextInt genera un numero entre 0 y el extremo, entonces si la lista tiene 6 
			// intenteria acceder a la indice 6, lo que ocasionaria un error
			actor.attemptsTo(Click.on(listDepart.get(optionDepart==0?0:optionDepart-1)));

			if(dataTest.get("tipo").equals("Round Trip")) {
			
				
				List<WebElementFacade> listReturn =searchResultsPage.getReturnFlights();
				 int optionReturn = random.nextInt(listDepart.size());

				// nextInt genera un numero entre 0 y el extremo, entonces si la lista tiene 6 
				// intenteria acceder a la indice 6, lo que ocasionaria un error
				actor.attemptsTo(Click.on(listDepart.get(optionReturn==0?0:optionReturn-1)));
			}
			
			
	
		} catch (Exception e) {
			throw new PersonalizedException("Inconvenientes con la tabla de resultados de busqueda", e);
		}

     
		
		
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
			
			
			pressSearchFlight(actor);
			
			selectFlight(actor);
			
			actor.attemptsTo(Scroll.to(SearchResultsPage.BUTTON_CONTINUE));
			
			
			pressClickContinue(actor);
			
			
				

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
