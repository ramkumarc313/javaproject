package com.test;

public class FilePath {


	public String getFilePath()
	{
		String FilePath = "";
		String workingDir = System.getProperty("user.dir");
		if( (System.getProperty("os.name")).startsWith("Windows")) //WindowsFilePath
		{
			FilePath=workingDir+" ";
		}
		else  //LinuxFilePath
		{
			FilePath=workingDir+" ";
		}
		return FilePath;
	}
	
	
	

}
