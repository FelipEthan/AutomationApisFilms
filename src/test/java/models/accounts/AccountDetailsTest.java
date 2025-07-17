package models.accounts;
import baseTest.BaseTest;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.RequestUtils;

public class AccountDetailsTest extends RequestUtils {
    @BeforeClass
    public void setUp() {
        BaseTest config = new BaseTest();
        config.setUp();
    }

    @Test
    public void accountDetailsTest() {
        response = request.basePath("/22082220")
                .request(Method.GET);
        response.then().log().all().statusCode(200);
        String user = response.jsonPath().getString("username");
        System.out.println("El valor capturado en la variable username es " + user);
        Assert.assertEquals(user, "QuimbayoFelipe");
    }
}
