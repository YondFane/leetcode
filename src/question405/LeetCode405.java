package src.question405;

import java.util.HashMap;
import java.util.Map;

/**
 405. 数字转换为十六进制数
 简单
 相关标签
 premium lock icon
 相关企业
 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。

 答案字符串中的所有字母都应该是小写字符，并且除了 0 本身之外，答案中不应该有任何前置零。

 注意: 不允许使用任何由库提供的将数字直接转换或格式化为十六进制的方法来解决这个问题。

 示例 1：

 输入：num = 26
 输出："1a"
 示例 2：

 输入：num = -1
 输出："ffffffff"

 提示：

 -231 <= num <= 231 - 1
 */
public class LeetCode405 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println((char) ('0' + (2 - 0)));
        System.out.println((char) ('a' + (10 - 10)));
        System.out.println((char) ('a' + (13 - 10)));

        System.out.println(8 >> 4);

        System.out.println(solution.toHex(26));
        System.out.println(solution.toHex(110));
        System.out.println(solution.toHex(-1));
        System.out.println(solution.toHex(-2));
    }
}

class Solution {

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 7; i >= 0; i --) {
            int val = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || val > 0) {
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                sb.append(digit);
            }
        }
        return sb.toString();
    }
}