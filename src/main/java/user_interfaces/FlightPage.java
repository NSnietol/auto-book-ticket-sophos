package user_interfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class FlightPage extends PageObject{

	
public static final Target INPUT_ROUND_TRIP = Target.the("input  type round trip  ").locatedBy("//input[@value='roundtrip']");
	
	public static final Target INPUT_ONE_WAY = Target.the("input type one way ").locatedBy("//input[@value='oneway']");
	

	public static final Target SELECT_PASSENGER = Target.the("select number passenger").locatedBy("//select[@name='passCount']");

	
	public static final Target SELECT_DEPARTING = Target.the("select departing from").locatedBy("//select[@name='fromPort']");

	
	public static final Target SELECT_FROM_MONTH = Target.the("select from month ").locatedBy("//select[@name='fromMonth']");

	
	public static final Target SELECT_FROM_DAY = Target.the("select from day ").locatedBy("//select[@name='fromDay']");

	public static final Target SELECT_ARRIVING = Target.the("select arriving ").locatedBy("	//select[@name='toPort']");

	public static final Target SELECT_TO_MONTH = Target.the("select to month").locatedBy("//select[@name='toMonth']");

	
	public static final Target SELECT_TO_DAY = Target.the("select to day ").locatedBy("//select[@name='toDay']");
	public static final Target INPUT_ECONOMY_CLASS = Target.the("input economy class").locatedBy("//input[@value='Coach']");
	public static final Target INPUT_BUSSINES_CLASS = Target.the("input bussines class").locatedBy("//input[@value='Business']");
	public static final Target INPUT_FIRST_CLASS = Target.the("input first class").locatedBy("//input[@value='First']");

	public static final Target SELECT_AIRLINE = Target.the("select airline").locatedBy("//select[@name='airline']");

	
	
	public static final Target BUTTON_CONTINUE = Target.the("button continue").locatedBy("//input[@name='findFlights']");

}
