package framework.util;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataHandler {

    private JSONObject scenarioData;
    private static final String dataFile = "./testData/testdata.json";

    public DataHandler(String scenarioName) throws FileNotFoundException, JSONException {
        loadData(scenarioName);
    }

    private void loadData(String scenario) throws FileNotFoundException, JSONException {
        JSONObject allData = new JSONObject(new JSONTokener(new FileReader(dataFile)));
        if(allData.has(scenario)){
            scenarioData = allData.getJSONObject(scenario);
        }
    }

    public String getValue(String key) throws JSONException {
        if(scenarioData != null){
            if(scenarioData.has(key)){
                return scenarioData.getString(key);
            }
        }
        return "";
    }
}
