package src.question97;

import java.util.Arrays;

/*
 * 977. 有序数组的平方
 * @author YFAN
 * @date 2021/9/21/021
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
示例 1：
输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]
示例 2：
输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]
提示：
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 已按 非递减顺序 排序
进阶：
请你设计时间复杂度为 O(n) 的算法解决本问题
 */
public class LeetCode97 {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] ints = new Solution().sortedSquares(nums);
        System.out.println(Arrays.toString(ints));
        int[] ints2 = new Solution().sortedSquares2(nums);
        System.out.println(Arrays.toString(ints2));
    }
}

class Solution {
    /*
     * 双指针
     * @author YFAN
     * @date 2021/9/21/021
     * @param  * @param nums
     * @return int[]
     */
    public int[] sortedSquares(int[] nums) {
        int[] array = new int[nums.length];
        int flagIndex = -1;// 负数和正数的界点
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                flagIndex = i;
            } else {
                break;
            }
        }
        int index = 0;
        int left = flagIndex;
        int right = flagIndex + 1;
        while (left >= 0 || right < nums.length) {
            if (left < 0) {
                array[index] = nums[right] * nums[right];
                right++;
            } else if (right == nums.length) {
                array[index] = nums[left] * nums[left];
                left--;
            } else if (nums[left] * nums[left] < nums[right] * nums[right]) {
                array[index] = nums[left] * nums[left];
                left--;
            } else {
                array[index] = nums[right] * nums[right];
                right++;
            }
            index++;
        }
        return array;
    }

    /*
     * 双指针
     * @author YFAN
     * @date 2021/9/21/021
     * @param  * @param nums
     * @return int[]
     */
    public int[] sortedSquares2(int[] nums) {
        int[] array = new int[nums.length];
        int i = 0;
        int j = nums.length -1;
        int index = nums.length -1;
        while (i <= j) {
            int a = nums[i] * nums[i];
            int b = nums[j] * nums[j];
            if (a < b) {
                array[index] = b;
                j--;
            } else {
                array[index] = a;
                i++;
            }
            index--;
        }
        return array;
    }
}