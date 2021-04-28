package src.question27;
/**移除元素
 * @Author YFAN
 * @Description
 * @Date 22:59 2020/7/9/009
 *  给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 **/
public class LeetCode27 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{3,2,2,3,5,6,7,3,3,3,3,445};
        int i = solution.removeElement(array, 3);
        for(int j = 0; j < i; j++) {
            System.out.print(array[j] + " ");
        }
    }
}
/*
执行结果：
通过
显示详情
执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
38.5 MB
, 在所有 Java 提交中击败了
5.68%
的用户
 **/
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int count = 0;
            int index = nums.length-1;
            for(int i = 0; i <= index; i++) {
                if (nums[i] == val) {
                    nums[i] = nums[index--];
                    i--;
                } else {
                    count++;
                }
            }
            return count;
        }
    }
}


