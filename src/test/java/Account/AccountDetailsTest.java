package Account;

import baseTest.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AccountDetailsTest {
    @BeforeClass
    public void setUp() {
        BaseTest config = new BaseTest();
        config.setUp();
    }
    @Test
    public void testDetailsAccount() {
        String endpoint = "/22082220";
        String authorization = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjNDViZTI2N2NmYjZjM2M2Y2NkOWY1ZDU0NjAwNGRjNSIsIm5iZiI6MTc1MDExNjQ5MS41NTgsInN1YiI6IjY4NTBhODhiODcyZGMxYjJjMzkyZGJjZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.bfpxmZCE9k0kMW7dXumUVvK7nOfg-Ng3iGRWLYuhjPY";
        Response response = given()
                .header("Authorization","Bearer "+authorization)
                .header("Content-Type","application/json")
                .get(endpoint);
        response.then().log().all().statusCode(200);
        String user = response.jsonPath().getString("username");
        System.out.println("El valor capturado en la variable username es "+ user);
        Assert.assertEquals(user, "QuimbayoFelipe");
        }
    }
