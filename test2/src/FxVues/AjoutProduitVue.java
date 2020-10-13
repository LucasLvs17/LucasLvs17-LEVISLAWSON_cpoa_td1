package FxVues;

import java.net.URL;

/*import DAO.Persistance;*/
import fxController.AjoutProduitCtrl;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class AjoutProduitVue extends Stage{
	
	public AjoutProduitVue(/*Persistance p*/) {
		try {
			final URL fxmlURL= getClass().getResource("/sources/1.fxml");
	        this.setTitle("Saisir une revue");
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			final VBox node = (VBox)fxmlLoader.load();
			Scene scene = new Scene(node, 1307, 519);
			this.setScene(scene);
			this.initModality(Modality.APPLICATION_MODAL);
			AjoutProduitCtrl controleur = fxmlLoader.getController();
			controleur.setVue(this/*, p*/);
			this.show();
		}catch(Exception e){
			
		}
}

}