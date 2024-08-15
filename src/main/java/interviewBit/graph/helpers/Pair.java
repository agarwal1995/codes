package interviewBit.graph.helpers;

import lombok.Data;

@Data
public class Pair {
    public int a;
    public int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Pair() {

    }
}
