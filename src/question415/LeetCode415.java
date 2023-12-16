package src.question415;

/**
 * 415. 字符串相加
 * 简单
 * 相关标签
 * 相关企业
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 示例 1：
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * <p>
 * 提示：
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 */
public class LeetCode415 {
    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("23", "199"));
    }
}

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int a = num1.length();// 2
        int b = num2.length();// 3
        int c = Math.max(a, b);// 3

        boolean level = false;
        for (int i = 0; i < c; i++) {
            int num = 0;
            if (a - 1 - i > -1 && b - 1 - i > -1) {
                num = Integer.valueOf(num1.charAt(a - 1 - i) + "") + Integer.valueOf(num2.charAt(b - 1 - i) + "") + (level ? 1 : 0);
            } else if (a - 1 - i > -1) {
                num = Integer.valueOf(num1.charAt(a - 1 - i) + "") + (level ? 1 : 0);
            } else if (b - 1 - i > -1) {
                num = Integer.valueOf(num2.charAt(b - 1 - i) + "") + (level ? 1 : 0);
            }
            level = function(sb, num);
        }
        if (level) {
            function(sb, 1);
        }
        return sb.reverse().toString();
    }

    private boolean function(StringBuilder sb, int num) {
        if (num > 9) {
            sb.append(num - 10);
            return true;
        } else {
            sb.append(num);
            return false;
        }
    }
}


/**
 * 优秀题解
 */
class Solution2 {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while (i >=0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = a + b + carry;
            carry = temp / 10;
            res.append(temp % 10);
            i--; j--;
        }
        if (carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}