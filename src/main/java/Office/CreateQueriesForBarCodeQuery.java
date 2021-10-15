package Office;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CreateQueriesForBarCodeQuery {

    public static void main(String[] args) throws Exception {
        String str = "db.getCollection('listing').updateMany({tuin:\"TSHO352BU8088BZX\", merchantId:\"sarfkivii8ol\"}, {$set: {\"barCodeId\":\"almajto2xbseBar\"}})";

        StringBuilder sbr = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=53;i++) {
            String[] line = br.readLine().trim().split("\\s+");
            String newStr = str.replace("TSHO352BU8088BZX", line[0]);
            newStr = newStr.replace("almajto2xbseBar", line[1]);
            sbr.append(newStr).append("\n");
        }
        System.out.println(sbr);
    }
}
