package presenter;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lombok.extern.apachecommons.CommonsLog;
import model.entities.Matiere;

@CommonsLog
public class IhmPrincipalePresenter {

	@FXML
	private TableView<Matiere> tvMatieres;
	@FXML
	private TableColumn<Matiere, String> tcLibelle;
	@FXML
	private TableColumn<Matiere, Integer> tcCoef;
	@FXML
	private TableColumn<Matiere, LocalDate> tcDate;
	@FXML
	private TextField tfLibelle;
	@FXML
	private Spinner<Integer> spCoef;
	@FXML
	private DatePicker dpDate;

	public IhmPrincipalePresenter() {

	}

	public void cliquer() {
		if (log.isInfoEnabled())
			log.info(String.format("Clique sur le bouton"));

	}

	@FXML
	public void initialize() {

	}

}
