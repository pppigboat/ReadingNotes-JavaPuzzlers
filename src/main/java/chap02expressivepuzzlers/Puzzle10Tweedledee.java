package chap02expressivepuzzlers;

/**
 * 智力题，和上题相反,实际结果和书上不一致啊。这是因为在jls之后进行了修改
 *
 * 参考：https://stackoverflow.com/questions/14218385/how-do-i-make-e1-e2-illegal-while-e1-e1-e2-is-legal
 *
 * @author SpringZ
 * @version 1.0.0  2018-04-10.
 */
public class Puzzle10Tweedledee {
    public static void main(String[] args) {
        Object x = "hi";
        String i = " hello";
        x = x + i;
        x += i;
        System.out.println(x);
    }

}