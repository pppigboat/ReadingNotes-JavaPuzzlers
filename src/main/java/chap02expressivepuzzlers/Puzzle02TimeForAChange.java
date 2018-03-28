package chap02expressivepuzzlers;

import java.math.BigDecimal;

/**
 * 找钱程序
 * 这个程序出错的原因是
 * <p>
 * 1. 1.1不能被浮点数准确的表达
 * 2. 1.1使用float类型描述时为：1.19999ap0(1.0001_1001_1001_1001_1001_1010,最后是舍去尾部后进的)，对应的十进制小数是1.10000002384185791015625
 * 3. 1.1使用double类型描述时为：1.199999999999ap0(1.0001_1001_1001_1001_1001_1001_1001_1001_1001_1001_1001_1001_1010)，对应的十进制小数是1.100000000000000088817841970012523233890533447265625（与1.1已经非常接近了）
 * 4. 2使用float类弄描述为1.0p1
 * 5. 参考资料https://blog.csdn.net/zq602316498/article/details/41148063
 * 6. 使用大整数进行计算的时候，一定要使用BigDecimal(String)，而不是BigDecimal(double)，否则还是表示的近似值。
 * 7. 在进行金额计算的时候，尽量使用int,long或者BigDecimal。
 *
 * @author SpringZ
 * @version 1.0.0  2018-03-09.
 */
public class Puzzle02TimeForAChange {
    public static void main(String[] args) {
        /**
         * float的精度应该是7-8位，而不是6-7位，参考上文链接
         */
        numbertest("0.89999997");
        numbertest("0.89999996");
        numbertest("0.89999995");
        numbertest("0.89999994");
        numbertest("0.89999993");
        numbertest("0.89999992");
        numbertest("0.89999991");
        numbertest("0.89999989");
        numbertest("0.89999988");
        numbertest("0.89999987");
        numbertest("0.33333333");

        poorSolution1();
        poorSolution2();
        goodSolution();
//        testResult();
    }

    private static void testResult() {
        /*
         2.00  - 1.10 :	0.8999999999999999
         2.00f - 1.10 :	0.8999999999999999
         2.00  - 1.10f:	0.8999999761581421
         2.00f - 1.10f:	0.9
         2.00  - a:	0.8999999761581421
         2.00f - a:	0.8999999761581421
         2.00  - b:	0.8999999761581421
         2.00f - b:	0.9
         c:	0x1.199999999999ap0
         d:	0x1.19999ap0
         Float value of 0x1.19999ap0：	1.1
         Double value of 0x1.19999ap0：	1.100000023841858
         Double value of 0x1.199999999999ap0:	1.1
         */
        System.out.println("2.00  - 1.10 :\t" + (2.00 - 1.10));    //2.00 -> double(10.0000), 1.10 -> double        实际上是2.00-1.100000000000000088817841970012523233890533447265625=0.8999999999999999111......
        System.out.println("2.00f - 1.10 :\t" + (2.00f - 1.10));   //2.00 -> float -> double, 1.10 -> double

        System.out.println("2.00  - 1.10f:\t" + (2.00 - 1.10f));   //2.00 -> double, 1.10 -> f -> double
        System.out.println("2.00f - 1.10f:\t" + (2.00f - 1.10f));  //2.00 -> float, 1.10 -> float                   实际上是2.00-1.10000002384185791015625=0.89999997615814208984375

        Double a = (double) 1.10f;
        System.out.println("a:\t" + a);
        System.out.println("2.00  - a:\t" + (2.00 - a));
        System.out.println("2.00f - a:\t" + (2.00f - a));

        float b = 1.10f;
        System.out.println("b:\t" + Float.valueOf(Float.toHexString(b)));
        System.out.println("2.00  - b:\t" + (2.00 - b));
        System.out.println("2.00f - b:\t" + (2.00f - b));

        double c = 1.10;
        float d = 1.10f;

        System.out.println("c:\t" + Double.toHexString(c));
        System.out.println("d:\t" + Float.toHexString(d));

        System.out.println("Float value of 0x1.19999ap0：\t" + Float.valueOf("0x1.19999ap0"));
        System.out.println("Double value of 0x1.19999ap0：\t" + Double.valueOf("0x1.19999ap0"));
        System.out.println("Double value of 0x1.199999999999ap0:\t" + String.format("%.25f", Double.valueOf("0x1.199999999999ap0")));

        /*
         * e 的值取决于1.10是用的float还是double。
         */
        double e = 2.00 - 1.10;
        System.out.println("e:\t" + e);
        e = 2.00 - 1.10f;
        System.out.println("e:\t" + e);
        e = 2.00f - 1.10;
        System.out.println("e:\t" + e);
        e = 2.00f - 1.10f;
        System.out.println("e:\t" + e);

        /*
         * f 全是0.9 打印时转换为十进制进行了四舍五入
         */
        float f = (float) (2.00 - 1.10);
        System.out.println("f:\t" + f);
        f = (float) (2.00 - 1.10f);
        System.out.println("f:\t" + f);
        f = (float) (2.00f - 1.10);
        System.out.println("f:\t" + f);
        f = 2.00f - 1.10f;
        System.out.println("f:\t" + f);
    }

    /**
     * 仅仅解决了2.00-1.10这个特定的问题，并没有解决通用的浮点问题
     * */
    private static void poorSolution1() {
        System.out.printf("%.2f%n", 2.00 - 1.10);
    }

    /**
     * 使用整数进行计算，也不能解决所有问题
     */
    private static void poorSolution2() {
        System.out.println(200 - 110 + " cents");
    }

    /**
     * 使用大整数进行计算，但是肯定会慢点，
     */
    private static void goodSolution() {
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal(Double.valueOf("0x1.19999ap0"))));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal(Double.valueOf("0x1.199999999999ap0"))));
        float x = 2.00f-1.10f;
        System.out.println("x is " + new BigDecimal(x));
        x = 0.3333333333f;
        System.out.println("x is " + x);
        double y = 0.89999997;
        System.out.println("y is " + y);
    }

    private static void numbertest(String x){
        System.out.printf("=====Number : %s ===============\n", x);
        System.out.printf("%s in memory as float:\t%s, \treal decimal value:\t%s \tprinted decimal value:%s\n" , x , Float.toHexString(Float.valueOf(x)) , new BigDecimal(Float.valueOf(x)), Float.valueOf(x));
        System.out.printf("%s in memory as double:\t%s, \treal decimal value:\t%s \tprinted decimal value:%s\n\n" , x , Double.toHexString(Double.valueOf(x)) , new BigDecimal(Double.valueOf(x)), Double.valueOf(x));
    }
}
