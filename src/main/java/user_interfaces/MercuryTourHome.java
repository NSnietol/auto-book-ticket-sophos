package user_interfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
/**
 * 
 *  referencia el link de la pagina web donde empezara la automatizacion
 * 

 *
 */
@DefaultUrl("http://newtours.demoaut.com/mercurywelcome.php")
public class MercuryTourHome extends PageObject{
	
	public static final Target BUTTON_FLIGHTS = Target.the("button flights").locatedBy("//a[text()='Flights']");
	public static final Target BUTTON_REGISTER = Target.the("button register").locatedBy("//a[text()='REGISTER']");

	
}
 