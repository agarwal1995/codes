package concepts.poc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author raag
 */
public class StreamApiPerformance {

    public static void main(String[] args) {

        int n = 20000000;
        long sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++) {
            list.add(i);
        }
        long startTs = System.currentTimeMillis();
        for (int i=0;i<list.size();i++) {
            sum = sum + list.get(i);
        }
        System.out.println(System.currentTimeMillis()-startTs);


        startTs = System.currentTimeMillis();
        for (Integer x: list) {
            sum = sum+x;
        }
        System.out.println(System.currentTimeMillis()-startTs);

        startTs = System.currentTimeMillis();
        sum = list.stream().mapToInt(Integer::intValue).reduce(Integer::sum).getAsInt();
        System.out.println(System.currentTimeMillis()-startTs);

        startTs = System.currentTimeMillis();
        sum = list.parallelStream().mapToInt(Integer::intValue).reduce(Integer::sum).getAsInt();
        System.out.println(System.currentTimeMillis()-startTs);

    }
}
