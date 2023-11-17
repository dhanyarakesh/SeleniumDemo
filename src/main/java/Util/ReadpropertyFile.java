package Util;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadpropertyFile {
	

	public static void main(String args[]) throws IOException
	{
		
	FileReader fr=new FileReader("C:\\Users\\rakes\\eclipse-workspace\\SeleniumDemo\\src\\main\\java\\config\\config.properties");

	Properties prop=new Properties();
	prop.load(fr);
		
		
	}
	
}
