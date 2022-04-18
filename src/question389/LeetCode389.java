package src.question389;

/*
 * 389. 找不同
 * @author YFAN
 * @date 2022/4/18/018
给定两个字符串 s 和 t ，它们只包含小写字母。
字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
请找出在 t 中被添加的字母。
示例 1：
输入：s = "abcd", t = "abcde"
输出："e"
解释：'e' 是那个被添加的字母。
示例 2：
输入：s = "", t = "y"
输出："y"
提示：
0 <= s.length <= 1000
t.length == s.length + 1
s 和 t 只包含小写字母
 */
public class LeetCode389 {
    public static void main(String[] args) {

    }
}

class Solution {
    public char findTheDifference(String s, String t) {
        int[] ints = new int[26];
        for(char c: s.toCharArray()) {
            ints[c-'a']++;
        }
        char res = 'a';
        for(char c: t.toCharArray()) {
            int index = c-'a';
            if (ints[index] == 0) {
                res = c;
                break;
            } else {
                ints[index]--;
            }
        }
        return res;
    }
}