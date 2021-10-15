package personal.skillenja;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OilSpill {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t>0) {
            int wasted = 0;

            int n = Integer.parseInt(br.readLine().trim());
            String[] line = br.readLine().trim().split("\\s+");
            String[] line2 = br.readLine().trim().split("\\s+");
            int toSpill = Integer.parseInt(line2[0]);

            int volI;
            int capI;
            for(int i=1;i<n;i++) {
                capI = Integer.parseInt(line[i]);
                volI = Integer.parseInt(line2[i]);
                System.out.println(i + "  " + toSpill +"  " + volI + "  " + capI + "  " + wasted);
                wasted += (toSpill + volI) > capI? toSpill+volI -capI : 0;
                volI = Math.min(capI, volI + toSpill);
                toSpill = volI;
                System.out.println(i + "  " + toSpill +"  " + volI + "  " + capI + "  " + wasted);
                System.out.println("====");
            }
            System.out.println(toSpill + " " + wasted);
            t--;
        }
    }
}
