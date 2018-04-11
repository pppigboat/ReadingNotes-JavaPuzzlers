package chap02expressivepuzzlers;

/**
 * java结合率是从左到右，在赋值之前左操作数会被先采样（x的两次采样都是使用原始值1984），因此不可以这么做
 *
 * 所以尽量不要在一个表达式里多变量进行多次赋值
 * @author SpringZ
 * @version 1.0.0  2018-04-10.
 */
public class Puzzle07SwapMeat {
    public static void main(String[] args) {
        int x = 1984; //0x7c0
        int y = 2001; //0x7d1
        x ^=y ^=x ^=y; //x = x^y;(x = 17) y = y^x ;(y=1984) x = x ^y;(x = 1984^1984)
        System.out.println(x + " " + y);
        System.out.println(1984 ^2001);
    }

}
