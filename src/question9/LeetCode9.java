package src.question9;

/**回文数
 * @Author YFAN
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:
输入: 121
输出: true

示例 2:
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3:
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

进阶:
你能不将整数转为字符串来解决这个问题吗？
 **/
public class LeetCode9 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(110011));
    }
}
// 9ms 99.25%
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            // 负数不是回文数
            return false;
        } else {
            long l = 0;
            int t= x;
            while (t > 0) {
                l *= 10;
                l += t%10;
                t /= 10;
            }
            if (l == x){
                return true;
            }else {
                return false;
            }
        }
    }
}