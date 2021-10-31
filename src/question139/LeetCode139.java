package src.question139;

import java.util.HashSet;
import java.util.List;

/*
 * 139. 单词拆分
 * @author YFAN
 * @date 2021/10/31/031
给你一个字符串 s 和一个字符串列表 wordDict 作为字典，判定 s 是否可以由空格拆分为一个或多个在字典中出现的单词。
说明：拆分时可以重复使用字典中的单词。
示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：
输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
提示：
1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s 和 wordDict[i] 仅有小写英文字母组成
wordDict 中的所有字符串 互不相同
 */
public class LeetCode139 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        // dp[i]为true，说明字符串s 0-i根据空格拆分在字典中都存在单词
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // j-i在字典中存在单词
                if (dp[j] && set.contains(s.substring(j, i))) {
                    // 设置为true
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}