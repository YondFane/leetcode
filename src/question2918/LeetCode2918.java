package src.question2918;

/**
 * 2918. 数组的最小相等和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个由正整数和 0 组成的数组 nums1 和 nums2 。
 * <p>
 * 你必须将两个数组中的 所有 0 替换为 严格 正整数，并且满足两个数组中所有元素的和 相等 。
 * <p>
 * 返回 最小 相等和 ，如果无法使两数组相等，则返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [3,2,0,1,0], nums2 = [6,5,0]
 * 输出：12
 * 解释：可以按下述方式替换数组中的 0 ：
 * - 用 2 和 4 替换 nums1 中的两个 0 。得到 nums1 = [3,2,2,1,4] 。
 * - 用 1 替换 nums2 中的一个 0 。得到 nums2 = [6,5,1] 。
 * 两个数组的元素和相等，都等于 12 。可以证明这是可以获得的最小相等和。
 * 示例 2：
 * <p>
 * 输入：nums1 = [2,0,2,0], nums2 = [1,4]
 * 输出：-1
 * 解释：无法使两个数组的和相等。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 105
 * 0 <= nums1[i], nums2[i] <= 106
 */
public class LeetCode2918 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSum(new int[]{3,2,0,1,0}, new int[]{6,5,0}));
    }
}

class Solution {
    /**
     * 统计数组中的数字0的数量
     * 对数组中的数字求和，将所有零换成 1
     * 判断不符合情况:
     * 例如 : nums1 数组不存在0的情况，且 nums1数组的求和 小于 nums2数组的求和，因为nums1数组没有0可以补充所以不符合条件
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, zero1 = 0;
        long sum2 = 0, zero2 = 0;

        for (int num : nums1) {
            sum1 += num;
            if (num == 0) {
                // 存在0的数字，默认填充1
                sum1++;
                zero1++;
            }
        }
        for (int num : nums2) {
            sum2 += num;
            if (num == 0) {
                // 存在0的数字，默认填充1
                sum2++;
                zero2++;
            }

        }
        if ((zero1 == 0 && sum2 > sum1) || (zero2 == 0 && sum1 > sum2)) {
            return -1;
        }
        return Math.max(sum1, sum2);
    }
}