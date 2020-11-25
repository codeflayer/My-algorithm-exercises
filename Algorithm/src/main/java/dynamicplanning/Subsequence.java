package dynamicplanning;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false.
 * <p>
 * 后续挑战 :
 * <p>
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢:
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 讲解：
 * https://leetcode-cn.com/problems/is-subsequence/solution/shi-pin-jiang-jie-dong-tai-gui-hua-qiu-jie-is-subs/
 */
public class Subsequence {
    public static void main(String[] args) {

        String s = "abc";
        String t = "ahbgdc";

        boolean r = isSubsequence(s, t);
        System.out.println(r);
    }

    //动态规划
    public static boolean isSubsequence(String s, String t) {

        boolean table[][] = new boolean[s.length() + 1][t.length() + 1];

        //初始化一堆空字符串，肯定是包含
        for (int col = 0; col < table[0].length; col++) {
            table[0][col] = true;
        }

        for (int row = 1; row < table.length; row++) {
            char ch1 = s.charAt(row - 1);
            String str = "";
            for (int col = 1; col < table[row].length; col++) {
                char ch2 = t.charAt(col - 1);
                if (ch1 == ch2) {
                    //如果上一行的上一列也是子字符串是被包含的，当前的也是被包含的
                    table[row][col] = table[row - 1][col - 1];
                } else {
                    //上一列如果是不包含的，就不会包含
                    table[row][col] = table[row][col - 1];
                }


                str += table[row][col];
                str += "|";
                if (t.length() == col) {
                    System.out.println(str);
                }
            }
        }

        boolean[] lastRow = table[table.length - 1];
        return lastRow[lastRow.length - 1];
    }


}
