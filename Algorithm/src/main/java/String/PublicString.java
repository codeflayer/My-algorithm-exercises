package String;


/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 */

class PublicString {
    public static void main(String[] arug) {

//        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"dog","racecar","car"};
//        String[] strs = {"ab", "a"};
//        String[] strs = {"cir","car"};
//        String[] strs = {"aaa", "aa", "aaa"};
//        String[] strs = {"abca","aba","aaab"};
        String[] strs = {"aba", "c", "b", "a", "ab"};
        String str = longestCommonPrefix(strs);
        System.out.println(str);
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {//拿第一个字符串的每一位与其他进行比较
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                //如果第一个字符串长度超过了后面的某一个 或者 后面的字符串第i位不是c，则证明前缀不匹配了，
                // 返回strs[0].substring(0,i)。substring是前闭后开[0,i)
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];//否则证明第一个字符串就是最小公共前缀
    }

}