package src.question350;

import java.util.Arrays;

/*
 * 350. 两个数组的交集 II
 * @author YFAN
 * @date 2022/3/14/014
350. 两个数组的交集 II
给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
示例 2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]
提示：
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */
public class LeetCode350 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = solution.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        for (int num : array) {
            System.out.println(num);
        }
    }
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] array = new int[1001];
        for (int num : nums1) {
            array[num]++;
        }
        int i = 0;
        for (int j = 0; j < nums2.length; j++) {
            if (array[nums2[j]] > 0) {
                nums2[i++]= nums2[j];
                array[nums2[j]]--;
            }
        }
        return Arrays.copyOf(nums2, i);
    }
}