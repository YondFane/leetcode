package src.question792;

import java.util.ArrayList;
import java.util.List;

/**
 * 792. 匹配子序列的单词数
 * 中等
 * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
 * <p>
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * <p>
 * 例如， “ace” 是 “abcde” 的子序列。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
 * Example 2:
 * <p>
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出: 2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 5 * 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * words[i]和 s 都只由小写字母组成。
 */
public class LeetCode792 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
        System.out.println(solution2.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));

        System.out.println(solution.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
        System.out.println(solution.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));

    }
}


class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int ans = words.length;
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
            // 默认添加一个-1，表示没有该字符
            pos[i].add(-1);
        }
        for (int i = 0; i < s.length(); i++) {
            // 字符所在位置列表
            pos[s.charAt(i) - 'a'].add(i);
        }
        for (String word : words) {
            int pre = -1;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                // 字符列表所在最后一个位置小于当前位置
                if (pos[index].get(pos[index].size() - 1) <= pre) {
                    ans--;
                    break;
                }
                int l = 0;
                int r = pos[index].size() - 1;
                // 通过二分查找减少查找次数，获取最靠近pre的位置（大于pre）
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (pos[index].get(mid) > pre) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                pre = pos[index].get(r);
                if (pre == -1) {
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}

class Solution2 {
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            char[] wordChar = word.toCharArray();
            int len = wordChar.length;
            int index = 0;
            for (char c : s.toCharArray()) {
                if (wordChar[index] == c) {
                    index++;
                    len--;
                }
                if (len == 0) {
                    break;
                }
            }
            if (len == 0) {
                ans++;
            }
        }
        return ans;
    }
}