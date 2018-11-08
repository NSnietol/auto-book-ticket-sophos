package user_interfaces;

import util.JsonManager;

public class prueba {
 public static void main(String []arg) throws Exception {
	
	 
	 System.out.println( JsonManager.getInstance().getJsonReader().toJSONString());
	
}
}
