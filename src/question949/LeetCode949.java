package src.question949;

import java.util.Arrays;

/**
 * 949. 给定数字能组成的最大时间
 *
 * @Author YFAN
 * @Date 2021/12/29
 * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 * 24 小时格式为 "HH:MM" ，其中 HH 在 00 到 23 之间，MM 在 00 到 59 之间。
 * 最小的 24 小时制时间是 00:00 ，而最大的是 23:59 。从 00:00 （午夜）开始算起，过得越久，时间越大。
 * 以长度为 5 的字符串，按 "HH:MM" 格式返回答案。如果不能确定有效时间，则返回空字符串。
 * 示例 1：
 * 输入：arr = [1,2,3,4]
 * 输出："23:41"
 * 解释：有效的 24 小时制时间是 "12:34"，"12:43"，"13:24"，"13:42"，"14:23"，"14:32"，"21:34"，"21:43"，"23:14" 和 "23:41" 。
 * 这些时间中，"23:41" 是最大时间。
 * 示例 2：
 * 输入：arr = [5,5,5,5]
 * 输出：""
 * 解释：不存在有效的 24 小时制时间，因为 "55:55" 无效。
 * 示例 3：
 * 输入：arr = [0,0,0,0]
 * 输出："00:00"
 * 示例 4：
 * 输入：arr = [0,0,1,0]
 * 输出："10:00"
 * <p>
 * 提示：
 * arr.length == 4
 * 0 <= arr[i] <= 9
 */
public class LeetCode949 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestTimeFromDigits(new int[]{2, 0, 6, 6}));
    }
}

class Solution {
    public String largestTimeFromDigits(int[] arr) {
        // 排序
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            // 2x : xx
            if (arr[i] <= 2) {
                for (int j = len - 1; j >= 0; j--) {
                    if (i != j) {
                        for (int k = len - 1; k >= 0; k--) {
                            // xx : 5x
                            if (i != k && j != k && arr[k] <= 5) {
                                // 除去i j k剩下坐标
                                int l = 3 + 2 + 1 - i - j - k;
//                                if ((arr[i] * 10)+arr[j] < 24 && (arr[k] * 10) + arr[l] < 60) {
                                    // 分钟总值
                                    int senconds = (arr[i] * 60 * 10) + (arr[j] * 60) + (arr[k] * 10) + arr[l];
                                    // 一天最多1440分钟
                                    if (senconds < 1440) {
                                        return arr[i] + "" + arr[j] + ":" + arr[k] + "" + arr[l];
                                    }
//                                }
                            }
                        }
                    }
                }
            }
        }
        return "";
    }
}