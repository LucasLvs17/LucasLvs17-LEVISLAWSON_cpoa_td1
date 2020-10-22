package fxController;

import java.time.LocalDate;

import DAO.ClientDAO;
import DAO.CommandeDAO;
import DAO.Persistance;
import Factory.DAOFactory;
import FxVues.AjoutClientVue;
import FxVues.AjoutCommandeVue;
import POJO.Client;
import POJO.Commande;
import POJO.Produit;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

public class AjoutCommandeCtrl {
	
	private AjoutCommandeVue vue;
	
	@FXML private ComboBox<Client> id_cb_client;
	//@FXML private ComboBox<Produit> id_cb_revue;
	@FXML private DatePicker id_dp_date;
	@FXML private DatePicker id_recherche_debut;
	@FXML private Label id_lb_custom;
	@FXML private TableView<Commande> id_table;
	@FXML private TableColumn id_col_client;
	@FXML private TableColumn id_col_commande;
	@FXML private TableColumn id_col_date_com;
	@FXML private CheckBox id_cb_en_cours;
	@FXML private Label id_error_label;
	@FXML private Button id_btn_creer;
	@FXML private Button id_btn_valider;
	@FXML private Button id_btn_annuler;
	@FXML private Label label_commande;
	
	private int id_select;
	private Persistance p;
	
	public void setVue(AjoutCommandeVue V, Persistance pr) {
		vue = V;
		p = pr;
		// remplissage combobox
		ClientDAO c =  DAOFactory.getDAOfactory(p).getClientDAO();
		ObservableList<Client> list = c.getAll(); 
		//System.out.println(list.toString());
		id_cb_client.setItems(list);
		
		remplirTable();
		setModeAjout();
	}
	
	public void setModeAjout(){
		id_btn_valider.setVisible(false);
		id_btn_annuler.setVisible(false);
		id_btn_creer.setVisible(true);
		label_commande.setText("Nouvel abonnement");
		id_cb_client.getSelectionModel().select(-1);
		//id_cb_revue.getSelectionModel().select(-1);
		id_dp_date.setValue(null);
		id_cb_client.setDisable(false);
		//id_cb_revue.setDisable(false);
	}
	
	public void remplirTable() {
		
		id_table.getItems().clear();
		//on pr�pare les colonnes
		id_col_client.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
		//id_col_revue.setCellValueFactory(new PropertyValueFactory<>("nomRevue"));
		id_col_date_com.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
		
		if(id_cb_en_cours.isSelected()) {
			CommandeDAO c = DAOFactory.getDAOfactory(p).getCommandeDAO();
			ObservableList test = c.getEnCours();
			id_table.getItems().addAll(test);
		}else {
			CommandeDAO c = DAOFactory.getDAOfactory(p).getCommandeDAO();
			ObservableList test = c.getAll();
			id_table.getItems().addAll(test);
		}
		

		
	}
	
	public void retourAccueil() {
		this.vue.close();
	}
	
