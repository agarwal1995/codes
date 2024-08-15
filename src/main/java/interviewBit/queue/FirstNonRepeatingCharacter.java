package interviewBit.queue;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author raag
 */
public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(new FirstNonRepeatingCharacter().solve("abc"));
        System.out.println(new FirstNonRepeatingCharacter().solve("abadbc"));
        System.out.println(new FirstNonRepeatingCharacter().solve("abcabc"));
    }

    public String solve(String A) {
        Queue<Character> queue = new LinkedList<>();
        int[] freqArray = new int[26];

        List<Character> characters = new ArrayList<>();
        for (int i=0;i<A.length();i++) {
            char ch = A.charAt(i);
            freqArray[(ch-97)] = freqArray[ch-97]+1;
            while (!queue.isEmpty() && freqArray[(queue.peek()-97)]>1) {
                queue.poll();
            }
            if (freqArray[(ch-97)]==1) {
                queue.add(ch);
            }
            if (queue.isEmpty()) {
                characters.add('#');
            } else {
                characters.add(queue.peek());
            }
        }

        StringBuilder sbr = new StringBuilder();
        for (Character ch : characters) {
            sbr.append(ch);
        }
        return sbr.toString();
    }
}
