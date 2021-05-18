package src.question136;

/** 136. 只出现一次的数字
* @Description:
* @Author: YFAN
* @Date: 2021/5/18/018
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
*/
public class LeetCode136 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{1,1,2,2,3}));
    }
}
class Solution {
    /**
     * 任何数异或0等于它本身
     * 任何数异或它本身等于0
     * 利用异或的特点将数组元素依个异或
     * 最后的结果就是只在数组中出现了一次的元素
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num : nums) {
            result ^= num;
        }
        return result;
    }
}
