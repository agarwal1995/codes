package Office;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class CheckForDuplicates {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> strings = new HashSet<>();
        for(int i=1;i<=96;i++) {
            String line = br.readLine().trim();
            if ( strings.contains(line)) {
                System.out.println(line);
                continue;
            }
            strings.add(line);
        }
    }
}
