package src.question205;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 205. 同构字符串
 * @author YFAN
 * @date 2022/3/11/011
205. 同构字符串
给定两个字符串 s 和 t ，判断它们是否是同构的。
如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
示例 1:
输入：s = "egg", t = "add"
输出：true
示例 2：
输入：s = "foo", t = "bar"
输出：false
示例 3：
输入：s = "paper", t = "title"
输出：true
提示：
1 <= s.length <= 5 * 104
t.length == s.length
s 和 t 由任意有效的 ASCII 字符组成
 */
public class LeetCode205 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //"bbbaaaba"
        //"aaabbbba"
        System.out.println(solution.isIsomorphic("abc", "bca"));
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // 记录映射 x : y
        char[] mapping = new char[128];
        Arrays.fill(mapping, (char) 128);
        // 记录是否被映射 y : x
        boolean[] mapped = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (mapping[sChar] == 128) {
                if(mapped[tChar]) {
                    return false;
                }
                mapping[sChar] = tChar;
                mapped[tChar] = true;
            }
            if (mapping[sChar] != tChar) {
                return false;
            }
        }
        return true;
    }
}

class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }
}