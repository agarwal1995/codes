//
//public class DeadlockThread {
//
//
//
//    public static void main(String[] args) {
//        ThreadCheck t1 = new ThreadCheck();
//        ThreadCheck t2 = new ThreadCheck();
//        Thread tt1 = new Thread(t1);
//        Thread tt2 = new Thread(t2);
//
//
//    }
//}
//
//class ThreadCheck2 implements Runnable {
//
//}
//
//
//class ThreadCheck implements Runnable {
//    static String str = "A";
//
//    @Override
//    public void run() {
//        if(str.equals("A")) {
//
//        }
//        System.out.println();
//    }
//
//    public void updateString(String b) {
//        str = b;
//    }
//}
