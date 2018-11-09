package exceptions;
import net.serenitybdd.core.exceptions.SerenityManagedException;

// Es una exception personalizada que busca representar los inconvenientes presentados con una mejor descripcion
public class PersonalizedException extends SerenityManagedException{


	
	public PersonalizedException(String message, Throwable testErrorException) {
		super("Ups! se presentó un incoveniente \n "+message, testErrorException);
	}

	
	
}
