package src.question164;

/**
 * 164. 最大间距
 *
 * @Description:
 * @Author: YFAN
 * @Date: 2021/5/11/011
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 * 示例 1:
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 说明:
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 */
public class LeetCode164 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumGap(new int[]{1, 3, 4, 1, 125, 6, 4, 7, 123, 123, 5}));
    }
}
class Solution {
    // 基数排序
    public int maximumGap(int[] nums) {
        int result = 0;
        //数组最大值的位数
        int len = ("" + queryArrayMax(nums)).length();
        sort(nums, len);
        for (int i = 1; i < nums.length; i++) {
            int fall = nums[i] - nums[i-1];
            result = result > fall ? result : fall;
        }
        return result;
    }

    public static void sort(int[] nums, int d) {
        //创建10个数组
        int[][] temp = new int[10][nums.length];
        //计数数组
        int[] order = new int[10];
        //数的分位
        int n = 1;
        //依据从低位到高位的余数添加进temp二维数组中
        while (d-- > 0) {
            for (int i = 0; i < nums.length; i++) {
                int remainder = (nums[i] / n) % 10;
                temp[remainder][order[remainder]] = nums[i];
                order[remainder]++;
            }
            int index = 0;
            //将桶子连接起来放进数组中
            for (int j = 0; j < order.length; j++) {
                if (order[j] > 0) {
                    for (int k = 0; k < order[j]; k++) {
                        nums[index++] = temp[j][k];
                    }
                }
                //置0
                order[j] = 0;
            }
            n *= 10;
        }
    }

    /**
     * 获取数组最大值
     *
     * @param nums
     * @return
     */
    public static int queryArrayMax(int[] nums) {
        int result = nums[0];
        for (int item : nums) {
            result = result > item ? result : item;
        }
        return result;
    }
}

class Solution1 {
    // 冒泡排序
    public int maximumGap(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            if (i != 0) {
                int t = nums[i] - nums[i - 1];
                result = result < t ? t : result;
            }
        }
        return result;
    }
}