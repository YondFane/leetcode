package src.question26;

/**删除排序数组中的重复项
 * @Author YFAN
 * @Description
 * @Date 22:33 2020/7/8/008
 * <p>
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 **/
public class LeetCode26 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[]{8, 8, 8, 8, 8, 8}));
    }
}
/*
执行结果：
通过
显示详情
执行用时：
1 ms
, 在所有 Java 提交中击败了
97.99%
的用户
内存消耗：
41.6 MB
, 在所有 Java 提交中击败了
5.74%
的用户
 **/
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums[0] == nums[nums.length - 1]) {
            // 数组内全是一样的数字
            return 1;
        } else {
            int count = 0;//记录不重复元素个数
            int index = 0;//记录位置
            int t = nums[nums.length - 1];
            for (int i = 0; i < nums.length; i++) {
                // 判断是否相等
                if (t != nums[i]) {
                    nums[index++] = nums[i];
                    t = nums[i];
                    count++;
                }
            }
            return count;
        }
    }
}