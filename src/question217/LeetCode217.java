package src.question217;

import java.util.HashSet;

/*
 * 217. 存在重复元素
 * @author YFAN
 * @date 2021/9/20/020
给定一个整数数组，判断是否存在重复元素。
如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
示例 1:
输入: [1,2,3,1]
输出: true
示例 2:
输入: [1,2,3,4]
输出: false
示例 3:
输入: [1,1,1,3,3,4,3,2,4,2]
输出: true
 */
public class LeetCode217 {
    public static void main(String[] args) {

    }
}

class Solution {
    /*
     * 使用哈希表
     * @author YFAN
     * @date 2021/9/20/020
     * @param  * @param nums
     * @return boolean
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    /*
     * 使用哈希表 + 双指针
     * @author YFAN
     * @date 2021/9/20/020
     * @param  * @param nums
     * @return boolean
     */
    public boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        int j = nums.length - 1;
        for (; i <= j; i++, j--) {
            set.add(nums[i]);
            set.add(nums[j]);
        }
        return set.size() != nums.length;
    }
}