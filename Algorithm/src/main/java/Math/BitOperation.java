package Math;


/**
 * 位运算
 * <p>
 * <p>
 * 题目来源于 LeetCode 上第 231 号问题：2 的幂。题目难度为 Easy，目前通过率为 45.6% 。
 * <p>
 * ### 题目描述
 * <p>
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * <p>
 * **示例 1:**
 * <p>
 * ```
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 * ```
 * <p>
 * **示例 2:**
 * <p>
 * ```
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 * ```
 * <p>
 * **示例 3:**
 * <p>
 * ```
 * 输入: 218
 * 输出: false
 * ```
 */
public class BitOperation {


    public static void main(String[] argu) {
       System.out.println( isPowerOfTwo(9));
    }

    public static boolean  isPowerOfTwo(int n) {

        int ct = 0;
        while (n>0) {
            ct += (n&1);
            n>>=1;
            System.out.println("------");
            System.out.println(ct);
            System.out.println(n);
            System.out.println("======");
        }
        return ct==1;
    }


}
