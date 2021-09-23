package src.question557;

/*
 * 557. 反转字符串中的单词 III
 * @author YFAN
 * @date 2021/9/23/023
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
示例：
输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"
提示：
在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class LeetCode557 {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords2("Let's take LeetCode contest"));
    }
}

class Solution {
    /*
     * test word abc  (reverse) cba drow tset
     * tset drow cba
     * @author YFAN
     * @date 2021/9/23/023
     * @param  * @param s
     * @return java.lang.String
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String str = sb.toString();
        String[] strings = str.split(" ");
        sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /*
     * test word abc
     * @author YFAN
     * @date 2021/9/23/023
     * @param  * @param s
     * @return java.lang.String
     */
    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int i = 0;
        while (i < len) {
            int j = i;
            //找出下一个单词
            while (i < len && s.charAt(i) != ' ') {
                i++;
            }
            // 将单词反插入StringBuilder中
            for (int k = i - 1; k >= j; k--) {
                sb.append(s.charAt(k));
            }
            // i如果不是s的长度则添加一个空格
            if (i++ != len) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}