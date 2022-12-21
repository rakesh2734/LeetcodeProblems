package exam;

import javax.xml.ws.Response;
import java.io.IOException;
import java.io.InputStream;

public class CoderByte {
    public static void main(String[] args) {
        String url = "https://coderbyte.com/api/challenges/json/age-counting";


        /*Response response = request.header("Content-Type", "application/json").when().get(url).then().extract().response();
        response.prettyPrint();
        jsonPath = response.jsonPath();

        String data = jsonPath.getString("data");
        System.out.println(data);

        String[] arr = data.split(",");
        int count = 0;
        System.out.println("***********");
        for(String ba: arr) {
            System.out.println(ba);
            String[] apple = ba.split("=");
            if(apple[0].strip() == "age" && Integer.parseInt(arr[1]) >= 50) {
                count++;
            }
        }
        System.out.println(count);*/
    }
}
