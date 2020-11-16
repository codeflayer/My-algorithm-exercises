package String;

public class Flip {


    /**
     * 翻转字符串里的单词
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     * <p>
     * 说明：
     * <p>
     * 无空格字符构成一个 单词 。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入："the sky is blue"
     * 输出："blue is sky the"
     * 示例 2：
     * <p>
     * 输入："  hello world!  "
     * 输出："world! hello"
     * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 示例 3：
     * <p>
     * 输入："a good   example"
     * 输出："example good a"
     * 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     * 示例 4：
     * <p>
     * 输入：s = "  Bob    Loves  Alice   "
     * 输出："Alice Loves Bob"
     * 示例 5：
     * <p>
     * 输入：s = "Alice does not even like bob"
     * 输出："bob like even not does Alice"
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 104
     * s 包含英文大小写字母、数字和空格 ' '
     * s 中 至少存在一个 单词
     * <p>
     * <p>
     * 进阶：
     * <p>
     * 请尝试使用 O(1) 额外空间复杂度的原地解法。
     *
     * @param argu
     */
    public static void main(String[] argu) {

//        String str = "the sky is blue";
//        String str = "  hello world!  ";
//        String str ="  Bob    Loves  Alice   ";
//        String str = "Alice does not even like bob";
//        String str= "EPY2giL";
//        String str = "kJTYcsZT   68SP WEgyzWeC nm";
        String str = " asdasd df f";
        String result = reverseWords(str);
        System.out.println(result);
    }

    public static String reverseWords(String s) {
        if (s==null || s == "" || s == " "){return s;}
        int idx = s.length();
        String result = "";
        for (int i = (s.length() - 1); i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                String str = s.substring(i, idx);
                str = str.replace(" ", "");
                if (str==" " || str==""){
                   continue;
                }else{
                    result = result + " " + str;
                }
                idx = i;
            }
            if (result != "" && result.charAt(0) == ' '){
                result = result.substring(1, result.length());
            }
            if (i == 0) {
                String str = s.substring(0, idx );
                str = str.replace(" ", "");
                if (str!=""){
                    result = result + " " + str;
                }
            }
        }
        if (result != "" && result.charAt(0) == ' '){
            result = result.substring(1, result.length());
        }
        return result;
    }
}
