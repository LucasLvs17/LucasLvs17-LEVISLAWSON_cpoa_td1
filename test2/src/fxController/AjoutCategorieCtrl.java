package fxController;


import DAO.CategorieDAO;
import DAO.Persistance;
import Factory.DAOFactory;
import FxVues.AjoutCategorieVue;
import POJO.Categorie;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

public class AjoutCategorieCtrl {
	
	private AjoutCategorieVue vue;
	
	@FXML private TextField id_tf_categ;	
	@FXML private Label id_lb_custom;
	@FXML private TableView<Categorie> id_table;
	@FXML private TableColumn id_col_id;
	@FXML private TableColumn id_col_titre;
	@FXML private TextField id_recherche_categorie;
	@FXML private Label id_error_label;
	@FXML private Button id_btn_creer;
	@FXML private Button id_btn_valider;
	@FXML private Button id_btn_annuler;
	@FXML private Label label_categorie;
	
	private  DAOFactory fact;
	
	private int id_select;
	private Persistance p;
	
	public void setVue(AjoutCategorieVue V, Persistance pr) {
		vue = V;
		p = pr;
		remplirTable();
		setModeAjout();
	}
	
	public void setModeAjout(){

		id_btn_valider.setVisible(false);
		id_btn_annuler.setVisible(false);
		id_btn_creer.setVisible(true);
		label_categorie.setText("Nouvelle cat�gorie");
		id_tf_categ.clear(); 
		
	}
	
	public void remplirTable() {
		
		id_table.getItems().clear();
		//on pr�pare les colonnes
		id_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		id_col_titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
		System.out.println(p);
		CategorieDAO c = DAOFactory.getDAOfactory(p).getCategorieDAO();
		ObservableList test = c.getAll();
		id_table.getItems().addAll(test);
		}
	
	public void retourAccueil() {
		this.vue.close();
	}
	
	public void creerCateg() throws Exception {
		String titre = id_tf_categ.getText().trim();
		
		if(titre.equals("") || titre == null) {
			id_lb_custom.setTextFill(Color.RED);
			id_lb_custom.setText("Veuillez renseigner une périodicité svp");
		}else {
			CategorieDAO c = DAOFactory.getDAOfactory(p).getCategorieDAO();
			c.create(new Categorie(1, titre, titre));
			// message de confirmation
			id_lb_custom.setTextFill(Color.BLACK);
			id_lb_custom.setText("P�riodicit� " + titre +  " ajout�e � la bdd");
		}
		
		remplirTable();
	}
	
public void affiModifCateg() {
		
		// on r�cup�re la s�lection
		ObservableList selection = id_table.getSelectionModel().getSelectedItems();
		if(selection.size() == 0) {
			id_error_label.setTextFill(Color.RED);
			id_error_label.setText("Aucune p�riodicit� s�lectionn�e");
		}else if(selection.size() > 1) {
			id_error_label.setTextFill(Color.RED);
			id_error_label.setText("Plusieurs p�riodicit�s s�lectionn�es");
		}else {
			// on pr�pare l'interface 
			Categorie C = ((Categorie) selection.get(0));
			id_select = C.getIdCategorie();
			id_btn_creer.setVisible(false);
			id_btn_valider.setVisible(true);
			id_btn_annuler.setVisible(true);
			label_categorie.setText("Modifier la p�riodicit� n�" + id_select);
			id_tf_categ.setText(C.getTitre());
		}

	}
	
	
	
	public void annulerModif() {
		// message de confirmation
		id_lb_custom.setTextFill(Color.BLACK);
		id_lb_custom.setText("Modification annul�e");
		setModeAjout();
		remplirTable();
	}
	
	public void validerModif() throws Exception {
		String titre = id_tf_categ.getText().trim();
		if(titre.equals("") || titre == null) {
			id_lb_custom.setTextFill(Color.RED);
			id_lb_custom.setText("Veuillez renseigner une cat�gorie svp");
		}else {
			CategorieDAO c = DAOFactory.getDAOfactory(p).getCategorieDAO();
			c.update(new Categorie(id_select, titre, titre));
			// message de confirmation
			id_lb_custom.setTextFill(Color.BLACK);
			id_lb_custom.setText("Cat�gorie" + id_select + " modifi�e dans la bdd");
		}
		remplirTable();
		setModeAjout();
	}
	
	@FXML
	public void supprCateg() throws Exception {
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
					CategorieDAO r = DAOFactory.getDAOfactory(p).getCategorieDAO();
					r.delete((Categorie)selection.get(0));
				}
				remplirTable();
	}
	
	public void rechercheCategorie() {
		String titre = id_recherche_categorie.getText().trim();
		
		if(titre.equals("") || titre.equals(null)) {
			id_error_label.setTextFill(Color.RED);
			id_error_label.setText("Entrer une cat�gorie pour la recherche svp");
		}else {
			id_table.getItems().clear();
			//on pr�pare les colonnes
			id_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
			id_col_titre.setCellValueFactory(new PropertyValueFactory<>("cat�gorie"));
			
			CategorieDAO c = DAOFactory.getDAOfactory(p).getCategorieDAO();
			ObservableList test = c.getByTitre(titre);
			
			// si aucun r�sultat
			if(test.isEmpty()) {
				id_error_label.setTextFill(Color.RED);
				id_error_label.setText("Aucun r�sultat");
			}
			id_table.getItems().addAll(test);
		}
		
	}

}
