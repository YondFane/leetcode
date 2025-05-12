package src.question3335;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 3335. 字符串转换后的长度 I
 中等
 相关标签
 相关企业
 提示
 给你一个字符串 s 和一个整数 t，表示要执行的 转换 次数。每次 转换 需要根据以下规则替换字符串 s 中的每个字符：

 如果字符是 'z'，则将其替换为字符串 "ab"。
 否则，将其替换为字母表中的下一个字符。例如，'a' 替换为 'b'，'b' 替换为 'c'，依此类推。
 返回 恰好 执行 t 次转换后得到的字符串的 长度。

 由于答案可能非常大，返回其对 109 + 7 取余的结果。

 示例 1：

 输入： s = "abcyy", t = 2

 输出： 7

 解释：

 第一次转换 (t = 1)
 'a' 变为 'b'
 'b' 变为 'c'
 'c' 变为 'd'
 'y' 变为 'z'
 'y' 变为 'z'
 第一次转换后的字符串为："bcdzz"
 第二次转换 (t = 2)
 'b' 变为 'c'
 'c' 变为 'd'
 'd' 变为 'e'
 'z' 变为 "ab"
 'z' 变为 "ab"
 第二次转换后的字符串为："cdeabab"
 最终字符串长度：字符串为 "cdeabab"，长度为 7 个字符。
 示例 2：

 输入： s = "azbk", t = 1

 输出： 5

 解释：

 第一次转换 (t = 1)
 'a' 变为 'b'
 'z' 变为 "ab"
 'b' 变为 'c'
 'k' 变为 'l'
 第一次转换后的字符串为："babcl"
 最终字符串长度：字符串为 "babcl"，长度为 5 个字符。


 提示：

 1 <= s.length <= 105
 s 仅由小写英文字母组成。
 1 <= t <= 105
 */
public class LeetCode3335 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        System.out.println(solution.lengthAfterTransformations("abcyy", 2));
        System.out.println(solution.lengthAfterTransformations("k", 10));
        System.out.println(solution.lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517));// 79033769
        System.out.println(solution.lengthAfterTransformations("optxpnfacrptrflqjswkpbf", 1535));
        System.out.println(solution.lengthAfterTransformations("iatckelagcytuuxbgiajuoni", 6626));// 828985333
        System.out.println(solution2.lengthAfterTransformations("iatckelagcytuuxbgiajuoni", 6626));// 828985333
    }
}

class Solution {
    public int lengthAfterTransformations(String s, int t) {
        long mod = 1000000007;
        long[] cnt = new long[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            long[] tmp = new long[26];
            tmp[0] = cnt[25];
            tmp[1] = (cnt[25] + cnt[0]) % mod;
            for (int j = 2; j < cnt.length; j++) {
                tmp[j] = cnt[j - 1];
            }
            cnt = tmp;
        }
        long res = 0;
        for (int j = 0; j < cnt.length; j++) {
            res = (res  + cnt[j] ) % mod;
        }
        return (int) (res);
    }
}


/**
 * 优秀题解
 */
class Solution2 {
    public int lengthAfterTransformations(String s, int t) {
        int mod = 1000000007;
        int res = 0;
        int[] cnt = new int[t + 27];
        Arrays.fill(cnt, 1);
        for (int i = 26; i < cnt.length; i++) {
            cnt[i] = (cnt[i - 26] + cnt[i - 25]) % mod;
        }
        for (char ch : s.toCharArray()) {
            res = (res + cnt[ch - 'a' + t]) % mod;
        }
        return res;
    }
}