/**
 * 
 */
package lawn;

//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;

import com.box.sdk.BoxAPIConnection;
import com.box.sdk.BoxFolder;
import com.box.sdk.BoxItem;

//import controllers.ContractController;
//import controllers.LawnAreaController;
//import model.Contract;
//import model.LawnArea;
//import model.Position;

/**
 * Basic application driver
 * @author user
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//TODO: This is just a driver. It currently doesn't do anything, but I left some
		// commented out code for doing a few simple operations to interact with the DB.
		
//		LawnAreaController rla = new LawnAreaController();
//		ContractController con_cont = new ContractController();
		
		/**
		 * Java8 syntactic sugar for doing the following:
		 * for(LawnArea la: rla.getLawnAreas()) {
		 * 		System.out.println(la);
		 * }
		 */
//		rla.getLawnAreas().forEach(System.out::println);
//		con_cont.getContracts().forEach(System.out::println);		

		//Delete all LAs
		//rla.getLawnAreas().forEach((templa) -> rla.deleteLawnArea(templa)); 

		System.exit(0);
	}

}
