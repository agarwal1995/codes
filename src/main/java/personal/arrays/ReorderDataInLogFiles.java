package personal.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReorderDataInLogFiles {

    public ArrayList<String> reorderLogs(ArrayList<String> list) {
        List<String[]> listOfArray = new ArrayList<>();
        list.stream().forEach(l -> {
            listOfArray.add(l.split("-"));
        });
        list.sort((o1, o2) -> {
                    int o1Size = o1.length() - 1;
                    int o2Size = o2.length() - 1;
                    boolean digit1 = o1.charAt(o1Size) >= '0' && o1.charAt(o1Size) <= '9';
                    boolean digit2 = o2.charAt(o2Size) >= '0' && o2.charAt(o2Size) <= '9';
                    if (digit1 != digit2) {
                        if (o1.charAt(o1Size) < o2.charAt(o2Size)) {
                            return 1;
                        }
                        return -1;
                    } else {
                        if(digit1) {
                            return 0;
                        }
                        int i = 1, j = 1;
                        String[] array1 = o1.split("-");
                        String[] array2 = o2.split("-");
                        while (i <= o1Size && j <= o2Size) {
                            int x = array1[i].compareTo(array2[j]);
                            if (x != 0) {
                                return x;
                            }
                            i++;
                            j++;
                        }
                        if (i > o1Size) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                });
            return list;
        }

        public static void main (String[]args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] line = br.readLine().trim().split("\\s+");
            ArrayList<String> list = new ArrayList<>();
            for (String s : line) {
                list.add(s);
            }

            System.out.println(new ReorderDataInLogFiles().reorderLogs(list));

        }
    }
