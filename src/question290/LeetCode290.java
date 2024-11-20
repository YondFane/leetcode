package src.question290;

import java.util.*;

public class LeetCode290 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.wordPattern("abcdefga", "aa a2 a3 a4 a5 a6 s4"));
    }
}


class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = new String[26];
        Set<String> set = new HashSet<>();
        String[] strArrays = s.split(" ");
        if (pattern.length() != strArrays.length) {
            return false;
        }
        for (int i = 0; i < strArrays.length; i++) {
            int j = pattern.charAt(i) - 'a';
            if (strs[j] == null) {
                strs[j] = strArrays[i];
                if (set.contains(strArrays[i])) {
                    return false;
                }
                set.add(strArrays[i]);
                continue;
            }
            if (!Objects.equals(strArrays[i], strs[j])) {
                return false;
            }
        }

        return true;
    }
}


/**
 * 其他解法
 */
class Solution2 {
    public boolean wordPattern(String pattern, String s) {
        List<String> ls = Arrays.asList(s.split(" "));
        int n = pattern.length();
        if (n != ls.size()) return false;
        for (int i = 0; i < n; i++) {
            if (pattern.indexOf(pattern.charAt(i)) != ls.indexOf(ls.get(i)))
                return false;
        }
        return true;
    }
}