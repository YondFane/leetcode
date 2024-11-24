package src.question7;

/**整数反转
 * @Author YFAN
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 *  示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 **/
public class LeetCode7 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(0));
    }
}
// 1ms 100%
class Solution {
    public int reverse(int x) {
        if (x >= 0) {
            long result = fun(x);
            if (result <= Integer.MAX_VALUE) {
                return (int) result;
            } else {
                return 0;
            }
        } else {
            long result = -fun(-x);
            if (result >= Integer.MIN_VALUE) {
                return (int) result;
            } else {
                return 0;
            }
        }
    }
    // 使用long类型进行反转
    public long fun(long x) {
        long result = 0;
        while (x > 0) {
            result *= 10;
            result += x % 10;
            x /= 10;
        }
        return result;
    }
}


// 10ms 6.7%
class Solution1 {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        if (x >= 0) {
            long result = 0;
            StringBuffer sb = new StringBuffer();
            String str = "";

            sb.append(x);
            str = sb.reverse().toString();
            if (str.charAt(0) == '0') {
                result = Long.parseLong(str.substring(1));
            } else {
                result = Long.parseLong(str);
            }

            if (result < Integer.MAX_VALUE && result > Integer.MIN_VALUE) {
                return (int) result;
            } else {
                return 0;
            }
        } else {
            long result = 0;
            StringBuffer sb = new StringBuffer();
            String str = x + "";

            sb.append(str.substring(1));
            str = sb.reverse().toString();
            if (str.charAt(0) == '0') {
                result = Long.parseLong(str.substring(1));
            } else {
                result = Long.parseLong(str);
            }
            if (result < Integer.MAX_VALUE && result > Integer.MIN_VALUE) {
                return (int) -result;
            } else {
                return 0;
            }
        }

    }
}
