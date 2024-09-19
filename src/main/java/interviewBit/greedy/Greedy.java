package interviewBit.greedy;

/**
 * @author raag
 */
public class Greedy {

    public static void main(String[] args) {
        new Greedy().seats("....x..xx...x..");
        new Greedy().seats("....xxx");
        new Greedy().seats(".x.x.x..x");
        new Greedy().seats("x.xx...");
    }

    public int seats(String a) {
        int mod = 10000003;
        int noOfX = 0;

        for(int i=0;i<a.length();i++) {
            if (a.charAt(i)=='x') {
                noOfX++;
            }
        }

        int medianIdx = (noOfX/2)+1;

        int median = -1;


        for (int i=0;i<a.length() && medianIdx>0;i++) {
            if (a.charAt(i)=='x') {
                medianIdx--;
                if (medianIdx==0) {
                    median=i;
                }
            }
        }

        int movement = 0;
        int lastX = median;
        for(int i=median-1;i>=0;i--) {
            if (a.charAt(i)=='x') {
                movement = (movement + ((lastX%mod)-(i%mod))-1)%mod;
                lastX = lastX-1;
            }
        }

        lastX = median;
        for(int i=median+1;i<a.length();i++) {
            if (a.charAt(i)=='x') {
                movement = (movement + (i-lastX)-1)%mod;
                lastX = lastX+1;
            }
        }

        System.out.println(movement);
        return movement;
    }
}

// .x.x.x..x

// 1,3,5,8