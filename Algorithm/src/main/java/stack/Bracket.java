package stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 难度
 * 简单
 * <p>
 * 1988
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class Bracket {


    public static void main(String[] argu) {
        String str = "([{})]";
        boolean r = isValide(str);
        System.out.println(r);
    }

    static boolean isValide(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() % 2 == 1) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
