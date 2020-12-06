package Math;

/**
 * 7. 整数反转
 * 难度
 * 简单
 * <p>
 * 2386
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class NumberReverse {
    public static void main(String[] argu) {

//        int a = 123;
//        int a = -120;
        int a = 0x7fffffff;
        int r = reverse(a);
        System.out.println(r);
    }

    public static int reverse(int x) {
        //超过最大最小，返回0
        if (x>Integer.MAX_VALUE || x<Integer.MIN_VALUE){
            return 0;
        }
        int f = 0;
        int t = x;
        while (t != 0) {
            int te = t % 10;
            t = (t - te)/10;
            System.out.println("te=="+te);
            System.out.println("t=="+t);
            f = f * 10 + te;
            //超过最大最小，返回0
            if (f>Integer.MAX_VALUE || f<Integer.MIN_VALUE){
                return 0;
            }
            System.out.println("f=="+f);
        }
        return f;
    }

}
