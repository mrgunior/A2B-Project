package manager.GUIController;

import java.io.IOException;
import java.io.NotActiveException;
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
import manager.controller.SceneLoadController;
import manager.model.Car;
import manager.model.GameController;
import manager.model.Profile;
import manager.model.Upgrades;
import manager.model.formulaApplication;

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
	// Balance text
	@FXML
	private Text balance;

	private double downPriceDouble, aeroPriceDouble, gearboxPriceDouble, enginePriceDouble, suspPriceDouble, tiresPriceDouble,
			weightPriceDouble;

	private Car			car;
	private Upgrades	upgrades;
	
	private String maxMessageLong = "Max level achieved!";
	private String maxMessageShort = "-";
	private String consoleCantBuyMessage = "Not enough money or level maxed out";
	private int soundNumber;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());

		soundNumber = 1;
		
		car = Profile.getCar();
		upgrades = car.getUpgrades();

		displayUpgrades();

		// Click
		back.setOnMousePressed(event -> {
			try
			{
				gotoFxmlScene("Dashboard", (Stage) back.getScene().getWindow());
				playAudio("click.wav", 1.0);
				playAudio("carDrivingAway.wav", 1.0);

			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		});
		// Hover on
		back.setOnMouseEntered(event -> {
			back.setImage(new Image("file:images/menu/BackHover.png"));
			playAudio("hover.wav", 1.0);
		});
		// Hover off
		back.setOnMouseExited(event -> {
			back.setImage(new Image("file:images/menu/Back.png"));
		});

		downUpgrade.setOnMousePressed(event -> {
			System.out.println("Upgrade down");
			if (Profile.getBudget() > downPriceDouble && car.getUpgrades().getDown() < 5)
			{
				car.upgrade("down");
				Profile.setBudget(downPriceDouble, true);
				if (soundNumber == 1) {
					playSound(1);
					soundNumber = 2;
				} else {
					playSound(2);
					soundNumber = 1;
				}
			}
			else
			{
				System.out.println(consoleCantBuyMessage);
			}
			displayUpgrades();
		});
		
		downUpgrade.setOnMouseEntered(event -> {
			playAudio("hover.wav", 1.0);
		});

		aeroUpgrade.setOnMousePressed(event -> {
			System.out.println("Upgrade down");
			if (Profile.getBudget() > aeroPriceDouble && car.getUpgrades().getAero() < 5)
			{
				car.upgrade("aero");
				Profile.setBudget(aeroPriceDouble, true);
				if (soundNumber == 1) {
					playSound(1);
					soundNumber = 2;
				} else {
					playSound(2);
					soundNumber = 1;
				}
			}
			else
			{
				System.out.println(consoleCantBuyMessage);
			}
			displayUpgrades();
		});

		aeroUpgrade.setOnMouseEntered(event -> {
			playAudio("hover.wav", 1.0);
		});

		gearboxUpgrade.setOnMousePressed(event -> {
			if (Profile.getBudget() > gearboxPriceDouble && car.getUpgrades().getGearbox() < 5)
			{
				car.upgrade("gearbox");
				Profile.setBudget(gearboxPriceDouble, true);
				if (soundNumber == 1) {
					playSound(1);
					soundNumber = 2;
				} else {
					playSound(2);
					soundNumber = 1;
				}
			}
			else
			{
				System.out.println(consoleCantBuyMessage);
			}
			displayUpgrades();
		});
		
		gearboxUpgrade.setOnMouseEntered(event -> {
			playAudio("hover.wav", 1.0);
		});
		
		engineUpgrade.setOnMousePressed(event -> {
			if (Profile.getBudget() > enginePriceDouble && car.getUpgrades().getEngine() < 5)
			{
				car.upgrade("engine");
				Profile.setBudget(enginePriceDouble, true);
				if (soundNumber == 1) {
					playSound(1);
					soundNumber = 2;
				} else {
					playSound(2);
					soundNumber = 1;
				}
			}
			else
			{
				System.out.println(consoleCantBuyMessage);
			}
			displayUpgrades();
		});
		
		engineUpgrade.setOnMouseEntered(event -> {
			playAudio("hover.wav", 1.0);
		});

		suspUpgrade.setOnMousePressed(event -> {
			if (Profile.getBudget() > suspPriceDouble && car.getUpgrades().getSusp() < 5)
			{
				car.upgrade("susp");
				Profile.setBudget(suspPriceDouble, true);
				if (soundNumber == 1) {
					playSound(1);
					soundNumber = 2;
				} else {
					playSound(2);
					soundNumber = 1;
				}
			}
			else
			{
				System.out.println(consoleCantBuyMessage);
			}
			displayUpgrades();
		});
		
		suspUpgrade.setOnMouseEntered(event -> {
			playAudio("hover.wav", 1.0);
		});

		tiresUpgrade.setOnMousePressed(event -> {
			if (Profile.getBudget() > tiresPriceDouble && car.getUpgrades().getTires() < 5)
			{
				car.upgrade("tires");
				Profile.setBudget(tiresPriceDouble, true);
				if (soundNumber == 1) {
					playSound(1);
					soundNumber = 2;
				} else {
					playSound(2);
					soundNumber = 1;
				}
			}
			else
			{
				System.out.println(consoleCantBuyMessage);
			}
			displayUpgrades();
		});
		
		tiresUpgrade.setOnMouseEntered(event -> {
			playAudio("hover.wav", 1.0);
		});

		weightUpgrade.setOnMousePressed(event -> {
			if (Profile.getBudget() > weightPriceDouble && car.getUpgrades().getWeightRed() < 5)
			{
				car.upgrade("weightRed");
				Profile.setBudget(weightPriceDouble, true);
				if (soundNumber == 1) {
					playSound(1);
					soundNumber = 2;
				} else {
					playSound(2);
					soundNumber = 1;
				}
			}
			else
			{
				System.out.println(consoleCantBuyMessage);
			}
			displayUpgrades();
		});
		
		weightUpgrade.setOnMouseEntered(event -> {
			playAudio("hover.wav", 1.0);
		});
	}
	
	private void playSound(int i) {
		if (i == 1) {
			playAudio("pitSound1.wav", 1.0);
		} else if (i == 2) {
			playAudio("pitSound2.wav", 1.0);
		}
	}

	private void displayUpgrades()
	{
		balance.setText("$ " + Double.toString(formulaApplication.getBalance() / 1000000) + " Million");
		displayUpgrades("down");
		displayUpgrades("aero");
		displayUpgrades("gearbox");
		displayUpgrades("engine");
		displayUpgrades("susp");
		displayUpgrades("tires");
		displayUpgrades("weightRed");
		System.out.println(car);
	}

	private void displayUpgrades(String type)
	{
		// type = "engine"
		int curLvl = 0;
		switch (type)
		{
		case "aero":
			curLvl = upgrades.getAero();
			break;
		case "down":
			curLvl = upgrades.getDown();
			break;
		case "engine":
			curLvl = upgrades.getEngine();
			break;
		case "gearbox":
			curLvl = upgrades.getGearbox();
			break;
		case "susp":
			curLvl = upgrades.getSusp();
			break;
		case "tires":
			curLvl = upgrades.getTires();
			break;
		case "weightRed":
			curLvl = upgrades.getWeightRed();
			break;
		default:
			break;
		}
		int nextLvl = curLvl + 1;

		String path = "./data/upgrades.json";

		// Get the specs for the next level
		JSONObject upgradeSpecs = null;
		
		if (nextLvl <= 5)
		{
			upgradeSpecs = (JSONObject) GameController.readNestedObject(path, new String[] { "upgrades", type, "level" + nextLvl });

			// Get the price and name
			//System.out.println(nextLvl + ", " + upgradeSpecs);
			String name = upgradeSpecs.get("name").toString();
			double price = Double.parseDouble(upgradeSpecs.get("price").toString()) / 1000000;

			JSONObject positive = (JSONObject) upgradeSpecs.get("positive");
			JSONObject negative = (JSONObject) upgradeSpecs.get("negative");
			String positiveString = getChanges(positive);
			String negativeString = getChanges(negative);

			switch (type)
			{
			case "aero":
				aeroPriceDouble = Double.parseDouble(upgradeSpecs.get("price").toString());
				aeroNextUpgrade.setText(name);
				aeroNextLevel.setText("Level " + nextLvl);
				aeroPrice.setText("$ " + price + " Mill");
				aeroImprov.setText("Positive: " + positiveString + "\nNegative: " + negativeString);
				break;
			case "down":
				downPriceDouble = Double.parseDouble(upgradeSpecs.get("price").toString());
				downNextUpgrade.setText(name);
				downNextLevel.setText("Level " + nextLvl);
				downPrice.setText("$ " + price + " Mill");
				downImprov.setText("Positive: " + positiveString + "\nNegative: " + negativeString);
				break;
			case "engine":
				enginePriceDouble = Double.parseDouble(upgradeSpecs.get("price").toString());
				engineNextUpgrade.setText(name);
				engineNextLevel.setText("Level " + nextLvl);
				enginePrice.setText("$ " + price + " Mill");
				engineImprov.setText("Positive: " + positiveString + "\nNegative: " + negativeString);
				break;
			case "gearbox":
				gearboxPriceDouble = Double.parseDouble(upgradeSpecs.get("price").toString());
				gearboxNextUpgrade.setText(name);
				gearboxNextLevel.setText("Level " + nextLvl);
				gearboxPrice.setText("$ " + price + " Mill");
				gearboxImprov.setText("Positive: " + positiveString + "\nNegative: " + negativeString);
				break;
			case "susp":
				suspPriceDouble = Double.parseDouble(upgradeSpecs.get("price").toString());
				suspNextUpgrade.setText(name);
				suspNextLevel.setText("Level " + nextLvl);
				suspPrice.setText("$ " + price + " Mill");
				suspImprov.setText("Positive: " + positiveString + "\nNegative: " + negativeString);
				break;
			case "tires":
				tiresPriceDouble = Double.parseDouble(upgradeSpecs.get("price").toString());
				tiresNextUpgrade.setText(name);
				tiresNextLevel.setText("Level " + nextLvl);
				tiresPrice.setText("$ " + price + " Mill");
				tiresImprov.setText("Positive: " + positiveString + "\nNegative: " + negativeString);
				break;
			case "weightRed":
				weightPriceDouble = Double.parseDouble(upgradeSpecs.get("price").toString());
				weightNextUpgrade.setText(name);
				weightNextLevel.setText("Level " + nextLvl);
				weightPrice.setText("$ " + price + " Mill");
				weightImprov.setText("Positive: " + positiveString + "\nNegative: " + negativeString);
				break;
			default:
				break;
			}
		}
		else
		{
			switch (type)
			{
			case "aero":
				//aeroPriceDouble = Double.parseDouble(upgradeSpecs.get("price").toString());
				aeroNextUpgrade.setText(maxMessageLong);
				aeroNextLevel.setText(maxMessageShort);
				aeroPrice.setText(maxMessageShort);
				aeroImprov.setText(maxMessageLong);
				break;
			case "down":
				//downPriceDouble = Double.parseDouble(upgradeSpecs.get("price").toString());
				downNextUpgrade.setText(maxMessageLong);
				downNextLevel.setText(maxMessageShort);
				downPrice.setText(maxMessageShort);
				downImprov.setText(maxMessageLong);
				break;
			case "engine":
				//enginePriceDouble = Double.parseDouble(upgradeSpecs.get("price").toString());
				engineNextUpgrade.setText(maxMessageLong);
				engineNextLevel.setText(maxMessageShort);
				enginePrice.setText(maxMessageShort);
				engineImprov.setText(maxMessageLong);
				break;
			case "gearbox":
				//gearboxPriceDouble = Double.parseDouble(upgradeSpecs.get("price").toString());
				gearboxNextUpgrade.setText(maxMessageLong);
				gearboxNextLevel.setText(maxMessageShort);
				gearboxPrice.setText(maxMessageShort);
				gearboxImprov.setText(maxMessageLong);
				break;
			case "susp":
				//suspPriceDouble = Double.parseDouble(upgradeSpecs.get("price").toString());
				suspNextUpgrade.setText(maxMessageLong);
				suspNextLevel.setText(maxMessageShort);
				suspPrice.setText(maxMessageShort);
				suspImprov.setText(maxMessageLong);
				break;
			case "tires":
				//tiresPriceDouble = Double.parseDouble(upgradeSpecs.get("price").toString());
				tiresNextUpgrade.setText(maxMessageLong);
				tiresNextLevel.setText(maxMessageShort);
				tiresPrice.setText(maxMessageShort);
				tiresImprov.setText(maxMessageLong);
				break;
			case "weightRed":
				//weightPriceDouble = Double.parseDouble(upgradeSpecs.get("price").toString());
				weightNextUpgrade.setText(maxMessageLong);
				weightNextLevel.setText(maxMessageShort);
				weightPrice.setText(maxMessageShort);
				weightImprov.setText(maxMessageLong);
				break;
			default:
				break;
			}
		}
	}

	private String getChanges(JSONObject jsonObject)
	{
		ArrayList<String> positiveList = new ArrayList<String>();
		// System.out.println(positiveList);

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
			// System.out.println(positiveList);
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
			// System.out.println(positiveList);
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
			// System.out.println(positiveList);
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
			// System.out.println(positiveList);
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
			// System.out.println(positiveList);
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

		// System.out.println(positives);

		return positives;
	}
}
