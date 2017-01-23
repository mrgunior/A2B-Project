package manager.GUIController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.sun.corba.se.impl.ior.GenericTaggedProfile;
import com.sun.xml.internal.ws.resources.TubelineassemblyMessages;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import manager.controller.SceneLoadController;
import manager.model.Driver;
import manager.model.GameController;
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

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());
		
		drivers = Profile.getAllDrivers(); //this is getting cleandriverss
		drivers.sort(Driver.sortById());
		
		Text[] salaries = {alonsoSalary, bottasSalary, buttonSalary, ericssonSalary, grosjeanSalary, gutierrezSalary,
				hamiltonSalary, haryantoSalary, hulkenbergSalary, kvyatSalary, magnussenSalary, massaSalary, nasrSalary,
				palmerSalary, perezSalary, raikkonnenSalary, ricciardoSalary, rosbergSalary, sainzSalary, verstappenSalary,
				vettelSalary, wehrleinSalary};

		for (int i = 0; i < 22; i++) 
		{
			salaries[i].setText("$ " + drivers.get(i).getSalary()/1000000 + " Mill/race");
		}
		
		driver1 = alonso;
		driver2 = massa;
		driver1String = "Fernando Alonso";
		driver2String = "Felipe Massa";
		setSelected(driver1);
		setSelected(driver2);

		next.setOnMousePressed(event -> {

				/*
				 * Might be a little inefficient, will adjust this.
				 */
			try {
				if (driver1 != null && driver2 != null) 
				{		
					String dataPath = "./data/drivers.json";
					
					JSONObject obj = new JSONObject();
					
					JSONObject jsonDriverObject1 = (JSONObject)GameController.readNestedObject(dataPath, new String[] { driver1.getId() });
					JSONObject jsonDriverObject2 = (JSONObject)GameController.readNestedObject(dataPath, new String[] { driver2.getId() });
					
					JSONArray driverArray1 = new JSONArray(); // create an array [], name is added later
					driverArray1.add(jsonDriverObject1); // you get this [{}]
					obj.put("Driver1", driverArray1);
					
					JSONArray driverArray2 = new JSONArray(); // create an array [], name is added later
					driverArray2.add(jsonDriverObject2); // you get this [{}]
					obj.put("Driver2", driverArray2);
										
					int d1 = Integer.parseInt(driver1.getId());
					int d2 = Integer.parseInt(driver2.getId());
								
					int backUpTeamId1 = 0;
					int backUpTeamId2 = 0;
					int teamId = Profile.getTeamID(); 
					int driverId1 = 0;
					int driverId2 = 0;
					
					for(int i = 0; i<22; i++)
					{
						if(d1 == Profile.getAllDrivers().get(i).getId())
						{
							//back it up so I can see later how to re-arrange them
							//since I know he came from this team I know which team is missing a driver
							backUpTeamId1 = Profile.getAllDrivers().get(i).getTeamId();
							//save the id of the driver so I can compare it later
							driverId1 = Profile.getAllDrivers().get(i).getId();
							
							//now set this specific driver with a new teamId 
							Profile.getDrivers().get(0).setTeamId(teamId);
							Profile.getAllDrivers().get(i).setTeamId(teamId); 
						}
						
						if(d2 == Profile.getAllDrivers().get(i).getId())
						{
							//back it up so I can see later how to re-arrange them
							backUpTeamId2 = Profile.getAllDrivers().get(i).getTeamId();
							//save the id of the driver so I can compare it later
							driverId2 = Profile.getAllDrivers().get(i).getId();
							
							//now set this specific driver with a new teamId 
							Profile.getDrivers().get(1).setTeamId(teamId); 
							Profile.getAllDrivers().get(i).setTeamId(teamId); 
						}
					}
					
					//why a second loop? one driver might have been skipped that we need
					for(int i = 0; i<22; i++)
					{
						//here 2 drivers already have a teamId that is equal to zero
						//so nothing will happen to them
						if(Profile.getAllDrivers().get(i).getTeamId()==Profile.getTeamID()&& driverId1 != Profile.getDrivers().get(0).getId())
						{
							Profile.getAllDrivers().get(i).setTeamId(backUpTeamId1);
						}
						
						if(Profile.getAllDrivers().get(i).getTeamId()==Profile.getTeamID()&& driverId2 != Profile.getDrivers().get(1).getId())
						{
							Profile.getAllDrivers().get(i).setTeamId(backUpTeamId2);
						}
					}
								
					GameController gamecontroller = formulaApplication.getGameController();

					gamecontroller.initializeDriversInProfile(obj);
					
					//update the json file
					GameController.writeJsonObjectToFile();
					GameController.writeDriversToJSON("./data/drivers.json"); 
				}				

				playAudio("click.wav", 1.0);
				gotoFxmlScene("Dashboard", (Stage) next.getScene().getWindow());
				
				//start the autosave
				GameController.autoSave(); 
			} 
			
			catch (IOException e) {
				e.printStackTrace();
			}
		});
		// Hover on
		next.setOnMouseEntered(event -> {
			next.setImage(new Image("file:images/menu/NextHover.png"));
			playAudio("hover.wav", 1.0);
		});
		// Hover off
		next.setOnMouseExited(event -> {
			next.setImage(new Image("file:images/menu/Next.png"));
		});

		// Team Choices
		alonso.setOnMousePressed(event -> {
			selectDriver(alonso, "Fernando Alonso");
			playAudio("click.wav", 1.0);
		});
		bottas.setOnMousePressed(event -> {
			selectDriver(bottas, "Valtteri Bottas");
			playAudio("click.wav", 1.0);
		});
		button.setOnMousePressed(event -> {
			selectDriver(button, "Jensen Button");
			playAudio("click.wav", 1.0);
		});
		ericsson.setOnMousePressed(event -> {
			selectDriver(ericsson, "Marcus Ericsson");
			playAudio("click.wav", 1.0);
		});
		grosjean.setOnMousePressed(event -> {
			selectDriver(grosjean, "Romain Grosjean");
			playAudio("click.wav", 1.0);
		});
		gutierrez.setOnMousePressed(event -> {
			selectDriver(gutierrez, "Esteban Gutierrez");
			playAudio("click.wav", 1.0);
		});
		hamilton.setOnMousePressed(event -> {
			selectDriver(hamilton, "Lewis Hamilton");
			playAudio("click.wav", 1.0);
		});
		haryanto.setOnMousePressed(event -> {
			selectDriver(haryanto, "Rio Haryanto");
			playAudio("click.wav", 1.0);
		});
		hulkenberg.setOnMousePressed(event -> {
			selectDriver(hulkenberg, "Nicolas Hulkenberg");
			playAudio("click.wav", 1.0);
		});
		kvyat.setOnMousePressed(event -> {
			selectDriver(kvyat, "Daniil Kvyat");
			playAudio("click.wav", 1.0);
		});
		magnussen.setOnMousePressed(event -> {
			selectDriver(magnussen, "Kevin Magnussen");
			playAudio("click.wav", 1.0);
		});
		massa.setOnMousePressed(event -> {
			selectDriver(massa, "Felipe Massa");
			playAudio("click.wav", 1.0);
		});
		nasr.setOnMousePressed(event -> {
			selectDriver(nasr, "Felipe Nasr");
			playAudio("click.wav", 1.0);
		});

		palmer.setOnMousePressed(event -> {
			selectDriver(palmer, "Jolyon Palmer");
			playAudio("click.wav", 1.0);
		});

		perez.setOnMousePressed(event -> {
			selectDriver(perez, "Sergio Perez");
			playAudio("click.wav", 1.0);
		});

		raikkonnen.setOnMousePressed(event -> {
			selectDriver(raikkonnen, "Kimi Raikkonnen");
			playAudio("click.wav", 1.0);
		});

		ricciardo.setOnMousePressed(event -> {
			selectDriver(ricciardo, "Daniel Ricciardo");
			playAudio("click.wav", 1.0);
		});

		rosberg.setOnMousePressed(event -> {
			selectDriver(rosberg, "Nico Rosberg");
			playAudio("click.wav", 1.0);
		});

		sainz.setOnMousePressed(event -> {
			selectDriver(sainz, "Carloz Sainz Jr.");
			playAudio("click.wav", 1.0);
		});

		verstappen.setOnMousePressed(event -> {
			selectDriver(verstappen, "Max Verstappen");
			playAudio("click.wav", 1.0);
		});

		vettel.setOnMousePressed(event -> {
			selectDriver(vettel, "Sebastian Vettel");
			playAudio("click.wav", 1.0);
		});

		wehrlein.setOnMousePressed(event -> {
			selectDriver(wehrlein, "Pascal Wehrlein");
			playAudio("click.wav", 1.0);
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
