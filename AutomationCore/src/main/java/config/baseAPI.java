package config;

import io.restassured.RestAssured;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class baseAPI {

    public Properties prop;
    public String name = "";
    public String getName = "";
    public String characters = "";

    @BeforeTest
    public void setup() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("../AutomationCore/files/properties/data.properties");
        prop.load(fis);

        name = prop.getProperty("name");
        getName = prop.getProperty("url1");
        characters = prop.getProperty("url2");

        RestAssured.baseURI = prop.getProperty("url0");
        RestAssured.port = Integer.parseInt(prop.getProperty("port"));
    }

}
