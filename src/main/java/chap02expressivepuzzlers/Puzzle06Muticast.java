package chap02expressivepuzzlers;

/**
 * cast
 *
 * 1. 从int到byte的时候，直接保留最后1个byte，参考jls5.1.3
 * 2. byte是有符号的，而char是无符号的。这时候就被视为一个widening and narrowing jls 5.1.4，实际上是byte -> int -> char
 * 3. 综合来说就是如果原类型是有符号的，就进行符号扩展，如果是char，就进行0扩展。
 * 4. 在这种容易出错的地方最好是清晰的说明自己要干什么
 *
 * @author SpringZ
 * @version 1.0.0  2018-03-30.
 */
public class Puzzle06Muticast {
    public static void main(String[] args) {
        System.out.println((int)(char)(byte)-1);//ffffffff->byte:ff->char:ffff->int：0xffff
    }
}
