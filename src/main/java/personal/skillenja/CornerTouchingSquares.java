package personal.skillenja;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CornerTouchingSquares {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t>0) {
            String[] line = br.readLine().trim().split("\\s+");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);
            int d = Integer.parseInt(line[3]);

            System.out.println();
            int e = Math.max(a,b);
            int maxAD = Math.max(a,d);
            int maxBC = Math.max(b,c);
            for(int i=0;i<=e;i++) {
                boolean bigA = a>=b;
                for(int k=0;k<d-a;k++) {
                    if(i==e)
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }
                for(int j=0;j<=a;j++) {
                    if(j==a || i==e || (bigA && (i==0 || j==0)) || (!bigA && ((j==0 && i>=b-a) || (i==e-a) ) ))
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }
                for(int j=0;j<b;j++) {
                    if( (bigA && (i==(a-b) || i==e || (j==b-1 && i>(a-b))))
                    || (!bigA && (i==e || (i==0) || (j==b-1) ) ))
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }
                for(int k=0;k<c-b;k++) {
                    if(i==e)
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }

                System.out.println();
            }

            int f = Math.max(c, d);
            for(int i=1;i <=f; i++) {
                boolean bigD = c<d;
                for(int j=0;j<=maxAD;j++) {
                    if(j==maxAD || (j==maxAD-d && i<=d) || (i==d && j>maxAD-d))
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }

                for(int j=1;j<=maxBC;j++) {
                    if((i==c && j<=c) || (j==c && i<=c))
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }

//                for (int j=0;j<c;j++) {
//                    if()
//                        System.out.println("  ");
//                    else
//                        System.out.println("  ");
//                }

                System.out.println();
            }
            t--;
        }
    }
}
