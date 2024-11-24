package src.question6;

/**Z字形变换
 *
 * @Author YFAN
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * <p>
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * <p>
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 **/
public class LeetCode6 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("LGREOELIIECIHNTSGCODEISHIRING", 4));
    }
}
// 2ms 100%
class Solution {
    // | /  | /  规律......
    // |/   |/   柱 - 斜线 - 柱 - 斜线
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        // 同一行，柱与柱之间的路径
        int v = (numRows - 1) * 2;
        int len = s.length();
        char[] buf = new char[len];
        // 当前坐标
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len && index < len; j += v) {
                // 对当前行的柱上的字符进行赋值给buf
                buf[index++] = s.charAt(j);
                // 中间 斜线 另外处理
                if (i > 0 && i < numRows -1) {
                    // 同一行中 斜线上的点 柱间 的路径
                    int t = j + v - 2 * i;
                    if (t < len) {
                        buf[index++] = s.charAt(t);
                    }
                }
            }
        }
        return new String(buf);
    }

}

// 32.42%
class Solution1 {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        // 创建numRows个StringBuffer对象
        StringBuffer[] sb = new StringBuffer[numRows];
        int len = s.length();
        // 当前位置
        int index = 0;
        // 自增与自减标志位
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            // 第一次调用创建实例
            if (sb[index] == null) {
                sb[index] = new StringBuffer();
            }
            // 添加字符
            sb[index].append(s.charAt(i));
            // 判断是否到上边界，再次自增则数组下标越位
            if (flag && index == numRows - 1) {
                flag = false;
            }
            // 判断是否到上边界，再次增减则数组下标越位
            if (!flag && index == 0) {
                flag = true;
            }
            // 根据自增与自减标志位进行自增或自减
            if (flag) {
                index++;
            } else {
                index--;
            }
        }
        // 拼接字符串
        String str = "";
        for (StringBuffer temp : sb) {
            str += temp.toString();
        }
        return str;
    }
}