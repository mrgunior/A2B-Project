package manager.GUIController;

import java.io.IOException;
import java.net.URL;
import java.security.KeyStore.PrivateKeyEntry;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.json.simple.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import manager.controller.GameController;
import manager.controller.SceneLoadController;
import manager.model.Car;
import manager.model.Profile;
import manager.model.Upgrades;

public class CarManagementController extends SceneLoadController implements Initializable
{
	// Background
	@FXML
	private AnchorPane	root;
	@FXML
	private ImageView	background;

	// Scene elements
	@FXML
	private ImageView back;

	// Upgrade Names Text
	@FXML
	private Text downNextUpgrade, aeroNextUpgrade, gearboxNextUpgrade, engineNextUpgrade, suspNextUpgrade, tiresNextUpgrade,
			weightNextUpgrade;
	// Next Level Text
	@FXML
	private Text downNextLevel, aeroNextLevel, gearboxNextLevel, engineNextLevel, suspNextLevel, tiresNextLevel, weightNextLevel;
	// Improvements Text
	@FXML
	private Text downImprov, aeroImprov, gearboxImprov, engineImprov, suspImprov, tiresImprov, weightImprov;
	// Price Text
	@FXML
	private Text downPrice, aeroPrice, gearboxPrice, enginePrice, suspPrice, tiresPrice, weightPrice;
	// Upgrade buttons
	@FXML
	private ImageView downUpgrade, aeroUpgrade, gearboxUpgrade, engineUpgrade, suspUpgrade, tiresUpgrade, weightUpgrade;

