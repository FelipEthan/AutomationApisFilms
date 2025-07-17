package flowComplete;

import models.accounts.AccountDetailsTest;
import models.accounts.AddFavoriteTest;
import org.testng.annotations.Test;

public class flowcomplete {

    @Test
    public void escenari01() {
        AccountDetailsTest test = new AccountDetailsTest();
        test.setUp();
        test.masterSetUp(); // Llamar explícitamente si es necesario
        test.accountDetailsTest(); // Pero esto no es el flujo ideal de TestNG
    }
    @Test
    public void escenari02() {
        AddFavoriteTest test = new AddFavoriteTest();
        test.setUp();
        test.masterSetUp(); // Llamar explícitamente si es necesario
        test.addFavoriteTest(); // Pero esto no es el flujo ideal de TestNG
    }
}
