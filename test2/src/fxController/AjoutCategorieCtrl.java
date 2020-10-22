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
		label_categorie.setText("Nouvelle catégorie");
		id_tf_categ.clear(); 
		
	}
	
	public void remplirTable() {
		
		id_table.getItems().clear();
		//on prépare les colonnes
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
			id_lb_custom.setText("Veuillez renseigner une pÃ©riodicitÃ© svp");
		}else {
			CategorieDAO c = DAOFactory.getDAOfactory(p).getCategorieDAO();
			c.create(new Categorie(1, titre, titre));
			// message de confirmation
			id_lb_custom.setTextFill(Color.BLACK);
			id_lb_custom.setText("Périodicité " + titre +  " ajoutée à la bdd");
		}
		
		remplirTable();
	}
	
public void affiModifCateg() {
		
		// on récupère la sélection
		ObservableList selection = id_table.getSelectionModel().getSelectedItems();
		if(selection.size() == 0) {
			id_error_label.setTextFill(Color.RED);
			id_error_label.setText("Aucune périodicité sélectionnée");
		}else if(selection.size() > 1) {
			id_error_label.setTextFill(Color.RED);
			id_error_label.setText("Plusieurs périodicités sélectionnées");
		}else {
			// on prépare l'interface 
			Categorie C = ((Categorie) selection.get(0));
			id_select = C.getIdCategorie();
			id_btn_creer.setVisible(false);
			id_btn_valider.setVisible(true);
			id_btn_annuler.setVisible(true);
			label_categorie.setText("Modifier la périodicité n°" + id_select);
			id_tf_categ.setText(C.getTitre());
		}

	}
	
	
	
	public void annulerModif() {
		// message de confirmation
		id_lb_custom.setTextFill(Color.BLACK);
		id_lb_custom.setText("Modification annulée");
		setModeAjout();
		remplirTable();
	}
	
	public void validerModif() throws Exception {
		String titre = id_tf_categ.getText().trim();
		if(titre.equals("") || titre == null) {
			id_lb_custom.setTextFill(Color.RED);
			id_lb_custom.setText("Veuillez renseigner une catégorie svp");
		}else {
			CategorieDAO c = DAOFactory.getDAOfactory(p).getCategorieDAO();
			c.update(new Categorie(id_select, titre, titre));
			// message de confirmation
			id_lb_custom.setTextFill(Color.BLACK);
			id_lb_custom.setText("Catégorie" + id_select + " modifiée dans la bdd");
		}
		remplirTable();
		setModeAjout();
	}
	
	@FXML
	public void supprCateg() throws Exception {
		//on récupère la ligne sélectionnée
				ObservableList selection = id_table.getSelectionModel().getSelectedItems();
				if(selection.size()==0) {
					id_error_label.setTextFill(Color.RED);
					id_error_label.setText("Aucune revue sélectionnée");
				}else if(selection.size() > 1) {
					id_error_label.setTextFill(Color.RED);
					id_error_label.setText("Plusieurs revues sélectionnées");
				}else {
					//on supprime la ligne sélectionnée de la vue et de la bdd
					//utilisation de la méthode delete située dans RequetesSQL
					CategorieDAO r = DAOFactory.getDAOfactory(p).getCategorieDAO();
					r.delete((Categorie)selection.get(0));
				}
				remplirTable();
	}
	
	public void rechercheCategorie() {
		String titre = id_recherche_categorie.getText().trim();
		
		if(titre.equals("") || titre.equals(null)) {
			id_error_label.setTextFill(Color.RED);
			id_error_label.setText("Entrer une catégorie pour la recherche svp");
		}else {
			id_table.getItems().clear();
			//on prépare les colonnes
			id_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
			id_col_titre.setCellValueFactory(new PropertyValueFactory<>("catégorie"));
			
			CategorieDAO c = DAOFactory.getDAOfactory(p).getCategorieDAO();
			ObservableList test = c.getByTitre(titre);
			
			// si aucun résultat
			if(test.isEmpty()) {
				id_error_label.setTextFill(Color.RED);
				id_error_label.setText("Aucun résultat");
			}
			id_table.getItems().addAll(test);
		}
		
	}

}
