package co.linio.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.apache.bcel.generic.Select;
import org.json.simple.JSONObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.components.Dropdown;
import user_interfaces.MercuryTourHome;
import user_interfaces.RegisterPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class RegistrerUser implements Task {

	MercuryTourHome homePage;
	RegisterPage registerUserPage;
	JSONObject dataTest;

	public RegistrerUser(JSONObject dataTest) {

		this.dataTest = (JSONObject) dataTest.get("usuario");

	}

	@Step("{0} fill out the register form  ")
	public <T extends Actor> void performAs(T actor) {
		try {

			actor.attemptsTo(Click.on(MercuryTourHome.BUTTON_REGISTER));

			actor.attemptsTo(
					Enter.
					theValue(dataTest.get("nombre").toString()).
					into(RegisterPage.INPUT_FIRST_NAME).thenHit(Keys.TAB),
					Enter.
					theValue(dataTest.get("apellido").toString()).
					into(RegisterPage.INPUT_LAST_NAME).thenHit(Keys.TAB),
					Enter.
					theValue(dataTest.get("telefono").toString()).
					into(RegisterPage.INPUT_PHONE).thenHit(Keys.TAB),
					Enter.
					theValue(dataTest.get("email").toString()).
					into(RegisterPage.INPUT_EMAIL).thenHit(Keys.TAB)
					);
			
			actor.attemptsTo(
					Enter.
					theValue(dataTest.get("direccion1").toString()).
					into(RegisterPage.INPUT_ADDRESS_PRINCIPAL),
					Enter.
					theValue(dataTest.get("direccion2").toString()).
					into(RegisterPage.INPUT_ADDRESS_SECOND),
					Enter.
					theValue(dataTest.get("cuidad").toString()).
					into(RegisterPage.INPUT_CITY),
					Enter.
					theValue(dataTest.get("estado").toString()).
					into(RegisterPage.INPUT_STATE),
					Enter.
					theValue(dataTest.get("codigoPostal").toString()).
					into(RegisterPage.INPUT_POSTAL_CODE)
					
					);
			
			actor.attemptsTo(
					Enter.
					theValue(dataTest.get("usuario").toString()).
					into(RegisterPage.INPUT_USER_NAME),
					Enter.
					theValue(dataTest.get("contrasena").toString()).
					into(RegisterPage.INPUT_PASSWORD),
					Enter.
					theValue(dataTest.get("contrasena").toString()).
					into(RegisterPage.INPUT_PASSWORD)
					);
			
			actor.attemptsTo(
					Click.on(RegisterPage.BUTTON_REGISTER)
					);
					
			
		
			
		
			
		} catch (Exception e) {
			throw e;
			// System.out.println("No encontro el elemento : "+e.getMessage());
			// e.printStackTrace();
		}
	}

	public static RegistrerUser inPage(JSONObject dataTest) {
		return instrumented(RegistrerUser.class, dataTest) ;
	}
}
