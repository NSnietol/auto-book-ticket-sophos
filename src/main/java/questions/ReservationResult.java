package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import user_interfaces.BookingConfirmationPage;


// Es la consulta realizada para verificar que si se realizo la reserva
public class ReservationResult implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {

		return Text.of(BookingConfirmationPage.CONFIRMATION_MESSAGE).viewedBy(actor).asString().trim();

	}

	public static ReservationResult is() {
		return new ReservationResult();
	}

}
