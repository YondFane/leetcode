package src.question66;

import java.util.Arrays;

/** 66. 加一

 * @Author: YFAN
* @Date: 2021/5/9/009
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
*/
public class LeetCode66 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = solution.plusOne(new int[]{9,9,9,9,9});
        System.out.println(Arrays.toString(array));
    }
}
class Solution {
    public int[] plusOne(int[] digits) {
        // 进位
        boolean flag = false;
        int len = digits.length;
        if(digits[len - 1] < 9) {
            digits[len - 1]++;
            return digits;
        } else {
            flag = true;
            digits[len - 1] = 0;
            for(int i = len - 2; i >= 0; i--) {
                if(digits[i] + 1 <= 9) {
                    digits[i]++;
                    flag = false;
                    return digits;
                } else {
                    flag = true;
                    digits[i] = 0;
                }
            }
            if (flag) {
                int[] array = new int[len + 1];
                array[0] = 1;
                for(int i = 0;i<len;i++) {
                    array[i+1] = digits[i];
                }
                return array;
            }
        }
        return digits;
    }
}