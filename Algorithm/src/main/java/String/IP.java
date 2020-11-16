package String;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 * <p>
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 */
public class IP {

    // 255,255,111,35

    public static void main(String[] argu) {
//        String s = "25525511135";
        String s = "101023";
        List<String> result = restoreIpAddresses(s);
        System.out.println(result);
    }
    public static List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() <= 3) {
            return null;
        }
        List<String> list = new ArrayList<>();
        for (int j = 1; j <s.length()-2; j++) {
            String str1 = s.substring(0,j);
            String temp = "";
            if (Integer.valueOf(str1) > 255){
                continue;
            }
            for (int i = j+1; i <s.length()-1; i++) {
                String str2 = s.substring(j,i);
                if (Integer.valueOf(str2) > 255){
                    continue;
                }
                for (int k = i+1; k < s.length(); k++) {
                    String str3 = s.substring(i, k);
                    if (Integer.valueOf(str3) > 255) {
                        continue;
                    }
                    String str4 = s.substring(k, s.length());
                    if (Integer.valueOf(str4) > 255) {
                        continue;
                    }
                    temp = new StringBuffer().append(Integer.valueOf(str1)).append(".").
                            append(Integer.valueOf(str2)).append(".")
                            .append(Integer.valueOf(str3)).append(".").
                            append(Integer.valueOf(str4))
                            .toString();
                     list.add(temp);
                }
             }
        }
        return list;
    }


}
