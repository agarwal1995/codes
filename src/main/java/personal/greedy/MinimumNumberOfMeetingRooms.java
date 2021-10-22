package personal.greedy;

import lombok.Data;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MinimumNumberOfMeetingRooms {

    @ToString

    class Meeting {
        int val;
        char type;

        public Meeting(int val, char type) {
            this.type = type;
            this.val = val;
        }
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Meeting> meetings = new ArrayList<>();
        for(ArrayList<Integer> m : A) {
            meetings.add(new Meeting(m.get(0), 'S'));
            meetings.add(new Meeting(m.get(1), 'E'));
        }
        meetings.sort((a, b)-> {
            int val = a.val - b.val;
            if(a.val == b.val) {
                return a.type - b.type;
            } else {
                return a.val - b.val;
            }
        });
        int max = 0;
        int c = 0;
        for(Meeting n : meetings) {
            if (n.type == 'S') {
                c++;
            } else {
                c--;
            }
            max = Math.max(c, max);
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        MinimumNumberOfMeetingRooms m = new MinimumNumberOfMeetingRooms();
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=8;i++) {
            String[] line = br.readLine().trim().split("\\s+");
            ArrayList<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(line[0]));
            list.add(Integer.parseInt(line[1]));
            arrayList.add(list);
        }
        System.out.println(m.solve(arrayList));
    }
}
