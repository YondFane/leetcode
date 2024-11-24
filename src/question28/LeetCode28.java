package src.question28;

/**实现strStr
 * @Author YFAN
 * @Description
 * @Date 22:39 2020/7/10/010
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 **/
public class LeetCode28 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("123ddddd", "3dd"));
    }
}
//执行用时：
//1 ms
//, 在所有 Java 提交中击败了
//75.40%
//的用户
//内存消耗：
//39.7 MB
//, 在所有 Java 提交中击败了
//5.43%
//的用户
class Solution {
    public int strStr(String haystack, String needle) {
        // null或空字符串
        if (needle == null || needle.length() == 0) {
            return 0;
        } else if (needle.length() > haystack.length()){
            // needle长度大于haystack
            return -1;
        } else {
            int start = 0;
            int step = needle.length();
            int end = haystack.length();
            while (start + step <= end) {
                if (haystack.substring(start, start + step).equals(needle)) {
                    return start;
                }
                start++;
            }
            return -1;
        }
    }
}