package personal.search;

public class SquareRootOfInteger {
    public int sqrt(int num) {
        if(num<=1) {
            return num;
        }
        int start =1,end = num/2;
        int mid = -1;
        while (start<=end) {
            mid = (start + end)/2;
            int mul = mid*mid;
            if (mul == num) {
                return mid;
            }
            if(mul>num) {
                end = mid-1;
            }else {
                start = mid +1;
            }
        }
        return Math.min(end, mid);
    }

    public static void main(String[] args) {
        System.out.println(new SquareRootOfInteger().sqrt(930675566));
    }
}
