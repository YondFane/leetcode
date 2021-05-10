package src.question90;

import java.util.*;

/**
 * 90. 子集 II
 *
 * @Description:
 * @Author: YFAN
 * @Date: 2021/5/10/010
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class LeetCode90 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (List<Integer> list : solution.subsetsWithDup(new int[]{4, 4, 4, 1, 4})) {
            System.out.println(list.toString());
        }
    }
}
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        fun(result,list,nums,0,false);
        return result;
    }

    /**
     *
     * @param result
     * @param list
     * @param nums
     * @param i 索引
     * @param addPreNum 是否添加上一个元素
     */
    public void fun(List<List<Integer>> result, List<Integer> list, int[] nums, int i,boolean addPreNum) {
        // 数组越界
        if (i == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        fun(result,list,nums,i+1,false);
        // 剪枝 上一个元素没添加 && 当前元素等于上一个元素时
        if(!addPreNum && i > 0 && nums[i] == nums[i-1]) {
            return;
        }
        list.add(nums[i]);
        fun(result,list,nums,i+1,true);
        list.remove(list.size() - 1);
    }
}
/**
 * 执行用时：
 * 4 ms
 * , 在所有 Java 提交中击败了
 * 19.80%
 * 的用户
 * 内存消耗：
 * 38.8 MB
 * , 在所有 Java 提交中击败了
 * 42.07%
 * 的用户
 */
class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        // 子集个数 0 - nums.length
        for (int i = 0; i <= nums.length; i++) {
            fun(result, list, i, nums, 0);
        }

        return new ArrayList<>(result);
    }

    public void fun(Set<List<Integer>> result, List<Integer> list, int size, int[] nums, int i) {
        // 剪枝
        if (list.size() + nums.length - i < size) {
            return;
        }
        if (list.size() == size) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        fun(result, list, size, nums, i + 1);
        list.remove(list.size() - 1);
        fun(result, list, size, nums, i + 1);
    }
}
