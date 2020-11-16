package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *   无重复字符的最长子串
 *
 *   总结
 *   算法1，暴力递归字符串，复杂度高
 *   算法2，滑动窗口算法，前面一个字符加字符，后面遇到相同的字符，则截掉，到最后统计最大的字符
 */
class Norepeat {


    public static void main(String[] argu){
        String a = "abcabcbb";
//        a = "abcabcbblkhuty";
//        a = "aab";
//        a = "pwwkew";
//        a = "ckilbkd";
//        a = "bpfbhmipx";
//       int b =  lengthOfLongestSubstring(a,0);
        int b = lengthOfLongestSubstring(a);
        System.out.println(b);
    }

    //我的解法
    public static int lengthOfLongestSubstring(String s,int count) {
        Map<Character,Character> map = new HashMap<Character,Character>();
        int max = 0;
        for(int i=0;i< s.length(); i++){
            char key = s.charAt(i);
            if (!map.containsKey(key)){
                map.put(key,key);
                max = map.size();
                max = Math.max(max,count);
            }else{
                //回到第二个字符开始新一轮循环
                max = map.size();
                max = Math.max(max,count);
                if (s.length() == 1){return max;}
                return lengthOfLongestSubstring(s.substring(1),max);
            }
        }
        return  max;
    }

    //优解
    public static int lengthOfLongestSubstring(String s) {

        int a = s.length();
        int res = 0;
        int current = 0;
        List<Character> list = new ArrayList<>();
        while (a>current){
            char c = s.charAt(current);
            if (list.contains(c)){
                int idx = list.indexOf(c);
                list = list.subList(idx+1,list.size());
                list.add(c);
            }else{
                list.add(c);
            }
            res = Math.max(res,list.size());
            current++;
        }
        return res;
    }

}