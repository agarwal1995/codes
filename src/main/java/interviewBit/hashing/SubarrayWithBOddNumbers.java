package interviewBit.hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author raag
 */
public class SubarrayWithBOddNumbers {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        ArrayList<Integer> list = Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(new SubarrayWithBOddNumbers().solve(list, 2));
    }

    public int solve(ArrayList<Integer> A, int B) {

        return 0;
    }
}
