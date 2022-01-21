package utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
//Create a object for class properties 
 static Properties prop = new Properties();
 //defining the project path
 static String projectPath = System.getProperty("user.dir");


public static String getProps(String name) {
try {
//create a object for class InputStream
   InputStream input = new FileInputStream(projectPath + "/src/test/config/Configuration.properties");
   //Load properties file
   prop.load(input);
   //get values from properties file
   String property = prop.getProperty(name);
   return property;
} catch (Exception exp) {
System.out.println(exp.getMessage());
   System.out.println(exp.getCause());
   exp.printStackTrace();
   return "";
}
}

public static String getEmailId(){
    return getProps("emailid");
}

public static String getPassword(){
    return getProps("password");
}

public static String getProductName(){
    return getProps("productname");
}


public static void setProps(String name, String value) {
try {
//create a object for class OuputStream
   OutputStream output = new FileOutputStream(projectPath + "/src/test/config/Configuration.properties");
   //Load properties file and set firefox
   prop.setProperty(name, value);
   //store values i properties file
   prop.store(output, "setting " + value);
} catch (Exception exp) {
System.out.println(exp.getMessage());
   System.out.println(exp.getCause());
   exp.printStackTrace();
  }
}
}

