package src.question153;

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 * @Description:
 * @Author: YFAN
 * @Date: 2021/5/15/015
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 * 例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 示例 1：
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
 * 示例 3：
 * 输入：nums = [11,13,15,17]
 * 输出：11
 * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
 * 提示：
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数 互不相同
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 */
public class LeetCode153 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.findMin(array));
    }
}

class Solution {
    /**
     * 二分查找
     * 4,5,6,7,0,1,2
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            // 中间
            int pivot = low + (high - low) / 2;
            // 每次循环中间数小于高边界数，则最小值在low - pivot间，反之最小值在pivot - high。
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }
}

/**
 * 执行用时：
 * 0 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 * 内存消耗：
 * 37.8 MB
 * , 在所有 Java 提交中击败了
 * 83.34%
 * 的用户
 */
class Solution2 {
    /**
     * 二分查找
     * <p>
     * 4,5,6,7,0,1,2   4 2 7  4<7 4>2 头在数组后部
     * 0,1,2,4,5,6,7   0 4 7  0<7 4<7 头在数组前部
     * 1,2,4,5,6,7,0   1 5 0  1>0 5>0 头在数组后部
     * 7 0,1,2,4,5,6   7 2 6  7>6 2<6 头在数组前部
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums.length == 2) {
            return nums[0] < nums[1] ? nums[0] : nums[1];
        }
        int len = nums.length / 2;
        if (nums[0] < nums[len] && nums[len] > nums[nums.length - 1]) {
            return fun(nums, len, nums.length - 1);
        } else if (nums[0] < nums[len] && nums[len] < nums[nums.length - 1]) {
            return fun(nums, 0, len);
        } else if (nums[0] > nums[len] && nums[len] > nums[nums.length - 1]) {
            return fun(nums, len, nums.length - 1);
        } else if (nums[0] > nums[len] && nums[len] < nums[nums.length - 1]) {
            return fun(nums, 0, len);
        }
        return nums[0];
    }

    private int fun(int[] nums, int i, int j) {
        int head = nums[i];
        for (i = i + 1; i <= j; i++) {
            if (head > nums[i]) {
                return nums[i];
            }
        }
        return head;
    }
}
