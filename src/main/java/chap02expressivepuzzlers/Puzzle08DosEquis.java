package chap02expressivepuzzlers;

/**
 * 这是规范的阴暗角落。jls15.22
 *
 * 因为0是整型常量，所以x作为整型类的基础数据类型可以打印出X，但是i是整型变量，因此要将x进行整型提升再打印。真是坑啊
 *
 * @author SpringZ
 * @version 1.0.0  2018-04-10.
 */
public class Puzzle08DosEquis {
    public static void main(String[] args) {
        char x = 'X';
        int i = 0;
        System.out.println(true ?  x : 0);
        System.out.println(false ? i : x);
    }
}
