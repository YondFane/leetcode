package src.question14;

/**最长公共前缀
 * @Author YFAN
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 **/
public class LeetCode14 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{}));
    }
}

// 1ms 80.6%
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int index = 0;
        boolean flag = true;
        while (flag) {
            char c = '0';
            for (int i = 0; i < strs.length; i++) {
                if (i == 0 && index < strs[i].length()){
                    c = strs[0].charAt(index);
                } else if (index < strs[i].length()) {
                    if (strs[i].charAt(index) != c) {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(c);
            }
            index++;
        }
        return sb.toString();
    }
}