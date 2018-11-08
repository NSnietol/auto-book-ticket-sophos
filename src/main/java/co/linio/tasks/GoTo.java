package co.linio.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.Keys;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import user_interfaces.LinioElement;

public class GoTo implements Task {
	
	
	String product;


	public GoTo(String producttoSearch) {
		this.product = producttoSearch;
	}
	@Override
	@Step("{0} search product")
	public <T extends Actor> void performAs(T actor) {
		try {
			if(LinioElement.CLOSE_WINDOW_MODAL.equals(true)) {
				LinioElement.CLOSE_WINDOW_MODAL.wait(25000);
			actor.attemptsTo(Click.on(LinioElement.CLOSE_WINDOW_MODAL));
			}
			actor.attemptsTo(Click.on(LinioElement.LINIO_INPUT_SEARCH));
			actor.attemptsTo(Enter.theValue(this.product).into(LinioElement.LINIO_INPUT_SEARCH).thenHit(Keys.ENTER));
		} catch (Exception e) {
			throw new Exception("error", e);
		//	System.out.println("No encontro el elemento : "+e.getMessage());
		//	e.printStackTrace();
		}
		
	
	}
	

	public static GoTo theProduct(String product) {		
		return instrumented(GoTo.class, product);
	}

}

