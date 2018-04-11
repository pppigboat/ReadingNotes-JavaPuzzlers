package chap02expressivepuzzlers;

/**
 * 智力题 x += i是合法的，但是x = x+i是不合法的。
 *
 * 1. 在复合操作符上不要使用不同的数据类型
 *
 * @author SpringZ
 * @version 1.0.0  2018-04-10.
 */
public class Puzzle09Tweedledum {
    public static void main(String[] args) {
        short x = 1;
        int i = 2;
        x += i;
        //x = x + i;
    }
}
