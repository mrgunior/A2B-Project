package manager.controller;

import java.io.IOException;
import java.net.URL;

import org.omg.CORBA.PUBLIC_MEMBER;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jdk.internal.dynalink.beans.StaticClass;
import manager.model.formulaApplication;

public class SceneLoadController
{	
	public void gotoFxmlScene(MouseEvent event, String name, Stage stage) throws IOException
	{
		Parent root = FXMLLoader.load(this.getClass().getResource("../view/" + name + ".fxml"));
		
		formulaApplication.setSceneRoot(root);
		
		//stage.setFullScreen(formulaApplication.isFullscreen());
		stage.setResizable(formulaApplication.isResizable());
		stage.show();
	}
	
//	public void bindBackground(ImageView _background, AnchorPane _root)
//	{
//		_background.fitWidthProperty().bind(_root.widthProperty());
//		_background.fitHeightProperty().bind(_root.heightProperty());
//	}
}
