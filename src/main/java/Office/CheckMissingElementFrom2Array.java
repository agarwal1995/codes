package Office;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class CheckMissingElementFrom2Array {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> set1 = new HashSet<>();
        for(int i=1;i<=95;i++) {
            String line = br.readLine().trim();
            set1.add(line);
        }

        System.out.println("==================");
        for(int i=1;i<=96;i++) {
            String line = br.readLine().trim();
            if (!set1.contains(line)) {
                System.out.println(line);
            }
        }

    }
}
