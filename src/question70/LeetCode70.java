package src.question70;

/*
 * 70. 爬楼梯
 * @author YFAN
 * @date 2021/9/21/021
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。
示例 1：
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
 */
public class LeetCode70 {
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(3));
    }
}
class Solution {
    /*
     * 斐波那契数变形
     * f1=1
     * f2=2
     * fn = f(n-1) +f(n-2)
     * @author YFAN
     * @date 2021/9/21/021
     * @param  * @param n
     * @return int
     */
    public int climbStairs(int n) {
        int result = 0;
        if (n == 1) {
            return 1;
        } else {
            int i = 1;// f1
            int j = 1;// f2
            int count = 1;
            while (count++ < n) {
                result = i + j;
                i = j;
                j = result;
            }
        }
        return result;
    }
}