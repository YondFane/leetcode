package src.question1985;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 1985. 找出数组中的第 K 大整数
 中等
 相关标签
 相关企业
 提示
 给你一个字符串数组 nums 和一个整数 k 。nums 中的每个字符串都表示一个不含前导零的整数。

 返回 nums 中表示第 k 大整数的字符串。

 注意：重复的数字在统计时会视为不同元素考虑。例如，如果 nums 是 ["1","2","2"]，那么 "2" 是最大的整数，"2" 是第二大的整数，"1" 是第三大的整数。

 示例 1：

 输入：nums = ["3","6","7","10"], k = 4
 输出："3"
 解释：
 nums 中的数字按非递减顺序排列为 ["3","6","7","10"]
 其中第 4 大整数是 "3"
 示例 2：

 输入：nums = ["2","21","12","1"], k = 3
 输出："2"
 解释：
 nums 中的数字按非递减顺序排列为 ["1","2","12","21"]
 其中第 3 大整数是 "2"
 示例 3：

 输入：nums = ["0","0"], k = 2
 输出："0"
 解释：
 nums 中的数字按非递减顺序排列为 ["0","0"]
 其中第 2 大整数是 "0"


 提示：

 1 <= k <= nums.length <= 104
 1 <= nums[i].length <= 100
 nums[i] 仅由数字组成
 nums[i] 不含任何前导零
 */
public class LeetCode1985 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.kthLargestNumber(new String[]{"123123","1234","2","21","12","1", "123", "131", "124124"}, 3));

        Solution2 solution2 = new Solution2();

        System.out.println(solution2.kthLargestNumber(new String[]{"123123","1234","2","21","12","1", "123", "131", "124124"}, 3));

    }

}

class Solution {

    public String kthLargestNumber(String[] nums, int k) {

        List<String> list = Arrays.stream(nums).sorted((a, b) -> {
            if (a.length() == b.length()) {
                return b.compareTo(a);
            }
            return a.length() > b.length() ? -1 : 1;
        }).collect(Collectors.toList());
        return list.get(k - 1);
    }

}

class Solution2 {

    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        return nums[nums.length - k];
    }

}