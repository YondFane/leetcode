package src.question65;

/**
 * 有效数字
 *
 * @Description:
 * @Author: YFAN
 * @Date: 2021/4/29/029
 * <p>
 * 有效数字（按顺序）可以分成以下几个部分：
 * <p>
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分有效数字列举如下：
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * 部分无效数字列举如下：
 * ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 * 输入：s = "0"
 * 输出：true
 * 示例 2：
 * 输入：s = "e"
 * 输出：false
 * 示例 3：
 * 输入：s = "."
 * 输出：false
 * 示例 4：
 * 输入：s = ".1"
 * 输出：true
 * 提示：
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。
 */
public class LeetCode65 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "005047e+6";
        System.out.println(solution.isNumber(str));
    }
}

/**
 *
 * 执行用时：
 * 2 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 * 内存消耗：
 * 37.8 MB
 * , 在所有 Java 提交中击败了
 * 97.81%
 * 的用户
 */
class Solution {
    public boolean hasE = false;
    public boolean preHasDecimalPoint = false;
//    public boolean preHasSign = false;

    public boolean isNumber(String s) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 小数点
            if (c == '.') {
                if (!legalDecimalPoint(s, i)) {
                    return false;
                }
            } else if (c == '-' || c == '+') {
                if (!legalSign(s, i)) {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                if (!legalE(s, i)) {
                    return false;
                }
            } else if (!isNumberChar(c)) {
                return false;
            }
        }
        return true;
    }

    //判断小数点位置是否合法 -.9  +5. 8.3 .7  6.
    public boolean legalDecimalPoint(String s, int i) {
        if (preHasDecimalPoint || hasE) {
            return false;
        }
        preHasDecimalPoint = true;
        if (s.length() - 1 == i && i == 0) {
            return false;
        } else if (s.length() - 1 > i) {
            char c = s.charAt(i + 1);
            if (c == 'e' || c == 'E') {
                return true;
            }
            if (!isNumberChar(c)) {
                return false;
            }
        } else if (s.length() - 1 == i && i > 0) {
            if (!isNumberChar(s.charAt(i - 1))) {
                return false;
            }
        }
        return true;
    }

    //判断+- 是否合法 是否在第一位 或 e后面
    public boolean legalSign(String s, int i) {
        if (s.length() - 1 == i && i == 0) {
            return false;
        }
        if (s.length() - 1 == i) {
            return false;
        }
        if (i != 0 && s.length() - 1 > i) {
            char c = s.charAt(i - 1);
            char c2 = s.charAt(i + 1);
            if ((c == 'e' || c == 'E') && isNumberChar(c2)) {
                return true;
            } else {
                return false;
            }
        }
        if (i == 0) {
            char c = s.charAt(i + 1);
            if (c != '.' && !(isNumberChar(c))) {
                return false;
            }
        }
        return true;
    }

    // 判断E是否合法 后面跟整数 前面是否有  -90E23  6e-1
    public boolean legalE(String s, int i) {
        if (hasE) {
            return false;
        }
        hasE = true;
        if (s.length() - 1 == i || i == 0) {
            return false;
        } else if (i > 0) {
            char c = s.charAt(i - 1);
            char c2 = s.charAt(i + 1);
            //e前面有. 且.不是首位
            if (i - 1 == 0 && c == '.') {
                return false;
            }else if (i - 1 != 0 && c == '.') {
                return true;
            }
            //e后面紧跟-+
            if (c2 == '-' || c2 == '+') {
                return true;
            }
            //e后面不是数字
            if (!isNumberChar(c2)) {
                return false;
            }
        }
        return true;
    }

    //判断是否是数字
    public boolean isNumberChar(char c) {
        if (c >= 48 && c <= 57) {
            return true;
        }
        return false;
    }
}
