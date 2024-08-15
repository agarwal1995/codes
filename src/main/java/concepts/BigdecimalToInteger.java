package concepts;

import java.math.BigDecimal;

/**
 * @author raag
 */
public class BigdecimalToInteger {


    public static void main(String[] args) {
        BigDecimal bigDecimal1 = BigDecimal.valueOf(12345678192834L);
        BigDecimal bigDecimal2 = BigDecimal.valueOf(12345643192834L);
        BigDecimal bigDecimal3 = BigDecimal.valueOf(12345623192834L);
        BigDecimal bigDecimal4 = BigDecimal.valueOf(123424378192834L);
        BigDecimal bigDecimal5 = BigDecimal.valueOf(1234542348192834L);

        System.out.println(bigDecimal1.toBigInteger().intValue());
        System.out.println(bigDecimal1.toBigInteger().intValue());
        System.out.println(bigDecimal1.toBigInteger().intValue());
        System.out.println(bigDecimal1.toBigInteger().intValue());
        System.out.println(bigDecimal1.toBigInteger().intValue());
        System.out.println(bigDecimal2.toBigInteger().intValue());
        System.out.println(bigDecimal2.toBigInteger().intValue());
        System.out.println(bigDecimal2.toBigInteger().intValue());
        System.out.println(bigDecimal2.toBigInteger().intValue());
        System.out.println(bigDecimal2.toBigInteger().intValue());
        System.out.println(bigDecimal3.toBigInteger().intValue());
        System.out.println(bigDecimal3.toBigInteger().intValue());
        System.out.println(bigDecimal3.toBigInteger().intValue());
        System.out.println(bigDecimal3.toBigInteger().intValue());
        System.out.println(bigDecimal3.toBigInteger().intValue());
        System.out.println(bigDecimal4.toBigInteger().intValue());
        System.out.println(bigDecimal4.toBigInteger().intValue());
        System.out.println(bigDecimal4.toBigInteger().intValue());
        System.out.println(bigDecimal4.toBigInteger().intValue());
        System.out.println(bigDecimal4.toBigInteger().intValue());
        System.out.println(bigDecimal5.toBigInteger().intValue());
        System.out.println(bigDecimal5.toBigInteger().intValue());
        System.out.println(bigDecimal5.toBigInteger().intValue());
        System.out.println(bigDecimal5.toBigInteger().intValue());
        System.out.println(bigDecimal5.toBigInteger().intValue());
    }
}
