package manager.controller;

import javafx.scene.Parent;

public class SceneFile 
{
	private String name;
	private Parent root;
	
	public SceneFile(String name, Parent root)
	{
		this.name = name;
		this.root = root;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public Parent getRoot() 
	{
		return root;
	}

	public void setRoot(Parent root) 
	{
		this.root = root;
	}
	
	public String toString()
	{
		return name;
	}
}
