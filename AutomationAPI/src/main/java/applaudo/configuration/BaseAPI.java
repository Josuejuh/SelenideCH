package applaudo.configuration;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseAPI {

    public Properties prop;

    @BeforeTest
    public void setup() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("files/properties/data.properties");
        prop.load(fis);

        RestAssured.baseURI = prop.getProperty("url0");
        RestAssured.port = Integer.parseInt(prop.getProperty("port"));
    }

}
