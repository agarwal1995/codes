package gfg.must_do_questions.stacks_queues;

import java.util.*;

public class StreamFirstNonRepeating {

    public static void main(String[] args) {

    }

    public String FirstNonRepeating(String s) {
        Queue<Character> queue = new LinkedList<>();
        Set<Character> singleCharacter = new HashSet<>();
        StringBuilder result = new StringBuilder();
        int[] freq = new int[26];
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            freq[ch-'a'] = freq[ch-'a']+1;
            if (freq[ch-'a']==1) {
                queue.add(ch);
                singleCharacter.add(ch);
            } else {
                singleCharacter.remove(ch);
                if (freq[ch-'a']==2) {
                    Queue<Character> q2 = new LinkedList<>();
                    while (!queue.isEmpty()) {
                        if (queue.peek()!=ch) {
                            q2.add(queue.poll());
                            continue;
                        }
                        queue.poll();
                    }
                    queue = q2;
                }
            }
            if (queue.isEmpty()) {
                result.append("#");
            } else {
                result.append(queue.peek());
            }
        }
        return result.toString();
    }
}