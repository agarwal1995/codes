package Office;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class EddyCheckForDuplicates {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> eddyExistingTuinsToMerchantSkusMap = new HashMap<>();
        Map<String, String> eddyExistingSkusToTuinsMap = new HashMap<>();

        for(int i=1;i<=2733;i++) {
            String[] line = br.readLine().trim().split(" ");
            eddyExistingTuinsToMerchantSkusMap.put(line[0].trim(), line[1].trim());
            eddyExistingSkusToTuinsMap.put(line[1].trim(), line[0].trim());
        }

        Map<String, String> eddyNwTuinsToMerchantSkusMap = new HashMap<>();
        Map<String, String> eddyNwSkusToTuinsMap = new HashMap<>();
        for(int i=1;i<=2482;i++) {
            String[] line = br.readLine().trim().split("\\s+");
            eddyNwTuinsToMerchantSkusMap.put(line[0].trim(), line[1].trim());
            eddyNwSkusToTuinsMap.put(line[1].trim(), line[0].trim());
        }

        int countContainsExisting = 0;
        for(Map.Entry<String, String> newMap : eddyNwSkusToTuinsMap.entrySet()) {
            if (eddyExistingSkusToTuinsMap.containsKey(newMap.getKey())) {
                countContainsExisting++;
                if(!eddyExistingSkusToTuinsMap.get(newMap.getKey()).equals(newMap.getValue())) {
                    System.out.println(newMap.getKey());
                }
            }
        }

        System.out.println(countContainsExisting);
    }
}
