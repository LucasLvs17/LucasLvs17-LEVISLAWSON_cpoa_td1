package FxVues;

import java.net.URL;

import DAO.Persistance;
import fxController.AjoutCategorieCtrl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AjoutCategorieVue extends Stage{
	
	public AjoutCategorieVue(Persistance p) {
		try {
			final URL fxmlURL= getClass().getResource("/sources/categorie.fxml");
	        this.setTitle("Saisir une catégorie");
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL); 
			final VBox node = (VBox)fxmlLoader.load();
	        this.setScene(new Scene(node, 1307, 519));
	        AjoutCategorieCtrl controleur = fxmlLoader.getController();
	        controleur.setVue(this, p);
			this.initModality(Modality.APPLICATION_MODAL);
	        this.show();
		}catch(Exception e){
			
		}
}

}
