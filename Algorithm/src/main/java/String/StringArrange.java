package String;

public class StringArrange {
    /**
     * 字符串的排列
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     * <p>
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     * <p>
     * 示例1:
     * <p>
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     * <p>
     * <p>
     * 示例2:
     * <p>
     * 输入: s1= "ab" s2 = "eidboaoo"
     * 输出: False
     */
    public static void main(String[] argu) {
//        String s1 = "oa";
//        String s2 = "eidboaoo";
//        String s1 = "a";
//        String s2 = "eidboaoo";
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean b = checkInclusion(s1, s2);
        System.out.println(b);
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1 == "") return false;
        if (s2 == null || s2 == "") return false;
        if (s1.length() > s2.length()) return false;
        int[] sa1 = new int[26];
        int[] sa2 = new int[26];
        int count = s1.length();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            sa1[c1 - 'a']++;
            sa2[c2 - 'a']++;
        }
        int temp = 0;
        for (int i = 0; i < sa1.length; i++) {
            if (sa1[i] == 0){
                return true;
            }
            for (int j = temp; j < sa2.length; j++) {
                if (sa1[i] == sa2[j]){
                    int temp2 = s1.length();
                    while(temp2>0) {
                        if (sa1[i++] != sa2[j++]) {
                            return false;
                        }
                        temp2 --;
                    }
                }
            }
        }
        return true;
    }


}
