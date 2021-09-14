package src.question524;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 524. 通过删除字母匹配到字典里最长单词
 * @Author YFAN
 * @Date 2021/9/14
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 * 示例 1：
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 * 提示：
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 */
public class LeetCode524 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        System.out.println(new Solution().findLongestWord("abpcplea", list));
    }
}

class Solution {
    /**
    * @Description 使用双指针
    * @Author YFAN
    * @Date 2021/9/14
    * @params [s, dictionary]
    * @return java.lang.String
    */
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (String str : dictionary) {
            if (str.length() < result.length()) {
                continue;
            }
            int i = 0;
            int j = 0;
            while (i < str.length() && j < s.length()) {
                if (str.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;
            }
            if (i == str.length()) {
                if (str.length() > result.length() || (str.length() == result.length() && str.compareTo(result) < 0)) {
                    result = str;
                }
            }
        }
        return result;
    }
}