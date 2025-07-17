package baseTest;

import io.restassured.RestAssured;

public class BaseTest {

    public void setUp() {
        RestAssured.baseURI = "https://api.themoviedb.org/3/account";
    }

}

