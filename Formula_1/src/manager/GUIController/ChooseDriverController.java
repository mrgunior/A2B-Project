package manager.GUIController;

import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import manager.controller.GameController;
import manager.controller.SceneLoadController;
import manager.model.Driver;
import manager.model.Profile;
import manager.model.formulaApplication;

public class ChooseDriverController extends SceneLoadController implements Initializable {
	// Background
	@FXML
	private AnchorPane root;
	@FXML
	private ImageView background;

	// Scene elements
	@FXML
	private ImageView next;

	@FXML
	private Pane alonso, bottas, button, ericsson, grosjean, gutierrez, hamilton, haryanto, hulkenberg, kvyat,
	magnussen, massa, nasr, palmer, perez, raikkonnen, ricciardo, rosberg, sainz, verstappen, vettel, wehrlein;

	@FXML
	private Text alonsoSalary, bottasSalary, buttonSalary, ericssonSalary, grosjeanSalary, gutierrezSalary,
			hamiltonSalary, haryantoSalary, hulkenbergSalary, kvyatSalary, magnussenSalary, massaSalary, nasrSalary,
			palmerSalary, perezSalary, raikkonnenSalary, ricciardoSalary, rosbergSalary, sainzSalary, verstappenSalary,
			vettelSalary, wehrleinSalary;
	
	// Color variables
	Color teamSelectedColor = new Color(0, 0, 0, .26);
	Color teamNotSelectedColor = new Color(0, 0, 0, 0);

	Pane driver1 = null;
	Pane driver2 = null;

	String driver1String = "";
	String driver2String = "";

	ArrayList<Driver> drivers = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());
		
		drivers = GameController.getProfile().getAllDrivers();
		drivers.sort(Driver.sortById());
		
		Text[] salaries = {alonsoSalary, bottasSalary, buttonSalary, ericssonSalary, grosjeanSalary, gutierrezSalary,
				hamiltonSalary, haryantoSalary, hulkenbergSalary, kvyatSalary, magnussenSalary, massaSalary, nasrSalary,
				palmerSalary, perezSalary, raikkonnenSalary, ricciardoSalary, rosbergSalary, sainzSalary, verstappenSalary,
				vettelSalary, wehrleinSalary};

		for (int i = 0; i < 22; i++) {
			salaries[i].setText("$ " + drivers.get(i).getSalary()/1000000 + " Mill/race");
		}
		
		driver1 = alonso;
		driver2 = massa;
		driver1String = "Fernando Alonso";
		driver2String = "Felipe Massa";
		setSelected(driver1);
		setSelected(driver2);
		// Click

		next.setOnMousePressed(event -> {

			try {
				if (driver1 != null && driver2 != null) {
					//######################Some Code For Setting Drivers###########################
					// ArrayList<Driver> drivers = new ArrayList<Driver>();
					// drivers.add(driver1String);
					// drivers.add(driver2String);
					// formulaApplication.setDrivers(drivers);

				}
				
				GameController.writeJsonObjectToFile();
				gotoFxmlScene("Dashboard", (Stage) next.getScene().getWindow());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		// Hover on
		next.setOnMouseEntered(event -> {
			next.setImage(new Image("file:images/menu/NextHover.png"));
		});
		// Hover off
		next.setOnMouseExited(event -> {
			next.setImage(new Image("file:images/menu/Next.png"));
		});

		// Team Choices
		alonso.setOnMousePressed(event -> {
			selectDriver(alonso, "Fernando Alonso");
		});
		bottas.setOnMousePressed(event -> {
			selectDriver(bottas, "Valtteri Bottas");
		});
		button.setOnMousePressed(event -> {
			selectDriver(button, "Jensen Button");
		});
		ericsson.setOnMousePressed(event -> {
			selectDriver(ericsson, "Marcus Ericsson");
		});
		grosjean.setOnMousePressed(event -> {
			selectDriver(grosjean, "Romain Grosjean");
		});
		gutierrez.setOnMousePressed(event -> {
			selectDriver(gutierrez, "Esteban Gutierrez");
		});
		hamilton.setOnMousePressed(event -> {
			selectDriver(hamilton, "Lewis Hamilton");
		});
		haryanto.setOnMousePressed(event -> {
			selectDriver(haryanto, "Rio Haryanto");
		});
		hulkenberg.setOnMousePressed(event -> {
			selectDriver(hulkenberg, "Nicolas Hulkenberg");
		});
		kvyat.setOnMousePressed(event -> {
			selectDriver(kvyat, "Daniil Kvyat");
		});
		magnussen.setOnMousePressed(event -> {
			selectDriver(magnussen, "Kevin Magnussen");
		});
		massa.setOnMousePressed(event -> {
			selectDriver(massa, "Felipe Massa");
		});
		nasr.setOnMousePressed(event -> {
			selectDriver(nasr, "Felipe Nasr");
		});

		palmer.setOnMousePressed(event -> {
			selectDriver(palmer, "Jolyon Palmer");
		});

		perez.setOnMousePressed(event -> {
			selectDriver(perez, "Sergio Perez");
		});

		raikkonnen.setOnMousePressed(event -> {
			selectDriver(raikkonnen, "Kimi Raikkonnen");
		});

		ricciardo.setOnMousePressed(event -> {
			selectDriver(ricciardo, "Daniel Ricciardo");
		});

		rosberg.setOnMousePressed(event -> {
			selectDriver(rosberg, "Nico Rosberg");
		});

		sainz.setOnMousePressed(event -> {
			selectDriver(sainz, "Carloz Sainz Jr.");
		});

		verstappen.setOnMousePressed(event -> {
			selectDriver(verstappen, "Max Verstappen");
		});

		vettel.setOnMousePressed(event -> {
			selectDriver(vettel, "Sebastian Vettel");
		});

		wehrlein.setOnMousePressed(event -> {
			selectDriver(wehrlein, "Pascal Wehrlein");
		});
	}

	private void selectDriver(Pane driverButton, String driverName) {

		if (driverName != driver1String && driverName != driver2String) {

			// resetting selected buttons
			setUnSelected(driver1);
			setUnSelected(driver2);

			// switching drivers
			driver2 = driver1;
			driver2String = driver1String;

			driver1 = driverButton;
			driver1String = driverName;

			// selecting adequate buttons
			setSelected(driver1);
			setSelected(driver2);

		}

		System.out.println("#######################DRIVERS#######################");
		System.out.println("Driver1: " + driver1String + ", ID: " + driver1.getId());
		System.out.println("Driver2: " + driver2String + ", ID: " + driver2.getId());
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

	}

	public void setSelected(Pane driverButton) {
		driverButton.setStyle("-fx-background-color: rgba(0,0,0,0.26);");
	//	driverButton.setStyle("-fx-border-width: 2;");
	}

	public void setUnSelected(Pane driverButton) {
		driverButton.setStyle("-fx-background-color: rgba(0,0,0,0);");
	//	driverButton.setStyle("-fx-border-width:  0;");
		
	}

}
