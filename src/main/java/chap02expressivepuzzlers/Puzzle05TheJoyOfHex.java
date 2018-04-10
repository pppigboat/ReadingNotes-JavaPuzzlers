package chap02expressivepuzzlers;

/**
 * 1. 使用十进制常量有一个好处就是很容易识别正数和负数。
 * 2. 尽量避免混合类型的计算
 *
 * @author SpringZ
 * @version 1.0.0  2018-03-30.
 */
public class Puzzle05TheJoyOfHex {
    public static void main(String[] args) {
        //0xcafebabe是一个int型的负数，提升为long型的时候会前补1，因此是0xffffffffcafebabeL，与0x10000000L相加之后溢出，为0x00000000cafebabeL
        System.out.println(Long.toHexString(0x100000000L + 0xcafebabe));
        theRightWay();
    }

    public static void theRightWay(){
        System.out.println(Long.toHexString(0x100000000L + 0xcafebabeL));
    }
}