	private Car			car;
	private Upgrades	upgrades;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());

		car = Profile.getCar();
		upgrades = car.getUpgrades();

		displayUpgrades("down");
		displayUpgrades("aero");
		displayUpgrades("gearbox");
		displayUpgrades("engine");
		displayUpgrades("susp");
		displayUpgrades("tires");
		displayUpgrades("weightRed");

		// Click
		back.setOnMousePressed(event -> {
			try
			{
				gotoFxmlScene(event, "Dashboard", (Stage) back.getScene().getWindow());
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		});
		// Hover on
		back.setOnMouseEntered(event -> {
			back.setImage(new Image("file:images/menu/BackHover.png"));
		});
		// Hover off
		back.setOnMouseExited(event -> {
			back.setImage(new Image("file:images/menu/Back.png"));
		});
	}

	private void displayEngineUpgrades()
	{
		// System.out.println("=== displayEngineUpgrades() Start\n");

		int engineNextLvl = upgrades.getEngine() + 1;
		String path = "./data/upgrades.json";

		// Get the specs for the next level
		JSONObject engineUpgradeSpecs = (JSONObject) GameController.readNestedObject(path,
				new String[] { "upgrades", "engine", "level" + engineNextLvl });

		// Get the price and name
		String name = engineUpgradeSpecs.get("name").toString();
		double price = Double.parseDouble(engineUpgradeSpecs.get("price").toString()) / 1000000;

		JSONObject positive = (JSONObject) engineUpgradeSpecs.get("positive");
		JSONObject negative = (JSONObject) engineUpgradeSpecs.get("negative");
		String positiveString = getChanges(positive);
		String negativeString = getChanges(negative);

		// Set text
		engineNextUpgrade.setText(name);
		engineNextLevel.setText("Level " + engineNextLvl);
		enginePrice.setText("$ " + price + " Mill");
		engineImprov.setText("Positive: " + positiveString + "\nNegative: " + negativeString);

		// System.out.println("\n=== displayEngineUpgrades() End");
	}

	private void displayUpgrades(String type)
	{
		// type = "engine"
		int nextLvl = 0;
		switch (type)
		{
		case "aero":
			nextLvl = upgrades.getAero();
			break;
		case "down":
			nextLvl = upgrades.getDown();
			break;
		case "engine":
			nextLvl = upgrades.getEngine();
			break;
		case "gearbox":
			nextLvl = upgrades.getGearbox();
			break;
		case "susp":
			nextLvl = upgrades.getSusp();
			break;
		case "tires":
			nextLvl = upgrades.getTires();
			break;
		case "weightRed":
			nextLvl = upgrades.getWeightRed();
			break;
		default:
			break;
		}
		String path = "./data/upgrades.json";

		// Get the specs for the next level
		JSONObject upgradeSpecs = (JSONObject) GameController.readNestedObject(path,
				new String[] { "upgrades", type, "level" + nextLvl });

		// Get the price and name
		String name = upgradeSpecs.get("name").toString();
		double price = Double.parseDouble(upgradeSpecs.get("price").toString()) / 1000000;

		JSONObject positive = (JSONObject) upgradeSpecs.get("positive");
		JSONObject negative = (JSONObject) upgradeSpecs.get("negative");
		String positiveString = getChanges(positive);
		String negativeString = getChanges(negative);
		
		switch (type)
		{
		case "aero":
			aeroNextUpgrade.setText(name);
			aeroNextLevel.setText("Level " + nextLvl);
			aeroPrice.setText("$ " + price + " Mill");
			aeroImprov.setText("Positive: " + positiveString + "\nNegative: " + negativeString);
			break;
		case "down":
			downNextUpgrade.setText(name);
			downNextLevel.setText("Level " + nextLvl);
			downPrice.setText("$ " + price + " Mill");
			downImprov.setText("Positive: " + positiveString + "\nNegative: " + negativeString);
			break;
		case "engine":
			engineNextUpgrade.setText(name);
			engineNextLevel.setText("Level " + nextLvl);
			enginePrice.setText("$ " + price + " Mill");
			engineImprov.setText("Positive: " + positiveString + "\nNegative: " + negativeString);
			break;
		case "gearbox":
			gearboxNextUpgrade.setText(name);
			gearboxNextLevel.setText("Level " + nextLvl);
			gearboxPrice.setText("$ " + price + " Mill");
			gearboxImprov.setText("Positive: " + positiveString + "\nNegative: " + negativeString);
			break;
		case "susp":
			suspNextUpgrade.setText(name);
			suspNextLevel.setText("Level " + nextLvl);
			suspPrice.setText("$ " + price + " Mill");
			suspImprov.setText("Positive: " + positiveString + "\nNegative: " + negativeString);
			break;
		case "tires":
			tiresNextUpgrade.setText(name);
			tiresNextLevel.setText("Level " + nextLvl);
			tiresPrice.setText("$ " + price + " Mill");
			tiresImprov.setText("Positive: " + positiveString + "\nNegative: " + negativeString);
			break;
		case "weightRed":
			weightNextUpgrade.setText(name);
			weightNextLevel.setText("Level " + nextLvl);
			weightPrice.setText("$ " + price + " Mill");
			weightImprov.setText("Positive: " + positiveString + "\nNegative: " + negativeString);
			break;
		default:
			break;
		}

	}

	private String getChanges(JSONObject jsonObject)
	{
		ArrayList<String> positiveList = new ArrayList<String>();
		//System.out.println(positiveList);

		if (jsonObject.containsKey("speed"))
		{
			String tempString = "";

			tempString += "Speed ";

			if (Integer.parseInt(jsonObject.get("speed").toString()) > 0)
			{
				tempString += "+";
			}

			tempString += jsonObject.get("speed").toString();

			positiveList.add(tempString);
			//System.out.println(positiveList);
		}

		if (jsonObject.containsKey("acceleration"))
		{
			String tempString = "";

			tempString += "Acceleration ";

			if (Integer.parseInt(jsonObject.get("acceleration").toString()) > 0)
			{
				tempString += "+";
			}

			tempString += jsonObject.get("acceleration").toString();

			positiveList.add(tempString);
			//System.out.println(positiveList);
		}

		if (jsonObject.containsKey("handling"))
		{
			String tempString = "";

			tempString += "Handling ";

			if (Integer.parseInt(jsonObject.get("handling").toString()) > 0)
			{
				tempString += "+";
			}

			tempString += jsonObject.get("handling").toString();

			positiveList.add(tempString);
			//System.out.println(positiveList);
		}

		if (jsonObject.containsKey("braking"))
		{
			String tempString = "";

			tempString += "Braking ";

			if (Integer.parseInt(jsonObject.get("braking").toString()) > 0)
			{
				tempString += "+";
			}

			tempString += jsonObject.get("braking").toString();

			positiveList.add(tempString);
			//System.out.println(positiveList);
		}

		if (jsonObject.containsKey("weight"))
		{
			String tempString = "";

			tempString += "Weight ";

			if (Integer.parseInt(jsonObject.get("weight").toString()) > 0)
			{
				tempString += "+";
			}

			tempString += jsonObject.get("weight").toString();

			positiveList.add(tempString);
			//System.out.println(positiveList);
		}

		String positives = "";

		if (positiveList.size() > 0)
		{
			for (int i = 0; i < positiveList.size() - 1; i++)
			{

				positives += (positiveList.get(i) + ", ");
			}
			positives += positiveList.get(positiveList.size() - 1);
		}
		else
		{
			positives = "none";
		}
		
		//System.out.println(positives);

		return positives;
	}
}
