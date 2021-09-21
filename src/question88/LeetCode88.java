package src.question88;

import java.util.Arrays;

/*
 * 88. 合并两个有序数组
 * @author YFAN
 * @date 2021/9/21/021
给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
示例 1：
输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
解释：需要合并 [1,2,3] 和 [2,5,6] 。
合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
示例 2：
输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]
解释：需要合并 [1] 和 [] 。
合并结果是 [1] 。
示例 3：
输入：nums1 = [0], m = 0, nums2 = [1], n = 1
输出：[1]
解释：需要合并的数组是 [] 和 [1] 。
合并结果是 [1] 。
注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
提示：
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
 */
public class LeetCode88 {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        new Solution().merge(num1, num1.length - num2.length, num2, num2.length);
        System.out.println(Arrays.toString(num1));
    }
}

class Solution {
    /*
     * 逆向排序
     * nums1右边有未使用的空间
     * 那么就可以从右边开始进行倒序排序
     * 排序完后num1为递增序列
     * @author YFAN
     * @date 2021/9/21/021
     * @param  * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return void
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        for (int index = m + n - 1; index >= 0; index--) {
            if (left < 0) {
                nums1[index] = nums2[right];
                right--;
                continue;
            }
            if (right < 0) {
                nums1[index] = nums1[left];
                left--;
                continue;
            }
            if (nums1[left] > nums2[right]) {
                nums1[index] = nums1[left];
                left--;
            } else {
                nums1[index] = nums2[right];
                right--;
            }
        }
    }
}