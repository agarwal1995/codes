package Office;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrepareListingImageUpdateEvent {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "db.getCollection('listing').updateOne({tuin:'TLTBSALX7SYGZZ', merchantId:'husskpz6croh'}, {$set: {'additionalProperties.media_unrestricted_images':'opq'} })";
        StringBuilder sol = new StringBuilder();
        for (int i=1;i<=60;i++) {
            String[] line = br.readLine().trim().split("\\s+");
            String sbr = new String(str);
            sbr = sbr.replace("TLTBSALX7SYGZZ",line[0]);
            sbr = sbr.replace("opq", line[2]);
            sol.append(sbr).append("\n");
        }
        System.out.println(sol);
    }
}
