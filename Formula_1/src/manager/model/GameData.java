package manager.model;

public class GameData
{
	// Static setting variables
	static boolean fullscreen = true;
	static boolean resizable = true;
	static private String teamName = "";
	
	// Fullscreen getters/setters
	public static boolean isFullscreen()
	{
		return fullscreen;
	}
	public static void setFullscreen(boolean fullscreenSetting)
	{
		fullscreen = fullscreenSetting;
	}
	
	// Resizable getters
	public static boolean isResizable()
	{
		return resizable;
	}
	public static void setResizable(boolean resizableSetting)
	{
		resizable = resizableSetting;
	}
	
	// Testing methods
	public static String getTeamName()
	{
		return teamName;
	}
	public static void setTeamName(String name)
	{
		teamName = name;
	}
	public static int getBalance()
	{
		return 5123456;
	}
	
	
}
