import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    String fileName = "./src/test/resources/customer.json";
    public String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String password;

    public void jsonData(String email, String password) throws IOException, ParseException {


        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONObject customerObj = new JSONObject();

        customerObj.put("email", email);
        customerObj.put("password", password);

        JSONArray jsonArray = (JSONArray) obj;
        jsonArray.add(customerObj);

        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }

    public void readData(int pos) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj=jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject customerObj = (JSONObject) jsonArray.get(pos);

        String email = (String) customerObj.get("email");
        String password = (String) customerObj.get("password");

        setEmail(email);
        setPassword(password);
    }
    public int getLastUser() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj=jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        return jsonArray.size();
    }

}
