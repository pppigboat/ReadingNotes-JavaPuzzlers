package chap03PuzzlerWithCharacter;

/**
 * char是个很特殊的类型，许多方法许多语言都对它进行了特殊的处理。
 *
 * @author SpringZ
 * @version 1.0.0  2018-04-12.
 */
public class Puzzle12ABC {
    public static void main(String[] args) {
        String letters = "ABC";
        char[] numbers = {'1', '2', '3'};
        System.out.println(numbers);//调用的是println(char[])
        System.out.println(letters + " easy as " + numbers);
    }
}
