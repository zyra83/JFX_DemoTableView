package lanceur;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class Lanceur extends Application {

	/**
	 * C'est cette méthode que lance FX pour démarrer le thread d'affichage. Par
	 * contre, depuis le main, c'est la méthode launch qu'il faut appeller.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		/*
		 * STATIQUE - charger le fichier XML qui contient la description de
		 * l'interface graphique.
		 */
		VBox layout = FXMLLoader.load(this.getClass().getResource("/view/IhmPrincipale.fxml"));

		Scene scene = new Scene(layout);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Premier FX en déclaratif");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
