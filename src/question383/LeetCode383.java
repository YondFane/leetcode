package src.question383;

public class LeetCode383 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.canConstruct("sdf", "sdjg"));
    }
}

class Solution2 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[52];
        for (char c : magazine.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                count[c - 'A']++;
            } else {
                count[c - 'a' + 26]++;
            }
        }
        for (char c : ransomNote.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                if (--count[c - 'A'] < 0) {
                    return false;
                }
            } else {
                if (--count[c - 'a' + 26] < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

/**
 * 优解
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dp = new int[26];
        for(char c : ransomNote.toCharArray()){
            int index = magazine.indexOf(c, dp[c - 'a']);
            if(index<0){
                return false;
            }
            // 记录出现位置
            dp[c - 'a'] = index+1;
        }
        return true;
    }
}