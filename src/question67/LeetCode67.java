package src.question67;

/**
 * 67. 二进制求和
 *
 * @Description:
 * @Author: YFAN
 * @Date: 2021/5/4/004
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class LeetCode67 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char c = '0';
        c++;
        if (c == '1') {
            c++;
        }
        System.out.println(c);
        System.out.println(solution.addBinary("10", "1"));
    }
}

/**
 * 执行用时：
 * 2 ms
 * , 在所有 Java 提交中击败了
 * 98.62%
 * 的用户
 * 内存消耗：
 * 38.3 MB
 * , 在所有 Java 提交中击败了
 * 72.13%
 * 的用户
 */
class Solution {
    // 111111
    //  11101
    public String addBinary(String a, String b) {
        // 长的加短的
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int len = a.length() + 1;
        char[] result = new char[len];
        //进位
        boolean scale = false;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0; i--, j--) {
            char c = '0';
            char c1 = '0';
            if (j >= 0) {
                c1 = b.charAt(j);
            }
            char c2 = a.charAt(i);
            if (scale) {
                c++;
            }
            if (c1 == '1') {
                c++;
            }
            if (c2 == '1') {
                c++;
            }
            if (c == '3') {
                scale = true;
                result[1 + i] = '1';
            }else if (c == '2') {
                scale = true;
                result[1 + i] = '0';
            } else if (c == '1') {
                result[1 + i] = '1';
                scale = false;
            } else if(c=='0'){
                result[1 + i] = '0';
                scale = false;
            }
        }
        if (scale) {
            result[0] = '1';
            return new String(result);
        }
        return new String(result).trim();
    }
}