package src.question12;

import java.util.HashMap;

/**整数转罗马数字
 * @Author YFAN
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * 输入: 3
 * 输出: "III"
 * <p>
 * 示例 2:
 * 输入: 4
 * 输出: "IV"
 * <p>
 * 示例 3:
 * 输入: 9
 * 输出: "IX"
 * <p>
 * 示例 4:
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * <p>
 * 示例 5:
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 **/
public class LeetCode12 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(1994));
    }
}

// 5ms 90.60%
// 继续精简 去掉多余代码
class Solution {
    public String intToRoman(int num) {
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuffer sb = new StringBuffer();
        int i= 0;
        while (i < ints.length) {
            while(num >= ints[i]) {
                sb.append(strs[i]);
                num -=ints[i];
            }
            i++;
        }
        return sb.toString();
    }
}


// 5ms 90.60%
// 改进后
class Solution2 {
    public String intToRoman(int num) {
        String[] strs = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
                "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC",
                "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM",
                "", "M", "MM", "MMM"};

        StringBuffer sb = new StringBuffer();

        if (num >= 1000) {
            sb.append(strs[num / 1000 + 30]);
            num %=1000;
        }
        if (num >= 100) {
            sb.append(strs[num / 100 + 20]);
            num %=100;
        }
        if (num>= 10) {
            sb.append(strs[num / 10 + 10]);
            num %=10;
        }
        if (num > 0) {
            sb.append(strs[num]);
        }

        return sb.toString();
    }
}
// 12ms 12.09%
// 改进前
class Solution1 {
    public String intToRoman(int num) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 200, 300,
                400, 500, 600, 700, 800, 900, 1000, 2000, 3000};
        String[] strs = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XX", "XXX", "XL", "L",
                "LX", "LXX", "LXXX", "XC", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M", "MM", "MMM"};
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < ints.length; i++) {
            map.put(ints[i], strs[i]);
        }

        StringBuffer sb = new StringBuffer();

        if (num / 1000 > 0) {
            sb.append(map.get(num / 1000 * 1000));
            num %=1000;
        }
        if (num / 100 > 0) {
            sb.append(map.get(num / 100 * 100));
            num %=100;
        }
        if (num / 10 > 0) {
            sb.append(map.get(num / 10 * 10));
            num %=10;
        }
        if (num > 0) {
            sb.append(map.get(num));
        }

        return sb.toString();
    }
}