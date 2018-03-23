package chap02expressivepuzzlers;

/**
 * 找钱程序
 * 这个程序出错的原因是
 * <p>
 * 1. 1.1不能被浮点数准确的表达
 * 2. 1.1使用float类型描述时为：1.19999ap0，与其最接近的十进制小数是1.100000023841858
 * 3. 1.1使用double类型描述时为：1.199999999999ap0，与其最接近的十进制小数是1.1（与1.1已经非常接近了）
 * 4. 2使用float类弄描述为1.0p1
 *
 * @author SpringZ
 * @version 1.0.0  2018-03-09.
 */
public class Puzzle02TimeForAChange {
    public static void main(String[] args) {
        testResult();
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
        System.out.println("2.00  - 1.10 :\t" + (2.00 - 1.10));    //2.00 -> double, 1.10 -> double(!)
        System.out.println("2.00f - 1.10 :\t" + (2.00f - 1.10));   //2.00 -> float -> double, 1.10 -> double

        System.out.println("2.00  - 1.10f:\t" + (2.00 - 1.10f));   //2.00 -> double, 1.10 -> f -> double
        System.out.println("2.00f - 1.10f:\t" + (2.00f - 1.10f));  //2.00 -> float, 1.10 -> float 最接近0x2ap0 - 0x1.19999ap0的十进制小数是0.9

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
        System.out.println("Double value of 0x1.199999999999ap0:\t" + Double.valueOf("0x1.199999999999ap0"));

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
}
