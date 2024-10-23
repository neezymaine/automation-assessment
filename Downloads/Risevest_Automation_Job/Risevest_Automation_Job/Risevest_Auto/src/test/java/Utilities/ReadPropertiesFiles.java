package Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ReadPropertiesFiles {

public static void main(String[] args) throws IOException {

FileReader fr=new FileReader("C:\\Users\\HP\\OneDrive\\Desktop\\Risevest_Automation_Job\\Risevest_Auto\\src\\test\\resources\\Configfiles");

Properties p=new Properties();
p.load(fr);

System.out.println(p.getProperty("browser"));
System.out.println(p.getProperty("testurl"));
}
}

