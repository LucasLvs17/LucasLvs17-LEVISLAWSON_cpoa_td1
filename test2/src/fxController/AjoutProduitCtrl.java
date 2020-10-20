package fxController;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.Persistance;
import DAO.ProduitDAO;
import Factory.DAOFactory;
import FxVues.AjoutProduitVue;
import POJO.Categorie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.control.*;

public class AjoutProduitCtrl implements Initializable{
	
	private AjoutProduitVue vue;
	
	@FXML private TextField nom_lb; 
	@FXML private TextArea desc_lb;
	@FXML private TextField tarif_lb;
	@FXML private ChoiceBox<Categorie> cbxCategorie;
//	@FXML private ComboBox<Periodicite> id_cb_period;
	@FXML private Label id_lb_custom;
	//@FXML private TableView<Produit> id_table;
	//@FXML private TextField id_recherche_tarif;
	@FXML private Button btnCree;
	
private int id_select;
	
	
	private Persistance p;
	
	public void setVue(AjoutProduitVue V , Persistance pr) {
		vue = V;
		p = pr;
		remplirTable();
		setModeAjout();
	}
	
	
	public void setModeAjout(){
		//id_btn_valider.setVisible(false);
		//id_btn_annuler.setVisible(false);
		btnCree.setVisible(true);
		nom_lb.setText("Nouveau Produit");
		nom_lb.clear(); 
		desc_lb.clear();
		tarif_lb.clear();
		//id_cb_period.getSelectionModel().select(-1);
	}
	
public void remplirTable() {
		
		/*id_table.getItems().clear();
		//on prÈpare les colonnes
		id_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		id_col_titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
		id_col_desc.setCellValueFactory(new PropertyValueFactory<>("desc"));
		id_col_tarif.setCellValueFactory(new PropertyValueFactory<>("tarif"));
		id_col_period.setCellValueFactory(new PropertyValueFactory<>("libellePeriod"));
		id_col_abo.setCellValueFactory(new PropertyValueFactory<>("nbAbonnements"));
		//ProduitDAO c = DAOFactory.getDAOfactory(p).getProduitDAO();
		ObservableList test = c.getAll();
		id_table.getItems().addAll(test);
		System.out.println(id_table.getColumns().get(5).getText());*/
		
	}
	
@FXML
public void creerModele(){
	// on r√©cup√®re les champs
	String titre = nom_lb.getText().trim();
	String Description = desc_lb.getText().trim();
	String tariflb = tarif_lb.getText().trim();
	double tarif;
	boolean tarifInvalide = false;
	try {
		tarif= Double.parseDouble(tariflb);
	}catch(NumberFormatException e) {
		tarifInvalide = true;
	}
	
	// on v√©rifie que les champs ne sont pas vides
	if(titre.equals("") || titre == null) {
		id_lb_custom.setTextFill(Color.RED);
		id_lb_custom.setText("Veuillez renseigner un titre svp");
	}else if(Description.equals("") || Description == null) {
		id_lb_custom.setTextFill(Color.RED);
		id_lb_custom.setText("Veuillez renseigner la description svp");
	}else if(tariflb.equals("") || tariflb == null) {
		id_lb_custom.setTextFill(Color.RED);
		id_lb_custom.setText("Veuillez renseigner un tarif svp");
	}else if(cbxCategorie.getSelectionModel().getSelectedItem() == null) {
		id_lb_custom.setTextFill(Color.RED);
		id_lb_custom.setText("Veuillez choisir la catÈgorie svp");
	}else if(tarifInvalide == true) {
		id_lb_custom.setTextFill(Color.RED);
		id_lb_custom.setText("Veuillez entrer un tarif correct svp");
	}else {
		// tout est correct, on ins√®re dans la BdD
		tarif = Double.parseDouble(tariflb);
		//String period = id_cb_period.getSelectionModel().getSelectedItem().toString();
		//PeriodiciteDAO r = DAOFactory.getDAOfactory(p).getPeriodiciteDAO();
		//int id = ((Periodicite) r.getByLibelle(period).get(0)).getId();
		//ProduitDAO s = DAOFactory.getDAOfactory(p).getProduitDAO();
		//Produit Prod = new Produit(1, titre, desc, tarif, "pas d'image");
		//s.create(Produit);
		// message de confirmation
		id_lb_custom.setTextFill(Color.ORANGE);
		id_lb_custom.setText("Produit " + titre + " ajoutÈ ‡ la Bdd ");
	}
	
	remplirTable();
}

public void validerModif() {
	// on r√©cup√®re les champs
			String titre = nom_lb.getText().trim();
			String description = desc_lb.getText().trim();
			String tarifT = tarif_lb.getText().trim();
			double tarif;
			boolean tarifInvalide = false;
			try {
				tarif= Double.parseDouble(tarifT);
			}catch(NumberFormatException e) {
				tarifInvalide = true;
			}
			
			// on v√©rifie que les champs ne sont pas vides
			if(titre.equals("") || titre == null) {
				id_lb_custom.setTextFill(Color.RED);
				id_lb_custom.setText("Veuillez renseigner un titre svp");
			}else if(description.equals("") || description == null) {
				id_lb_custom.setTextFill(Color.RED);
				id_lb_custom.setText("Veuillez renseigner la description svp");
			}else if(tarifT.equals("") || tarifT == null) {
				id_lb_custom.setTextFill(Color.RED);
				id_lb_custom.setText("Veuillez renseigner un tarif svp");
			}else if(cbxCategorie.getSelectionModel().getSelectedItem() == null) {
				id_lb_custom.setTextFill(Color.RED);
				id_lb_custom.setText("Veuillez choisir la categorie svp");
			}else if(tarifInvalide == true) {
				id_lb_custom.setTextFill(Color.RED);
				id_lb_custom.setText("Veuillez entrer un tarif correct svp");
			}else {
				// tout est correct, on ins√®re dans la BdD
				tarif = Double.parseDouble(tarifT);
				//String period = id_cb_period.getSelectionModel().getSelectedItem().toString();
				//MySQLPeriodiciteDAO p = MySQLPeriodiciteDAO.getInstance();
				//int id = p.getByLibelle(period).get(0).getId();
				//MySQLProduitDAO r = MySQLProduitDAO.getInstance();
				//Produit Rev = new Produit(id_select, titre, description, tarif, "pas d'image", id);
				//r.update(Rev);
				// message de confirmation
				id_lb_custom.setTextFill(Color.BLACK);
				id_lb_custom.setText("Produit n∞" + id_select + " modifiÈe dans la bdd");
			}
			
			remplirTable();
			setModeAjout();
}

/*@FXML
public void creerModele(ActionEvent event) {
	event.consume();
	System.out.println("Áa marche");
}*/

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	DAOFactory dao = DAOFactory.getDAOfactory(Persistance.LISTE_MEMOIRE);
	this.cbxCategorie.setItems(FXCollections.observableArrayList(dao.getCategorieDAO().findAll()));
	
}

}
