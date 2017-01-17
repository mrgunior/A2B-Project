package manager.controller;

import java.util.ArrayList;

public class SceneCatalog 
{
	private ArrayList<SceneFile> sceneFiles;
	
	public SceneCatalog()
	{
		sceneFiles = new ArrayList<SceneFile>();
	}
	
	public SceneFile getScene(String name)
	{
		for (int i = 0; i < sceneFiles.size(); i++)
		{
			if (sceneFiles.get(i).getName().equals(name))
			{
				return sceneFiles.get(i);
			}
		}
		
		return null;
	}
	
	public void addSceneFile(SceneFile sceneFile)
	{
		boolean existsInCatalog = false;
		
		for (int i = 0; i < sceneFiles.size(); i++)
		{
			if (sceneFiles.get(i).getName().equals(sceneFile.getName()))
			{
				existsInCatalog = true;
			}
		}
		
		if (!existsInCatalog)
		{
			sceneFiles.add(sceneFile);
		}
	}
	
	public String toString()
	{
		return sceneFiles.toString();
	}
}
