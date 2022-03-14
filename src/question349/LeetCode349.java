package src.question349;

import java.util.Arrays;
import java.util.HashSet;

/*
 * 349. 两个数组的交集
 * @author YFAN
 * @date 2022/3/14/014
349. 两个数组的交集
给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
解释：[4,9] 也是可通过的
提示：
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */
public class LeetCode349 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = solution.intersection(new int[]{1,2,2,1}, new int[]{2,2});
        for(int num : array) {
            System.out.println(num);
        }
    }
}

// 数组计数 + 数组复制（Arrays.copyOf）
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] array = new int[1001];
        for(int i : nums1) {
            array[i]++;
        }
        int i = 0;
        int j = 0;
        while (j < nums2.length) {
            if (array[nums2[j]] > 0) {
                nums2[i++] = nums2[j];
                array[nums2[j]] = 0;//置0，避免重复计算
            }
            j++;
        }
        return Arrays.copyOf(nums2, i);
    }
}

// 数组计数+set去重
class Solution1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        int[] array = new int[1001];
        for(int i : nums1) {
            array[i]++;
        }
        for(int i : nums2) {
            if(array[i]!=0){
                set.add(i);
            }
        }
        int[] ans = new int[set.size()];
        int index = 0;
        for(Integer i : set) {
            ans[index++] = i;
        }
        return ans;
    }
}