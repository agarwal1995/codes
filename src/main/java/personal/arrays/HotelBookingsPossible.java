package personal.arrays;

import java.util.ArrayList;
import java.util.Comparator;

public class HotelBookingsPossible {

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

        arrive.sort(Comparator.naturalOrder());
        depart.sort(Comparator.naturalOrder());
        int i = 0;
        int j = 0;
        int max = 0;
        int cur = 0;
        int n = arrive.size();
        while (i<n && j<n) {
            if (arrive.get(i).compareTo(depart.get(j)) < 0) {
                cur++;
                i++;
            } else {
                cur--;
                j++;
            }
            max = Math.max(cur, max);
        }
        return K == max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrive = new ArrayList<>();
        arrive.add(1);
        arrive.add(2);
        arrive.add(3);

        ArrayList<Integer> depart = new ArrayList<>();
        depart.add(4);
        depart.add(2);
        depart.add(3);

        System.out.println(new HotelBookingsPossible().hotel(arrive, depart, 1));
    }
}
