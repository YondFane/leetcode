package src.question76;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * 76. 最小覆盖子串
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s 和 t 由英文字母组成
 * <p>
 * <p>
 * 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 */
public class LeetCode76 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        //System.out.println("res:"+solution.minWindow("ADOBECODEBANC", "ABC"));// BANC
        //System.out.println("res:"+solution.minWindow("cabefgecdaecf", "cae"));// aec
        System.out.println("res:" + solution.minWindow("cabwefgewcwaefgcf", "cae"));// cwae

    }
}

/**
 * 官方题解
 * 使用滑动窗口
 */
class Solution {

    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}

class Solution2 {

    /**
     * ABTCTTTTTAWWBCD  ABC
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        String res1 = s;
        String res2 = s;

        int i = 1;
        int maxi = -1;
        while (i <= s.length()) {
            String str = s.substring(0, i);
            if (minWindowFun(str, t)) {
                maxi = Math.max(maxi, i);
                res1 = str.length() > res1.length() ? res1 : str;
                break;
            }
            i++;
        }
        if (maxi == -1) {
            return "";
        }
        int j = 0;
        while (j < s.length()) {
            String str = s.substring(j, s.length());
            if (minWindowFun(str, t)) {
                res2 = str.length() > res2.length() ? res2 : str;
            }
            j++;
        }
        // TABCT ABC -> res1 = TABC ,res2 = ABCT
        System.out.println("res1:" + res1);
        System.out.println("res2:" + res2);
        String res = res1;
        if (res1.length() == res2.length()) {
            int q = 0;
            int p = res1.length();
            ;
            while (q < p) {
                String str1 = res1.substring(q, p);
                String str2 = res2.substring(q, p);
                boolean flag1 = false;
                boolean flag2 = false;
                if (minWindowFun(str1, t)) {
                    res1 = str1.length() > res1.length() ? res1 : str1;
                    flag1 = true;
                }
                if (minWindowFun(str2, t)) {
                    res2 = str2.length() > res2.length() ? res2 : str2;
                    flag1 = false;
                }
                if (!flag1 && !flag2) {
                    p--;
                }
                if (flag1 && flag2) {
                    q++;
                }
                if (res1.length() != res2.length()) {
                    break;
                }
            }
            res = res1.length() > res2.length() ? res2 : res1;
        } else {
            res = res1.length() > res2.length() ? res2 : res1;
        }

        if (Objects.equals(res, t)) {
            return t;
        }
        int k = 0;
        while (k < res.length()) {
            String str = res.substring(k, res.length());
            if (minWindowFun(str, t)) {
                res = str.length() > res.length() ? res : str;
            }
            k++;
        }
        k = 0;
        while (k < res.length()) {
            String str = res.substring(0, k);
            if (minWindowFun(str, t)) {
                res = str.length() > res.length() ? res : str;
            }
            k++;
        }
        return res;
    }

    public boolean minWindowFun(String s, String t) {
        int[] cnt = new int[123];
        for (char c : s.toCharArray()) {
            cnt[c - '0']++;
        }
        for (char c : t.toCharArray()) {
            cnt[c - '0']--;
            if (cnt[c - '0'] < 0) {
                return false;
            }
        }
        return true;
    }
}