	@FXML
	public void creerCom() throws Exception {
		LocalDate date = id_dp_date.getValue();
		
		if(date == null) {
			id_lb_custom.setTextFill(Color.RED);
			id_lb_custom.setText("Veuillez renseigner une date de d�but svp");
		}else if(id_cb_client.getSelectionModel().getSelectedItem() == null) {
			id_lb_custom.setTextFill(Color.RED);
			id_lb_custom.setText("Veuillez choisir un client svp");
		}else {
			// tout est correct, on ins�re dans la BdD
			Client  cli = id_cb_client.getSelectionModel().getSelectedItem();
			//Revue  rev = id_cb_revue.getSelectionModel().getSelectedItem();
			
			CommandeDAO r = DAOFactory.getDAOfactory(p).getCommandeDAO();
			Commande Com = new Commande();
			r.create(Com);
			// message de confirmation
			id_lb_custom.setTextFill(Color.BLACK);
			id_lb_custom.setText("Abonnement ajout�� la Bdd ");
		}
		remplirTable();
	}
	
public void rechercheDate() {
		
		
		id_table.getItems().clear();
		LocalDate date = id_recherche_debut.getValue();
		
		if(date == null) {
			id_error_label.setTextFill(Color.RED);
			id_error_label.setText("Entrer une date pour la recherche svp");
		}else {
			//on pr�pare les colonnes
			id_col_client.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
			//id_col_revue.setCellValueFactory(new PropertyValueFactory<>("nomRevue"));
			id_col_date_com.setCellValueFactory(new PropertyValueFactory<>("dateCom"));

			CommandeDAO c = DAOFactory.getDAOfactory(p).getCommandeDAO();
			ObservableList test = c.getByDate(date);
			
			//si aucun r�sultat
			if(test.isEmpty()) {
				id_error_label.setTextFill(Color.RED);
				id_error_label.setText("Aucun r�sultat");
			}else {
				id_error_label.setTextFill(Color.BLACK);
				id_error_label.setText("Recherche termin�e");
			}
			id_table.getItems().addAll(test);
		}
		


	}

public void triParClient(){
	id_table.getItems().clear();
	//on pr�pare les colonnes
	id_col_client.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
	//id_col_revue.setCellValueFactory(new PropertyValueFactory<>("nomRevue"));
	id_col_date_com.setCellValueFactory(new PropertyValueFactory<>("dateCom"));
	CommandeDAO c = DAOFactory.getDAOfactory(p).getCommandeDAO();		
	ObservableList test = c.getAllByClient();
	id_table.getItems().addAll(test);

	
}

public void triParId(){
	id_table.getItems().clear();
	//on pr�pare les colonnes
	id_col_client.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
	//id_col_revue.setCellValueFactory(new PropertyValueFactory<>("nomRevue"));
	id_col_date_com.setCellValueFactory(new PropertyValueFactory<>("dateCom"));
	CommandeDAO c = DAOFactory.getDAOfactory(p).getCommandeDAO();
	ObservableList test = c.getAllById();
	id_table.getItems().addAll(test);
}

public void affiModifCom() {
	
	// on r�cup�re la s�lection
	ObservableList selection = id_table.getSelectionModel().getSelectedItems();
	if(selection.size() == 0) {
		id_error_label.setTextFill(Color.RED);
		id_error_label.setText("Aucune commande s�lectionn�");
	}else if(selection.size() > 1) {
		id_error_label.setTextFill(Color.RED);
		id_error_label.setText("Plusieurs commandes s�lectionn�s");
	}else {
		// on pr�pare l'interface 
		Commande a = ((Commande) selection.get(0));
		//id_client = a.getId_client();
		//id_revue = a.getIdRevue();
		id_cb_client.setDisable(true);
		//id_cb_revue.setDisable(true);
		id_btn_creer.setVisible(false);
		id_btn_valider.setVisible(true);
		id_btn_annuler.setVisible(true);
		//label_commande.setText("Modifier la commande du client" + id_client + "");

		ClientDAO i = DAOFactory.getDAOfactory(p).getClientDAO();
		id_cb_client.getSelectionModel().select(i.getById(a.getId_client()));
		//RevueDAO o = DAOFactory.getDAOfactory(p).getRevueDAO();
		//id_cb_revue.getSelectionModel().select(o.getById(a.getIdRevue()));
		
		System.out.println("Test :" + i.getById(a.getId_client()).toString());

		id_dp_date.setValue(a.getDate_commande());
	}

}

public void validerModif() throws Exception {
	LocalDate date = id_dp_date.getValue();
	
	if(date== null) {
		id_lb_custom.setTextFill(Color.RED);
		id_lb_custom.setText("Veuillez renseigner une date de d�but svp");
	}else if(id_cb_client.getSelectionModel().getSelectedItem() == null) {
		id_lb_custom.setTextFill(Color.RED);
		id_lb_custom.setText("Veuillez choisir un client svp");
	}else {
		// tout est correct, on ins�re dans la BdD
		Client  cli = id_cb_client.getSelectionModel().getSelectedItem();
		//Revue  rev = id_cb_revue.getSelectionModel().getSelectedItem();
		
		CommandeDAO r = DAOFactory.getDAOfactory(p).getCommandeDAO();
		Commande Com = new Commande();
		r.update(Com);
		// message de confirmation
		id_lb_custom.setTextFill(Color.BLACK);
		id_lb_custom.setText("Abonnement modifi� dans la Bdd ");
	}
	remplirTable();
	setModeAjout();
}

public void annulerModif() {
	// message de confirmation
	id_lb_custom.setTextFill(Color.BLACK);
	id_lb_custom.setText("Modification annul�e");
	setModeAjout();
	remplirTable();
}

@FXML
public void supprCom() throws Exception {
	//on r�cup�re la ligne s�lectionn�e
			ObservableList selection = id_table.getSelectionModel().getSelectedItems();
			if(selection.size()==0) {
				id_error_label.setTextFill(Color.RED);
				id_error_label.setText("Aucune revue s�lectionn�e");
			}else if(selection.size() > 1) {
				id_error_label.setTextFill(Color.RED);
				id_error_label.setText("Plusieurs revues s�lectionn�es");
			}else {
				//on supprime la ligne s�lectionn�e de la vue et de la bdd
				//utilisation de la m�thode delete situ�e dans RequetesSQL
				CommandeDAO a = DAOFactory.getDAOfactory(p).getCommandeDAO();
				a.delete((Commande)selection.get(0));
			}
			remplirTable();
}


}
