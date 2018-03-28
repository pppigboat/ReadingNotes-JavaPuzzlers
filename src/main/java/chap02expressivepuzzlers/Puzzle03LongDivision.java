package chap02expressivepuzzlers;

/**
 * 使用long时，注意要确保第一个操作数是long型，这样就可以避免溢出
 *
 * @author SpringZ
 * @version 1.0.0  2018-03-28.
 */
public class Puzzle03LongDivision {
    public static void main(String[] args) {
        divisionInTheWrongWay();
        divisionInTheWrongWay2();
        divisionInTheRightWay();
    }

    private static void divisionInTheWrongWay() {
        final long MICROS_PER_DAY = 1000 * 1000 * 60 * 60 * 24; //溢出了
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println(MICROS_PER_DAY);
        System.out.println(MILLIS_PER_DAY);
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
    }

    /**
     * java的*结合率是从左到右，因此在1000*1000*60*60的时候就已经溢出了
     */
    private static void divisionInTheWrongWay2() {
        final long MICROS_PER_DAY = 1000 * 1000 * 60 * 60 * 24L; //仍然溢出
        final long MILLIS_PER_DAY = 1000 * 60 * 60 * 24;
        System.out.println(MICROS_PER_DAY);
        System.out.println(MILLIS_PER_DAY);
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
    }

    private static void divisionInTheRightWay() {
        final long MICROS_PER_DAY = 1000L * 1000 * 60 * 60 * 24;
        final long MILLIS_PER_DAY = 1000 * 60 * 60 * 24;
        System.out.println(MICROS_PER_DAY);
        System.out.println(MILLIS_PER_DAY);
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
    }
}
