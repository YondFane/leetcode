package src.question2680;

/**
 2680. 最大或值
 中等
 提示
 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k 。每一次操作中，你可以选择一个数并将它乘 2 。

 你最多可以进行 k 次操作，请你返回 nums[0] | nums[1] | ... | nums[n - 1] 的最大值。

 a | b 表示两个整数 a 和 b 的 按位或 运算。

 示例 1：

 输入：nums = [12,9], k = 1
 输出：30
 解释：如果我们对下标为 1 的元素进行操作，新的数组为 [12,18] 。此时得到最优答案为 12 和 18 的按位或运算的结果，也就是 30 。
 示例 2：

 输入：nums = [8,1,2], k = 2
 输出：35
 解释：如果我们对下标 0 处的元素进行操作，得到新数组 [32,1,2] 。此时得到最优答案为 32|1|2 = 35 。

 提示：

 1 <= nums.length <= 105
 1 <= nums[i] <= 109
 1 <= k <= 15
 */
public class LeetCode2680 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maximumOr(new int[]{12,9}, 1));

        System.out.println(solution.maximumOr(new int[]{12,9}, 1));
    }
}
class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        long[] suf = new long[n + 1];
        for(int i = n - 1; i >=0; i--) {
            // 计算后面数字或的值
            suf[i] = suf[i+1] | nums[i];
        }
        // 最大值结果
        long res = 0;
        // 前面数字或的值
        long pre = 0;
        for(int i = 0; i < n; i++){
            res = Math.max(res, pre | ((long)nums[i] << k) | suf[i + 1]);
            pre = pre | nums[i];
        }
        return res;
    }
}