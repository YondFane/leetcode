package src.question976;

/**
 * @Description 976. 三角形的最大周长
 * @Author YFAN
 * @Date 2021/6/3
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * 示例 1：
 * 输入：[2,1,2]
 * 输出：5
 * 示例 2：
 * 输入：[1,2,1]
 * 输出：0
 * 示例 3：
 * 输入：[3,2,3,4]
 * 输出：10
 * 示例 4：
 * 输入：[3,6,2,3]
 * 输出：8
 */
public class LeetCode976 {
    public static void main(String[] args) {
        System.out.println(new Solution().largestPerimeter(new int[]{3, 2, 3, 4}));
    }
}

class Solution {
    public int largestPerimeter(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
    /**
    * @Description 快速排序算法
    * @Author YFAN
    * @Date 2021/6/3
    * @params [nums, l, r]
    * @return void
    */
    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            //默认以nums[l]为第一个坑
            int x = nums[l];
            int i = l;
            int j = r;
            while (i < j) {
                //从右往左找小于等于x的元素
                while (i < j && nums[j] > x) {
                    j--;
                }
                if (i < j) {
                    //填坑 nums[j]为下一个坑点
                    nums[i] = nums[j];
                    i++;
                }
                //从左往右找大于x的元素
                while (i < j && nums[i] <= x) {
                    i++;
                }
                if (i < j) {
                    //填坑 nums[i]为下一个坑点
                    nums[j] = nums[i];
                    j--;
                }
            }
            //最后填坑
            nums[i] = x;
            //递归
            quickSort(nums, l, i - 1);
            quickSort(nums, i + 1, r);
        }
    }
}