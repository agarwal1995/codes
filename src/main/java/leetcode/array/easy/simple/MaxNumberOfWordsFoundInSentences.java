package leetcode.array.easy.simple;

public class MaxNumberOfWordsFoundInSentences {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(int i=0;i<sentences.length;i++) {
            String[] s = sentences[i].trim().split("\\s+");
            max = Math.max(max, s.length);
        }
        return max;
    }
}
