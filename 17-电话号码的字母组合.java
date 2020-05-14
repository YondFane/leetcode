package 电话号码的字母组合_17;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YFAN
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 **/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.letterCombinations("23");
        for (String str : list) {
            System.out.println(str);
        }
    }
}
// 1ms 91.51%
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        // 创建一个与digits长度相等的字符数组
        String[] s = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            switch (digits.charAt(i)) {
                case '2':
                    s[i] = "abc";
                    break;
                case '3':
                    s[i] = "def";
                    break;
                case '4':
                    s[i] = "ghi";
                    break;
                case '5':
                    s[i] = "jkl";
                    break;
                case '6':
                    s[i] = "mno";
                    break;
                case '7':
                    s[i] = "pqrs";
                    break;
                case '8':
                    s[i] = "tuv";
                    break;
                case '9':
                    s[i] = "wxyz";
                    break;
            }
        }
        return fun(s, 0, new ArrayList<String>(), new StringBuffer());
    }

    // 递归遍历      index为遍历数组位置
    public List<String> fun(String[] s, int index, List<String> list, StringBuffer sb) {
        if (index < s.length) {
            for (int i = 0; i < s[index].length(); i++) {
                // 递归
                list = fun(s, index + 1, list, sb.append(s[index].charAt(i)));
                // 重置
                sb.deleteCharAt(sb.length()-1);
            }
            index++;
        } else {
            list.add(sb.toString());
        }
        return list;
    }
}