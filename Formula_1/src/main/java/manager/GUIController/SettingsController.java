package main.java.manager.GUIController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.manager.controller.SceneLoadController;
import main.java.manager.model.GameController;
import main.java.manager.model.Profile;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SettingsController extends SceneLoadController implements Initializable {
	// Background
	@FXML
	private AnchorPane root;
	@FXML
	private ImageView background;
	@FXML
	private Button reset, mute;

	@FXML
	private Slider slider, effectsSlider;
	// Scene elements
	@FXML
	private ImageView back;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		background.fitWidthProperty().bind(root.widthProperty());
		background.fitHeightProperty().bind(root.heightProperty());

		AnimationTimer animationTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				back.setOnMousePressed(event -> {
					try {
						gotoFxmlScene("MainMenu", (Stage) back.getScene().getWindow());
						playAudio("click.wav", 1.0);
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				back.setOnMouseEntered(event -> {
					back.setImage(new Image("file:images/menu/BackHover.png"));
					playAudio("hover.wav", 1.0);
				});
				back.setOnMouseExited(event -> {
					back.setImage(new Image("file:images/menu/Back.png"));
				});

				reset.setOnMousePressed(event -> {
					GameController.getProfile().resetProfile();
					playAudio("click.wav", 1.0);
				});

				reset.setOnMouseEntered(event -> {
					playAudio("hover.wav", 1.0);
				});

				mute.setOnMousePressed(event -> {
					if (main.java.manager.controller.SceneLoadController.isMuted) {
						main.java.manager.controller.SceneLoadController.isMuted = false;
						startMaintheme();
					} else {
						main.java.manager.controller.SceneLoadController.isMuted = true;
						stopMainTheme();
					}
					playAudio("click.wav", 1.0);
				});

				mute.setOnMouseEntered(event -> {
					playAudio("hover.wav", 1.0);
				});

				slider.valueProperty().addListener(new ChangeListener() {

					@Override
					public void changed(ObservableValue arg0, Object arg1, Object arg2) {
						main.java.manager.controller.SceneLoadController.volume = (slider.getValue()/100);
						System.out.println(main.java.manager.controller.SceneLoadController.volume);
						mainthemePlayer.setVolume(main.java.manager.controller.SceneLoadController.volume);
					}
				});
				
				effectsSlider.valueProperty().addListener(new ChangeListener() {

					@Override
					public void changed(ObservableValue arg0, Object arg1, Object arg2) {
						main.java.manager.controller.SceneLoadController.effectsVolume = (effectsSlider.getValue()/100);
						System.out.println(main.java.manager.controller.SceneLoadController.effectsVolume);
					}
				});


			}
		};

		animationTimer.start();
	}
}
