package co.linio.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import user_interfaces.LinioElement;

public class AddToShoppingCart  implements Task{
	
	@Override
	@Step("{0} add product")
	public <T extends Actor> void performAs(T actor) {
		try {
			actor.attemptsTo(Click.on(LinioElement.SHOPPING_CART));	
			actor.attemptsTo(Click.on(LinioElement.CONFIRM_SHOPPING_CART));	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No encontro el elemento : "+e.getMessage());
			e.printStackTrace();
		}
		
		
	
	}

	public static AddToShoppingCart theProduct() {		
		return instrumented(AddToShoppingCart.class);
	}

}
