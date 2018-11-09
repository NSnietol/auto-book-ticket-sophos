package user_interfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


/**
 * 
 * Contiene el mensaje de confirmacion de la reserva y el boton de cerrar la sesion
 * **/
public class BookingConfirmationPage extends PageObject {

	/**
	 * 
	 * 
	 * **/

	public static final Target CONFIRMATION_MESSAGE = Target.the("Confirmation Message ")
			.locatedBy("//font[contains(text(),'Confirmation # ')]");

	public static final Target BUTTON_SIGN_OFF= Target.the("Button SIGN OFF ")
			.locatedBy("//a[text()='SIGN-OFF']");

	
	
	
	//a[text()='SIGN-OFF']
	
	// /
}
