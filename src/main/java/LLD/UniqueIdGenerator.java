package LLD;

/**
 * @author raag
 */
public class UniqueIdGenerator {

    private static final long EPOCH_OFFSET = 1546300800000L;


//    private static long generateUUID(int dId, int mId) {
//
//    }

    public static void main(String[] args) {
        int dataCenterId = 5;
        int machineId = 6;

//        Runnable runnable = () -> {
//            long uniqueId = generateUUID(dataCenterId, machineId);
//            System.out.println(uniqueId);
//        };

        long timestamp = System.currentTimeMillis()-EPOCH_OFFSET;
//        System.out.println(System.currentTimeMillis());
//        System.out.println(timestamp);
        long x = 1;
        String s = String.format("%64s", Long.toBinaryString(timestamp)).replace(' ', '0');
        System.out.println(s);
        x = timestamp & ((1L << 41) -1);
        s = String.format("%64s", Long.toBinaryString(x)).replace(' ', '0');
        System.out.println(s);

        x = x << 22;
        s = String.format("%64s", Long.toBinaryString(x)).replace(' ', '0');
        System.out.println(s);
    }
}
