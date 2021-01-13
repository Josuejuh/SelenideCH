package applaudo;


import config.baseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.IOException;


public class ApiTest extends baseAPI {


    @Test
    public void gettingInfo()
    {
        Response response = RestAssured.get(getName+name);
        String firstRes = response.jsonPath().getString("birthday");

        System.out.println("Exercise 1");
        System.out.println("Birthday date of " + name + " is: " + firstRes);
        System.out.println(" ");
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
