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
		
		BoxAPIConnection api = new BoxAPIConnection("oCkCNgww2UJ8q0dXiKG2eg4gzFHP4ohi");
		BoxFolder rootFolder = BoxFolder.getRootFolder(api);
		for (BoxItem.Info itemInfo : rootFolder) {
		    System.out.format("[%s] %s\n", itemInfo.getID(), itemInfo.getName());
		}

		System.exit(0);
	}

}
