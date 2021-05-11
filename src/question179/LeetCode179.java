package src.question179;

/**
 * 179. 最大数
 *
 * @Description:
 * @Author: YFAN
 * @Date: 2021/5/11/011
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 * 输入：nums = [10]
 * 输出："10"
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
public class LeetCode179 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestNumber(new int[]{20, 2,3,31,32,320,3111}));

        System.out.println(solution.compareTo("12","123"));
    }
}

/**
 * 执行用时：
 * 28 ms
 * , 在所有 Java 提交中击败了
 * 5.23%
 * 的用户
 * 内存消耗：
 * 38.4 MB
 * , 在所有 Java 提交中击败了
 * 13.30%
 * 的用户
 */
class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (compareTo(nums[i] + "", nums[j] + "") < 0) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
            builder.append(nums[i]);
        }
        String resultStr = builder.toString();
        if (resultStr.length() > 0 && resultStr.charAt(0) == '0') {
            return "0";
        }
        return resultStr;
    }
    public int compareTo(String str1, String str2) {
        return (str1 + str2).compareTo(str2 + str1);
    }
}