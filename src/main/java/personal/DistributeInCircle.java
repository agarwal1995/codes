package personal;

public class DistributeInCircle {

    public int solve(int A, int B, int C) {
        if (A>B) {
            A = A %B;
        }
        int pos = C -1 + A;
        return pos%B;
    }

    public static void main(String[] args) {
        DistributeInCircle distributeInCircle = new DistributeInCircle();
        System.out.println(distributeInCircle.solve(8,5,2));
    }
}
