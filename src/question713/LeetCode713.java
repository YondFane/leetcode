package src.question713;

/*
 * 713. 乘积小于 K 的子数组
 * @author YFAN
 * @date 2022/5/5/005
给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
示例 1：
输入：nums = [10,5,2,6], k = 100
输出：8
解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
示例 2：
输入：nums = [1,2,3], k = 0
输出：0
提示:
1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106
 */
public class LeetCode713 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{10,5,2,6};
        System.out.println(solution.numSubarrayProductLessThanK(array, 100));
    }
}

// 官方结果https://leetcode-cn.com/problems/subarray-product-less-than-k/solution/cheng-ji-xiao-yu-k-de-zi-shu-zu-by-leetc-92wl/
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            /*
            如果一个子串的乘积小于k，那么他的每个子集都小于k，而一个长度为n的数组，他的所有连续子串数量是1+2+...n，但是会和前面的重复。
            比如例子中[10, 5, 2, 6]，第一个满足条件的子串是[10]，
            第二个满足的是[10, 5]，但是第二个数组的子集[10]和前面的已经重复了，
            因此我们只需要计算包含最右边的数字的子串数量，就不会重复了，也就是在计算[10, 5]这个数组的子串是，
            只加入[5]和[10, 5]，而不加入[10]，这部分的子串数量刚好是r - l + 1
             */
            ret += j - i + 1;
        }
        return ret;
    }
}


// Solution1的简版，但是时间复杂度还是太高
class Solution2 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int length = nums.length;
        for (int j = 0; j<length; j++) {
            int temp = 1;
            for (int i = j; i < length; i++) {
                temp *= nums[i];
                if(temp >= k){
                    break;
                }
                ans++;
            }
        }
        return ans;
    }
}

// 超时
class Solution1 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int width = 1;
        while (width <= nums.length) {
            for (int i = 0; i < nums.length && i + width - 1 < nums.length; i++) {
                long sum = nums[i];
                for (int j = 1; j < width; j++) {
                    sum *= nums[i + j];
                    if (sum >= k) {
                        break;
                    }
                }
                if (sum < k) {
                    res++;
                }
            }
            width++;
        }
        return res;
    }
}