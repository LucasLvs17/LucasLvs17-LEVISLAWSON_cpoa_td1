package FxVues;

import java.net.URL;

import DAO.Persistance;
import fxController.AjoutClientCtrl;
import fxController.AjoutCommandeCtrl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AjoutCommandeVue extends Stage{
	
	public AjoutCommandeVue(Persistance p) {
		try {
			final URL fxmlURL= getClass().getResource("/sources/commande.fxml");
	        this.setTitle("Saisir un client");
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL); 
			final VBox node = (VBox)fxmlLoader.load();
	        this.setScene(new Scene(node, 1307, 519));
	        AjoutCommandeCtrl controleur = fxmlLoader.getController();
	        controleur.setVue(this, p);
			this.initModality(Modality.APPLICATION_MODAL);
	        this.show();
		}catch(Exception e){
			
		}
}

}
