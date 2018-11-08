package co.linio.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import user_interfaces.RegisterPage;
import user_interfaces.ShoppingCartPage;

public class UserRegistrationConfirmation implements Question<String>{
	
	RegisterPage registerPage;
	
	public String answeredBy(Actor actor) {
		return Text.of(registerPage.titulo).viewedBy(actor).asString();
	}

	public static TheTitle ofVideo() {
		return new TheTitle();
	}

}
