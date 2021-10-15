package personal.skillenja;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CombinationalLogicCircuit {

    private static boolean performOperation(String op, boolean a, boolean b) {
        op = op.toLowerCase();
        switch (op) {
            case "or":
                return a | b;
            case "and":
                return a & b;
            case "xor":
                return a ^ b;
            case "nand":
                return !(a & b);
            case "nor":
                return !(a | b);
            case "xnor":
                return !(a ^ b);
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t>0) {
            int h = Integer.parseInt(br.readLine().trim());
            int n = (int)Math.pow(2, h-1);
            boolean[] array = new boolean[n];
            String[] numbers = br.readLine().trim().split("\\s+");
            for(int i=0;i<n;i++) {
                array[i] = Integer.parseInt(numbers[i]) == 1;
            }
            int last = n-1;
            int first;
            int second;
            for(int i=1;i<h;i++) {
                String[] line = br.readLine().trim().split("\\s+");
                for (int j=0;j<line.length;j++) {
                    first = j*2;
                    second = j*2+1;
                    boolean value =  performOperation(line[j], array[first], array[second]);
                    array[j] = value;
                }
            }
            System.out.println(array[0]?1:0);
            t--;
        }
    }
}
