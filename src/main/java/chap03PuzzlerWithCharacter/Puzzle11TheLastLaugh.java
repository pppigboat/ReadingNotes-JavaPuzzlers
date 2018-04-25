package chap03PuzzlerWithCharacter;

/**
 * 如果需要用其他类型通过+构造一个字符串，尤其是主类型，需要使用""+这种技巧来强制调用+的符号重载功能。
 *
 * @author SpringZ
 * @version 1.0.0  2018-04-12.
 */
public class Puzzle11TheLastLaugh {
    public static void main(String[] args) {
        System.out.println("H"+"a");
        System.out.println('H'+'a');
    }
}
