package personal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FirstRepeatingElement {

    static class Info {
        private int firstIndex;
        private int count;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Info)) return false;
            Info info = (Info) o;
            return firstIndex == info.firstIndex && count == info.count;
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstIndex, count);
        }

        public Info(int firstIndex) {
            this.firstIndex = firstIndex;
            this.count = 0;
        }

        public int getFirstIndex() {
            return firstIndex;
        }

        public void setFirstIndex(int firstIndex) {
            this.firstIndex = firstIndex;
        }

        public int getCount() {
            return count;
        }

        public void setCount() {
            this.count +=1;
        }
    }



    public static int solve(ArrayList<Integer> A) {
        Map<Integer, Info> map = new HashMap<>();

        int i=0;
        for(int x:A) {
            map.putIfAbsent(x, new Info(i));
            map.get(x).setCount();
            i++;
        }


        int smallestIndex = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Info> entry:map.entrySet()) {
            if (entry.getValue().getCount() >1) {
                smallestIndex = Math.min(smallestIndex, entry.getValue().getFirstIndex());
            }
        }
        if(smallestIndex == Integer.MAX_VALUE) {
            return -1;
        }

        return A.get(smallestIndex);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        int n = line.length;

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i =0;i<n;i++) {
            arr.add(Integer.parseInt(line[i]));
        }
        System.out.println(solve(arr));
    }
}
