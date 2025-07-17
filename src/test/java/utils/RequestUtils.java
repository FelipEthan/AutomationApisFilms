package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class RequestUtils {
    protected SoftAssert softAssert;
    protected RequestSpecification request;
    protected Response response;

    @BeforeMethod(alwaysRun = true)
    public void masterSetUp() {
        request = RestAssured.given().spec(buildRequestSpec());
    }
    private RequestSpecification buildRequestSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjNDViZTI2N2NmYjZjM2M2Y2NkOWY1ZDU0NjAwNGRjNSIsIm5iZiI6MTc1MDExNjQ5MS41NTgsInN1YiI6IjY4NTBhODhiODcyZGMxYjJjMzkyZGJjZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.bfpxmZCE9k0kMW7dXumUVvK7nOfg-Ng3iGRWLYuhjPY")
                .build();
    }
}
