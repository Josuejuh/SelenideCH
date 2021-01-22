package applaudo;


import applaudo.configuration.BaseAPI;
import applaudo.test.PojoCharacter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


public class ApiTest extends BaseAPI {

    String getName = "/characters?name=";
    String name = "Walter White";
    String characters = "/characters";

    @Test
    public void gettingInfoOneCharacter()
    {
        //Obtain the response for the API and complete path that we are hitting
        Response response = RestAssured.get(getName+name).then().statusCode(200).extract().response();
        //Get status code of the response and assertion of it
        //Assert.assertEquals(response.getStatusCode(),200,"Correct status code!");
        //Filter and obtain only the field birthday that comes on the JSON or response
        String firstRes = response.jsonPath().getString("birthday");
        //Printing values
        System.out.println("Exercise 1");
        System.out.println("Birthday date of " + name + " is: " + firstRes);
        System.out.println(" ");
    }

    @Test
    public void getAllCharacters() throws IOException {
        //Obtain the response for the API and complete path that we are hitting
        Response response = RestAssured.get(characters).then().statusCode(200).extract().response();
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
