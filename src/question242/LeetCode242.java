package src.question242;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 242. 有效的字母异位词
 * @Author YFAN
 * @Date 2021/6/2
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class LeetCode242 {
    public static void main(String[] args) {
        String s = "123";
        String t = "321";
        System.out.println(new Solution().isAnagram(s, t));

    }
}

class Solution {
    /**
     * 进价 非进阶直接用长度为26的数组就可以解决
     * 哈希表
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) -1);
            if(map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
}
