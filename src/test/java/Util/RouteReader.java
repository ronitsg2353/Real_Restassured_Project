package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RouteReader {

public static Properties Route_properties() throws IOException {
    Properties properties=new Properties();
        File file=new File(System.getProperty("user.dir")+"/src/test/resources/Route.properties");
try {
    FileInputStream fileInputStream = new FileInputStream(file);
    properties.load(fileInputStream);
}
catch (Throwable e){
e.printStackTrace();
}return properties;

}
}
