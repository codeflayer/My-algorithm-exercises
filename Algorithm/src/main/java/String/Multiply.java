package String;

public class Multiply {

    /**
     * 不是很懂
     * <p>
     * 字符串相乘
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * <p>
     * 示例 1:
     * <p>
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例 2:
     * <p>
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * 说明：
     * <p>
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     *
     * @param argu
     */
    public static void main(String[] argu) {
        String num1 = "55";
        String num2 = "66";
        String result = multiply(num1, num2);
        System.out.println(result);
    }


    public static String multiply(String num1, String num2) {
        if (num1.equals('0')) return "0";
        if (num2.equals('0')) return "0";
        if (num1.equals("")) return null;
        if (num2.equals("")) return null;
        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int c2 = num2.charAt(j) - '0';
                int c1 = num1.charAt(i) - '0';
                int temp = (c1 * c2);
                int po = i + j + 1;
                result[po] += temp;
                System.out.println(result);
                System.out.println("\n");
            }
        }

        int add = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            int temp = (result[i] + add) % 10;
            add = (result[i] + add) / 10;
            result[i] = temp;
        }
        //将结果转化为字符串，使用Stringbuffer；
        StringBuffer buf = new StringBuffer();
        for (int i : result) {
            buf.append(i);
        }
        //将StringBuffer转换为String，注意结果去‘0’
        String s = new String(buf);
        if (s.length() > 0 && s.charAt(0) == '0')//结果最多只会出现首位是0的情况
            s = s.substring(1);
        return s;
    }

}
