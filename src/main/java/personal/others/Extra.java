package personal.others;

public class Extra {
    public static void main(String[] args) {
        Extra obj = new Extra(n);
    }
    static int a = 10;
    static int n;
    int b = 5;
    int c;
    public Extra(int m) {
        System.out.println(a + ", " + b + ", " + c + ", " + n + ", " + m);
    }
    // Instance Block
    {
        b = 30;
        n = 20;
    }
    // Static Block
    static
    {
        a = 60;
    }
}