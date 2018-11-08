package user_interfaces;

import java.util.List;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
/**
 * 
 * Clase Extiende de PagObject, se encarga de mapear la lista de todos los productos buscados
 * 
 * @author ricardo.diaz
 *
 */
public class ProductoLista extends PageObject {
	
	public  List<WebElementFacade> listaProductos(){
		List<WebElementFacade> listaProductos = findAll(By.xpath("//*[@class='catalogue-product row']"));
		return listaProductos;

	}

}
