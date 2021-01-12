package applaudo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppTest
{
    public Properties prop;
    public String name = "";
    public String getName = "";
    public String characters = "";

    @BeforeClass
    public void setup() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("files/properties/data.properties");
        prop.load(fis);

        name = prop.getProperty("name");
        getName = prop.getProperty("url1");
        characters = prop.getProperty("url2");

        RestAssured.baseURI = prop.getProperty("url");
        RestAssured.port = Integer.parseInt(prop.getProperty("port"));
    }

    @Test
    public void gettingInfo()
    {
        Response response = RestAssured.get(getName+name);
        String firstRes = response.jsonPath().getString("birthday");

        System.out.println("Exercise 1");
        System.out.println("Birthday date of " + name + " is: " + firstRes);
    }

    @Test
    public void gettingPOJO() throws IOException {
        Response response = RestAssured.get(characters);

        PojoCharacter[] allCharacters = response.jsonPath().getObject("",PojoCharacter[].class );

        System.out.println("Exercise 2");
        for(PojoCharacter pojo : allCharacters)
        {
            System.out.println("Character name: " + pojo.getName());
            System.out.println("Portrayed: " + pojo.getPortrayed());
            System.out.println("---------------------------------");
        }

    }

}
