package user_interfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

/**
 * 
 * Clase Extiende de PagObject, se encarga de mapear los elementos para la cantidad y nombre del producto visualizado en el carrito de compra
 * 
 * @author ricardo.diaz
 *
 */
public class ShoppingCartPage extends PageObject{
	
	/**
	 * este elemento contiene el nombre del producto 
	 */
	public static final Target NAME_PRODUCT = Target.the("name of the product").locatedBy("//*[@class= 'cart-item row']//following::a[2]");
	/**
	 * este elemento contiene la cantidad del producto
	 */
	public static final Target QUANTITY = Target.the("quantity of the product").locatedBy("//*[@class= 'cart-item row']//*[@class='price-secondary']");

}
