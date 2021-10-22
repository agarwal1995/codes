package personal.greedy;

import java.util.Arrays;

public class CatchThieves {

    static int catchThieves(char arr[], int n, int k) {
        int[] count = new int[arr.length];
        int availablePolice = 0;
        for(int i=0;i<n;i++) {
            if(arr[i]=='P') {
                availablePolice++;
                if (i-k>=0) {
                    count[i-k]+=1;
                } else {
                    count[0]=1;
                }
                if(i+k+1<n) {
                    count[i+k+1]-=1;
                }
            }
        }
        for(int i=1;i<n;i++) {
            count[i] = count[i-1] +count[i];
        }

        int catchThieve = 0;
        for (int i=0;i<n;i++) {
            if(arr[i]=='T' && availablePolice>0 && count[i]>0) {
                catchThieve++;
                availablePolice--;
            }
        }

        System.out.println(Arrays.toString(count));
        return catchThieve;
    }

    public static void main(String[] args) {
        char arr[] = {'P', 'T', 'T', 'P', 'T'};
        System.out.println(catchThieves(arr, 5, 1));

    }
}
