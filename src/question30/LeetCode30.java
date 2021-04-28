package src.question30;

import java.util.*;

/**串联所有单词的子串
 * @Author YFAN
 * @Description
 * @Date 21:21 2020/7/15/015
给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

示例 1：
输入：
s = "barfoothefoobarman",
words = ["foo","bar"]
输出：[0,9]
解释：
从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。

示例 2：
输入：
s = "wordgoodgoodgoodbestword",
words = ["word","good","best","word"]
输出：[]
 **/
public class LeetCode30 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        List<Integer> list = solution.findSubstring(s, words);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
//执行用时：
//132 ms
//, 在所有 Java 提交中击败了
//44.64%
//的用户
//内存消耗：
//40.6 MB
//, 在所有 Java 提交中击败了
//18.75%
//的用户
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0
                || s.length() < words.length * words[0].length()){
            return new ArrayList<>();
        } else {
            int step = words.length * words[0].length();
            List<Integer> list = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            for (String str : words) {
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
            }
            // 循环滑动
            for (int i = 0; i <= s.length() - step; i++) {
                if (fun(map, s.substring(i, i+step), words)) {
                    list.add(i);
                }
            }
            return list;
        }
    }
    public boolean fun(Map<String, Integer> map, String s, String[] words) {
        int step = words[0].length();
        Map<String, Integer> tMap = new HashMap<>();
        for (int i = 0; i <= s.length() - step; i+=step) {
            String str = s.substring(i, i + step);
            if (map.containsKey(str)) {
                Integer t = tMap.get(str);
                tMap.put(str, t == null ? 1 : t + 1);
            } else {
                return false;
            }
            if (tMap.get(str) > map.get(str)) {
                return false;
            }
        }
        return true;
    }
}
// 执行用时：
//152 ms
//, 在所有 Java 提交中击败了
//39.07%
//的用户
//内存消耗：
//40.2 MB
//, 在所有 Java 提交中击败了
//31.25%
//的用户
class Solution1 {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0
                || s.length() < words.length * words[0].length()){
            return new ArrayList<>();
        } else {
            int step = words.length * words[0].length();
            List<Integer> list = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            for (String str : words) {
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
            }
            // 循环滑动
            for (int i = 0; i <= s.length() - step; i++) {
                if (fun(map, s.substring(i, i+step), words)) {
                    list.add(i);
                }
            }
            return list;
        }
    }
    public boolean fun(Map<String, Integer> map, String s, String[] words) {
        int step = words[0].length();
        Map<String, Integer> tMap = new HashMap<>(map);
        for (int i = 0; i <= s.length() - step; i+=step) {
            String str = s.substring(i, i + step);
            if (tMap.containsKey(str)) {
                int num = tMap.get(str);
                if (num <= 0) {
                    return false;
                }
                tMap.put(str, num - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}