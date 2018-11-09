package user_interfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


/**
 * Encapsula la informacion de la pagina de registro de usuario
 */
public class RegisterPage extends PageObject {
	
	public static final Target INPUT_FIRST_NAME = Target.the("input first name user").locatedBy("//input[@name='firstName']");
	
	public static final Target INPUT_LAST_NAME = Target.the("input last name user").locatedBy("//input[@name='lastName']");
	
	public static final Target INPUT_PHONE = Target.the("input phone user ").locatedBy("//input[@name='phone']");
	
	public static final Target INPUT_EMAIL = Target.the("input email user ").locatedBy("//input[@id='userName']");
	
	public static final Target INPUT_ADDRESS_PRINCIPAL = Target.the("input first name ").locatedBy("//input[@name='address1']");
	
	public static final Target INPUT_ADDRESS_SECOND = Target.the("input first name ").locatedBy("//input[@name='address2']");
	
	public static final Target INPUT_CITY = Target.the("input city  ").locatedBy("//input[@name='city']");
	
	public static final Target SELECT_COUNTRY = Target.the("list country  ").locatedBy("//select[@name='country']");

					//

	public static final Target INPUT_STATE = Target.the("input state ").locatedBy("//input[@name='state']");
	
	public static final Target INPUT_POSTAL_CODE= Target.the("input postal code ").locatedBy("//input[@name='postalCode']");
	
	public static final Target INPUT_USER_NAME = Target.the("input user name ").locatedBy("//input[@id='email']");
	
	public static final Target INPUT_PASSWORD = Target.the("input password").locatedBy("//input[@name='password']");

	public static final Target INPUT_CONFIRM_PASSWORD = Target.the("input confirm password ").locatedBy("//input[@name='confirmPassword']");
	
	public static final Target BUTTON_REGISTER = Target.the("button register user ").locatedBy("//input[@name='register']");


	

}
