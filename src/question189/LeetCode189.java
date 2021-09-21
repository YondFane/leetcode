package src.question189;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

/*
 * 189. 旋转数组
 * @author YFAN
 * @date 2021/9/21/021
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
进阶：
尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
示例 1:
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:
输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
提示：
1 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 */
public class LeetCode189 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        new Solution2().rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution {
    /*
     * 使用额外空间
     * @author YFAN
     * @date 2021/9/21/021
     * @param  * @param nums
     * @param k
     * @return void
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (length == 0 || k == 0) {
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        k = k % length;
        int count = k;
        // 找出需要移动的元素
        for (int i = length - 1; count > 0; i--, count--) {
            list.add(0, nums[i]);
        }
        // 移动数组元素
        int right = length - 1;
        for (int j = length - k - 1; j >= 0; j--) {
            nums[right--] = nums[j];
        }
        int left = 0;
        for (Integer integer : list) {
            nums[left++] = integer;
        }
    }
}

class Solution2 {
    /*
     * 数据翻转
     * @author YFAN
     * @date 2021/9/21/021
     * @param  * @param nums
     * @param k
     * @return void
     *
     * 1 2 3 4 5  2 result  4 5 1 2 3
     * 第一步全部翻转 5 4 3 2 1
     * 第二步左边翻转 4 5 3 2 1
     * 第三步右边翻转 4 5 1 2 3
     *
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (length == 0 || k == 0) {
            return;
        }
        k = k % length;
        System.out.println(k);
        ratate(nums, 0, length - 1);
        ratate(nums, 0, k - 1);
        ratate(nums, k, length - 1);
    }

    public void ratate(int[] nums, int i, int j) {
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }
}
