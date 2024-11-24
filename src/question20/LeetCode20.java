package src.question20;

import java.util.Stack;

/**有效的括号
 * @Author YFAN
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:
输入: "()"
输出: true

示例 2:
输入: "()[]{}"
输出: true

示例 3:
输入: "(]"
输出: false

示例 4:
输入: "([)]"
输出: false

示例 5:
输入: "{[]}"
输出: true
 **/
public class LeetCode20 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()[]"));
    }
}
// 1ms 99.13%
// 弃用Stack，改用char数组，设置一个指针进行出入栈操作，减少使用Stack耗费的时间
class Solution {
    public boolean isValid(String s) {
        // chars数组中默认字符为空字符（\0）
        char[] chars = new char[s.length() + 1];
        int index = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c =='[' || c == '{') {
                chars[index++] = s.charAt(i);
            } else {
                index--;
                if ((chars[index] == '(' && c == ')') || (chars[index] == '[' && c == ']') || (chars[index] == '{' && c == '}')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return index == 1;
    }
}

// 2ms 85.60%
// 改进版 减少代码行数而已，时间还是差不多
class Solution2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char temp = '0';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c =='[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    temp = stack.peek();
                    if ((temp == '(' && c == ')') || (temp == '[' && c == ']') || (temp == '{' && c == '}')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}

// 2ms 85.60%
class Solution3 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char temp = '0';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.empty()) {
                        return false;
                    }
                    temp = stack.peek();
                    if (temp == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.empty()) {
                        return false;
                    }
                    temp = stack.peek();
                    if (temp == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.empty()) {
                        return false;
                    }
                    temp = stack.peek();
                    if (temp == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}