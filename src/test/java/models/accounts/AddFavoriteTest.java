package models.accounts;

import baseTest.BaseTest;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.RequestUtils;
import java.io.File;


public class AddFavoriteTest extends RequestUtils {
    @BeforeClass
    public void setUp() {
        BaseTest config = new BaseTest();
        config.setUp();
    }
    @Test
    public void addFavoriteTest() {
        String json = "src/test/resources/json/favorite.json";
        response = request.basePath("/22082220/favorite")
                .body(new File(json))
                .request(Method.POST);
        response.then().log().all().statusCode(201); //Espera que la respuesta sea un 201 created
        String success = response.jsonPath().getString("success");
        Assert.assertEquals(success, "true"); //Espera que el valor o campo success sea true
        Assert.assertEquals(success.length(),4); //Espera que el valor o campo su longitud exacta sea 4 caracteres
        Assert.assertTrue(response.getTime() < 6000);//Espera que el tiempo de respuesta no sea mayor que 2 segundos
    }
}
