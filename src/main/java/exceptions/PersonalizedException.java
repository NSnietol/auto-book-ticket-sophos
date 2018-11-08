package exceptions;
import net.serenitybdd.core.exceptions.SerenityManagedException;

public class PersonalizedException extends SerenityManagedException{


	
	public PersonalizedException(String message, Throwable testErrorException) {
		super("Ups! se presentó un incoveniente \n "+message, testErrorException);
		// TODO Auto-generated constructor stub
	}

	
	
}
