package testFilms;

import baseTest.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AccountDetailsTest {
    @Test
    public void testDetailsAccount() {
        BaseTest config = new BaseTest();
        config.setUp();
        String endpoint = "/22082220";
        Response response = given()
                .header("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjNDViZTI2N2NmYjZjM2M2Y2NkOWY1ZDU0NjAwNGRjNSIsIm5iZiI6MTc1MDExNjQ5MS41NTgsInN1YiI6IjY4NTBhODhiODcyZGMxYjJjMzkyZGJjZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.bfpxmZCE9k0kMW7dXumUVvK7nOfg-Ng3iGRWLYuhjPY")
                .header("Accept","application/json")
                .get(endpoint);
        response.then().log().all().assertThat().statusCode(200);
    }
}
