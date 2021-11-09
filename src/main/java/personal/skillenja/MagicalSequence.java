package personal.skillenja;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MagicalSequence {

    static int getSum(int n)
    {
        int sum = 0;

        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t>0) {
            int d = Integer.parseInt(br.readLine().trim());
            String line = br.readLine().trim();
            int[] ar = new int[d];
            for(int i=0;i<d;i++) {
                ar[i] = Integer.parseInt(Character.toString(line.charAt(i)));
            }


            int[] oddSumArray = new int[d];
            int[] evenSumArray = new int[d];
            int cnum = ar[0] *2;
            if(cnum>9) {
                cnum = getSum(cnum);
            }
            evenSumArray[0] = cnum;
            oddSumArray[0] = ar[0];
            for (int i=1;i<d;i++) {
                int x = ar[i] * 2;
                if (x>9) {
                    x = getSum(x);
                }
                if(i%2==0) {
                    evenSumArray[i] = evenSumArray[i-1] + x;
                    oddSumArray[i] = oddSumArray[i-1] + ar[i];
                } else {
                    oddSumArray[i] = oddSumArray[i-1] + x;
                    evenSumArray[i] = evenSumArray[i-1] + ar[i];
                }
            }

//            System.out.println(Arrays.toString(evenSumArray));
//            System.out.println(Arrays.toString(oddSumArray));

            Map<Integer, Integer> evenMap = new HashMap<>();
            int evenTotalCount = 0;
            for(int i =0;i<d;i++) {
                int num = evenSumArray[i]%10;
//                System.out.println(num);
                if(evenMap.containsKey(num)) {
                    if(i%2!=0)
                    evenTotalCount = evenTotalCount + evenMap.get(num);
                    evenMap.put(num, evenMap.get(num) + 1);
                } else {
                    evenMap.put(num, 1);
                }
                if(num==0) {
                    evenTotalCount++;
                }
            }
//            System.out.println(evenTotalCount);


            Map<Integer, Integer> oddMap = new HashMap<>();
            int oddTotalCount = 0;
            for(int i =0;i<d;i++) {
                int num = oddSumArray[i]%10;
//                System.out.println(num);
                if(oddMap.containsKey(num)) {
                    if(i%2==0)
                    oddTotalCount = oddTotalCount + oddMap.get(num);
                    oddMap.put(num, oddMap.get(num) + 1);
                } else {
                    if(num==0) {
                        oddTotalCount++;
                    }
                    oddMap.put(num, 1);
                }
            }
//            System.out.println(oddTotalCount);

            System.out.println(oddTotalCount+evenTotalCount);



            t--;
        }
    }
}
