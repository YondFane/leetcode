package src.question168;

/*
 *  168. Excel表列名称
 * @author YFAN
 * @date 2022/3/18/018
 168. Excel表列名称
给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
例如：
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...
示例 1：
输入：columnNumber = 1
输出："A"
示例 2：
输入：columnNumber = 28
输出："AB"
示例 3：
输入：columnNumber = 701
输出："ZY"
示例 4：
输入：columnNumber = 2147483647
输出："FXSHRXW"
提示：
1 <= columnNumber <= 231 - 1
 */
public class LeetCode168 {
    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(52));
    }
}
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            sb.append((char)(a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return sb.reverse().toString();
    }
}

class Solution1 {
    private static char[] chars = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            int t = columnNumber % 26;
            if (t == 0) {
                sb.append(chars[25]);
                columnNumber--;
            } else {
                sb.append(chars[t - 1]);
            }
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}