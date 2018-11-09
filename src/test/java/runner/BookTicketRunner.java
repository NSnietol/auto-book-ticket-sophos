package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
/**
 * 
 *
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src.test.resources/features/book_ticket.feature",
		glue = {"steps_definition"}
		
)
		

//snippets = SnippetType.UNDERSCORE
public class BookTicketRunner {}
