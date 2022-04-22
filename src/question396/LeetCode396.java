package src.question396;

import java.util.Arrays;

/**
 *
 * @Author YFAN
 * @Date 2022/4/22
396. 旋转函数
给定一个长度为 n 的整数数组 nums 。
假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数  F 为：
F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
返回 F(0), F(1), ..., F(n-1)中的最大值 。
生成的测试用例让答案符合 32 位 整数。
示例 1:
输入: nums = [4,3,2,6]
输出: 26
解释:
F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
示例 2:
输入: nums = [100]
输出: 0
提示:
n == nums.length
1 <= n <= 105
-100 <= nums[i] <= 100
 */
public class LeetCode396 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxRotateFunction(new int[]{4,3,2,6}));
    }
}

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int cur = 0, sum = 0;

        // 一次遍历，求出数组总和，与没有翻转情况下函数的初始值
        for(int i = 0; i < n; i++) {
            cur += nums[i] * i;
            sum += nums[i];
        }

        int res = cur;

        // 遍历每一次的翻转情况，自然先是从末端开始翻转
        for(int i = n - 1; i > 0; i --) {
            // 增加总和
            cur += sum;
            // 减去n份的末尾值
            cur -= nums[i] * n;
            // 求最大值
            res = Math.max(cur, res);
        }

        return res;
    }
}
/**
 当 1≤k<n 时，F(k) = F(k−1) + numSum−n × nums[n−k]
 */
class Solution1 {
    public int maxRotateFunction(int[] nums) {
        int f = 0, n = nums.length, numSum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }
        int res = f;
        for (int i = n - 1; i > 0; i--) {
            f += numSum - n * nums[i];
            res = Math.max(res, f);
        }
        return res;
    }
}