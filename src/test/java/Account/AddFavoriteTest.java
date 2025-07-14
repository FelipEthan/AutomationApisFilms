package Account;

import baseTest.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class AddFavoriteTest {
    @BeforeClass
    public void setUp() {
        BaseTest config = new BaseTest();
        config.setUp();
    }
    @Test
    public void addFavorite() throws IOException {
        String endpoint = "/22082220/favorite";
        String jsonTemplate = new String(Files.readAllBytes(Paths.get("src/test/resources/json/favorite.json")));
        String authorization = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjNDViZTI2N2NmYjZjM2M2Y2NkOWY1ZDU0NjAwNGRjNSIsIm5iZiI6MTc1MDExNjQ5MS41NTgsInN1YiI6IjY4NTBhODhiODcyZGMxYjJjMzkyZGJjZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.bfpxmZCE9k0kMW7dXumUVvK7nOfg-Ng3iGRWLYuhjPY";
        Response response = given()
                .header("Authorization","Bearer "+authorization)
                .header("Content-Type","application/json")
                .body(jsonTemplate)
                .post(endpoint);
        response.then().log().all().statusCode(201);
        String success = response.jsonPath().getString("success");
        System.out.println(success);
        Assert.assertEquals(success, "true");
    }
}
