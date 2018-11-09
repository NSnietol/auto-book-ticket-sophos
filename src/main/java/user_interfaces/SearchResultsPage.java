package user_interfaces;

import java.util.List;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;


public class SearchResultsPage extends PageObject{

	public static final Target TABLE_RESULTS = Target.the("results of the search").locatedBy("//form[@name='results']");

	public static final Target BUTTON_CONTINUE = Target.the("confirmation").locatedBy("//input[@name='reserveFlights']");

	
	
	
	
	public  List<WebElementFacade> getDepartFlights(){
		return	findAll(By.xpath("//td[@valign='top']//td//td//td//table[1]//td[@class='frame_action_xrows']"));
		
	}
	
	public  List<WebElementFacade> getReturnFlights(){
		return	findAll(By.xpath("//td[@valign='top']//td//td//td//table[2]//td[@class='frame_action_xrows']"));
		
	}
	// IDA
	//td[@valign='top']//td//td//td//table[1]//td[@class='frame_action_xrows']

	
	//td[@valign='top']//td//td//td//table[2]//td[@class='frame_action_xrows']
	//td[@valign='top']//td//td//td//table[2]//td[@class='data_verb_xcols']
	
	//td.frame_action_xrows
}
