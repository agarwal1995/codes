package dp.fibonacci;

public class FibonacciNumbers {

    private static void printFibonacci(int n) {
        if(n>0) {
            System.out.println("0");
        }
        if(n>1) {
            System.out.println("1");
        }
        int a=0;
        int b=1;
        for(int i=1;i<=n-2;i++) {
            System.out.println(a+b+" ");
            int c = b+a;
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        printFibonacci(10);
    }
}
