package chap02expressivepuzzlers;

/**
 * 这是一个判断参数是否是奇数的方法。
 * <p> 1. %定义需要满足以下条件：(a / b) + (a % b) = a)</p>
 * <p>2. 在JLS 15.17.2中规定：余数应该和被除数有同样的符号 （%的结果与其左操作数有同样的符号）</p>
 * <p>3. / 和 % 性能不如其他操作，但是如果优化性能会影响可读性的话，就不要优化了</p>
 *
 * @author SpringZ
 * @version 1.0.0  2018-03-07.
 */
public class Puzzle01Oddity {
    public static void main(String[] args) {
        int testValue = -31;
        System.out.println("Use the wrong way to test: Is [" + testValue + "] odd? Result: " + isOddTheWrongWay(testValue));
        System.out.println("Use the right way to test: Is [" + testValue + "] odd? Result: " + isOddTheRightWayNo1(testValue));
        System.out.println("Use the right way to test: Is [" + testValue + "] odd? Result: " + isOddTheRightWayNo2(testValue));

        System.out.println("\nNow start to test");
    }

    /**
     * 一个判断奇数的错误方法，仅当输入参数为非负整数和偶数的时候是正确的。
     * 对于负奇数，方法会返回-1
     *
     * @param i 要判断的数
     * @return 判断结果，如果是技术则返回真
     */
    private static boolean isOddTheWrongWay(int i) {
        return i % 2 == 1;
    }

    private static boolean isOddTheRightWayNo1(int i) {
        return i % 2 != 0;
    }

    private static boolean isOddTheRightWayNo2(int i) {
        return (i & 1) != 0;
    }
}
