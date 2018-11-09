package user_interfaces;

import java.util.List;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Representa la interface de usuario donde se concreta la informacion de la reserva
 * 
 * 
 * */


public class BookFlightPage extends PageObject {

	public static final Target FORM_BOOKING_SUMMARY = Target.the("form booking summary")
			.locatedBy("//form[@name='bookflight']");

	public static final Target SELECT_CREDIT_CARD = Target.the("Credit card").locatedBy("//select[@name='creditCard']");
	public static final Target INPUT_CREDIT_NUMBER = Target.the("Credit card number")
			.locatedBy("//input[@name='creditnumber']");
	public static final Target SELECT_CREDIT_CARD_EXPIRATION_MONTH = Target.the("Credit card expiration month")
			.locatedBy("//select[@name='cc_exp_dt_mn']");
	public static final Target SELECT_CREDIT_CARD_EXPIRATION_YEAR = Target.the("Credit card expiration month")
			.locatedBy("//select[@name='cc_exp_dt_yr']");
	public static final Target INPUT_CREDIT_CARD_FIRST_NAME = Target.the("Credit card first name")
			.locatedBy("//input[@name='cc_frst_name']");
	public static final Target INPUT_CREDIT_CARD_MIDDLE_NAME = Target.the("Credit card middle name")
			.locatedBy("//input[@name='cc_mid_name']");
	public static final Target INPUT_CREDIT_CARD_LAST_NAME = Target.the("Credit card last name")
			.locatedBy("//input[@name='cc_last_name']");

	public static final Target INPUT_BILLING_ADDRESS_1 = Target.the("Billing address 1")
			.locatedBy("//input[@name='billAddress1']");

	public static final Target INPUT_BILLING_ADDRESS_2 = Target.the("Billing address 2")
			.locatedBy("//input[@name='billAddress2']");

	public static final Target INPUT_BILLING_ADDRESS_CITY = Target.the("Billing address city")
			.locatedBy("//input[@name='billCity']");

	public static final Target INPUT_BILLING_ADDRESS_STATE = Target.the("Billing address state")
			.locatedBy("//input[@name='billState']");

	public static final Target INPUT_BILLING_ADDRESS_ZIP = Target.the("Billing address state")
			.locatedBy("//input[@name='billZip']");

	public static final Target SELECT_BILLING_ADDRESS_COUNTRY = Target.the("Billing address state")
			.locatedBy("//select[@name='billCountry']");

	public static final Target BUTTON_BUY_FLIGHTS = Target.the("Button buy flights")
			.locatedBy("//input[@name='buyFlights']");

	
	
	// Permite insertar la informacio de los distintos pasajeros 
	public List<WebElementFacade> getInputsFirstNamePassanger() {
		return findAll(By.xpath("//input[starts-with(@name,'passFirst')]"));

	}

	public List<WebElementFacade> getInputsLastNamePassanger() {
		return findAll(By.xpath("//input[starts-with(@name,'passLast')]"));

	}

	public List<WebElementFacade> getInputsPreferencePassanger() {
		return findAll(By.xpath("//select[starts-with(@name,'pass.')]"));

	}

	public List<WebElementFacade> getCheckBoxsBook() {
		return findAll(By.xpath("//input[@name='ticketLess']"));

	}

	//

	// form[@name='bookflight']
}
