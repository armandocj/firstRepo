package WebUI;

import framework.BaseTest;
import framework.util.DataHandler;
import framework.util.Log;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TestGuru extends BaseTest {

    private Log LOG;

    @BeforeMethod
    private void setup(){
        LOG = new Log(this.getClass().getName());
        super.LOG = LOG;
        setupDriver();
    }

    @Test
    public void detectingObjects() throws FileNotFoundException, JSONException {
        DataHandler dataHandler = new DataHandler("TC1");
        String url=dataHandler.getValue("URL");
        Assert.assertTrue(url.contains("99"),"URL not valid");
        driver.get(url);
    }

    @Test
    public void sample2() throws FileNotFoundException, JSONException {
        DataHandler dataHandler = new DataHandler("TC1");
        String url=dataHandler.getValue("URL");
        Assert.assertTrue(url.contains("99"),"URL not valid");
        driver.get(url);
    }

    @AfterMethod
    private void teardown(){
        driver.quit();
    }
}
