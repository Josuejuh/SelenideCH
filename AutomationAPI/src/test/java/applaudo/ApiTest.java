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
        //Obtain the response for the API and complete path that we are hitting
        Response response = RestAssured.get(getName+name);
        //Filter and obtain only the field birthday that comes on the JSON or response
        String firstRes = response.jsonPath().getString("birthday");
        //Printing values
        System.out.println("Exercise 1");
        System.out.println("Birthday date of " + name + " is: " + firstRes);
        System.out.println(" ");
    }

    @Test
    public void gettingPOJO() throws IOException {
        //Obtain the response for the API and complete path that we are hitting
        Response response = RestAssured.get(characters);
        //Put in an array type of the POJO class the JSON that we got on the response
        PojoCharacter[] allCharacters = response.jsonPath().getObject("",PojoCharacter[].class );

        System.out.println("Exercise 2");
        //We do a loop for all the characters in the array and we print only some attributes
        for(PojoCharacter pojo : allCharacters)
        {
            System.out.println("Character name: " + pojo.getName());
            System.out.println("Portrayed: " + pojo.getPortrayed());
            System.out.println("---------------------------------");
        }

    }
}
