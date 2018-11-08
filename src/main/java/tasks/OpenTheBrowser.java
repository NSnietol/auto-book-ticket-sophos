package tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheBrowser implements Task {

	private PageObject page;
	

	public OpenTheBrowser(PageObject page) {
		this.page = page;
	}


	// Intenta lanzar el navegador al  2 veces
	@Override
	@Step("{0} goes to #OpenTheApplication")
	public <T extends Actor> void performAs(T actor) {

		for (int i = 0; i < 2; i++) {

			try {

				actor.attemptsTo(Open.browserOn(page));
				break;

			} catch (Exception e) {
				e.printStackTrace();
				if(i==1) {
					throw e;
				}
			}
		}

	}
	
	public static OpenTheBrowser at(PageObject page) {
		return instrumented(OpenTheBrowser.class, page) ;
	}

}
