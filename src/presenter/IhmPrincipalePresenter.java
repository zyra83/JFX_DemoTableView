package presenter;

import java.time.LocalDate;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import lombok.extern.apachecommons.CommonsLog;
import view.model.MatiereObs;

@CommonsLog
public class IhmPrincipalePresenter {

	@FXML
	private TableView<MatiereObs> tvMatieres;
	@FXML
	private TableColumn<MatiereObs, String> tcLibelle;
	@FXML
	private TableColumn<MatiereObs, Integer> tcCoef;
	@FXML
	private TableColumn<MatiereObs, LocalDate> tcDate;
	@FXML
	private TextField tfLibelle;
	@FXML
	private Spinner<Integer> spCoef;
	@FXML
	private DatePicker dpDate;

	/**
	 * Liste observable : tient la vue au courant de ses ajouts/supression.
	 */
	private ObservableList<MatiereObs> lstMatieres = FXCollections.observableArrayList();

	public IhmPrincipalePresenter() {

	}

	public void cliquer() {
		if (log.isInfoEnabled())
			log.info(String.format("Clique sur le bouton"));
		espionner();

	}

	@FXML
	public void initialize() {
		lstMatieres.add(new MatiereObs("Math", 1, LocalDate.now().plusDays(1)));
		this.tvMatieres.setItems(lstMatieres);
		this.tcLibelle.setCellValueFactory((param) -> param.getValue().getNomProperty() );
		// asObject parceque integerProperty n'éhrite pas de ObservableValue<Integer> donc on encapsule
		this.tcCoef.setCellValueFactory((param) -> param.getValue().getCoefProperty().asObject()  );
		this.tcDate.setCellValueFactory((param) -> param.getValue().getDateProperty() );
	}

	public void espionner() {
		MatiereObs slctMatiere = this.tvMatieres.getSelectionModel().getSelectedItem();
		log.info(String.format("Matiere sélectionnée : %s", slctMatiere));
	}

	public void ajouter() {
		// TODO: ajouter à la liste observable
		MatiereObs m = new MatiereObs(tfLibelle.getText(), spCoef.getValue(), dpDate.getValue());
		this.lstMatieres.add(m);
		// TODO: demander à la façade métier de persister le nouvel objet
		// this.fm.ajouterMatiere(m);
		resetFormulaire();
	}

	private void resetFormulaire() {
		this.tfLibelle.clear();
		this.spCoef.getValueFactory().setValue(0);
		this.dpDate.setValue(null);
	}

	public void supprimer() {
		MatiereObs m = tvMatieres.getSelectionModel().getSelectedItem();
		Integer index = tvMatieres.getSelectionModel().getSelectedIndex();
		this.lstMatieres.remove(m);
		if (log.isInfoEnabled())
			log.info(String.format("Supression de la matière %s à l'index %s.", m.toString(), index.toString()));
	}

	public void editerCoef() {
		MatiereObs m = tvMatieres.getSelectionModel().getSelectedItem();
		Integer index = tvMatieres.getSelectionModel().getSelectedIndex();
		TextInputDialog tid = new TextInputDialog();
		tid.showAndWait();
		this.lstMatieres.get(index).setCoef(Integer.parseInt(tid.getResult()));

		if (log.isInfoEnabled())
			log.info(String.format("Edition du coef %s à l'index %s.", m.toString(), index.toString()));
	}

}
