package src.question4;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;

/**寻找两个有序数组的中位数
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * <p>
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 **/
public class LeetCode4 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3,4,10,11,23}, new int[]{3}));
    }
}
// 100%
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int len = n + m;

        // 如果两个数组长度为偶数则中位数为中间两个数除于2，长度为奇数中位数为中间数
        if (len % 2 == 0) {
            // 找出中间两个数后直接退出，不进行非必要的循环
            double result = 0;
            int index = len / 2 - 1;
            int j1 = 0;
            int j2 = 0;
            for (int i = 0; i < len; i++) {
                if (j1 < n && j2 < m) {
                    if (nums1[j1] < nums2[j2]) {
                        if (i == index) {
                            result += nums1[j1++];
                            index++;
                        } else {
                            j1++;
                        }
                    } else {
                        if (i == index) {
                            result += nums2[j2++];
                            index++;
                        } else {
                            j2++;
                        }
                    }
                } else {
                    if (j1 < n) {
                        if (i == index) {
                            result += nums1[j1++];
                            index++;
                        } else {
                            j1++;
                        }
                    }
                    if (j2 < m) {
                        if (i == index) {
                            result += nums2[j2++];
                            index++;
                        } else {
                            j2++;
                        }
                    }
                }
                if (index > len / 2) {
                    break;
                }
            }
            return result/2;
        } else {
            // 找出中间数退出，不进行非必要的循环
            double result = 0;
            int index = len / 2;
            int j1 = 0;
            int j2 = 0;
            for (int i = 0; i < len; i++) {
                if (j1 < n && j2 < m) {
                    if (nums1[j1] < nums2[j2]) {
                        if (i == index) {
                            result += nums1[j1++];
                            break;
                        } else {
                            j1++;
                        }
                    } else {
                        if (i == index) {
                            result += nums2[j2++];
                            break;
                        } else {
                            j2++;
                        }
                    }
                } else {
                    if (j1 < n) {
                        if (i == index) {
                            result += nums1[j1++];
                            break;
                        } else {
                            j1++;
                        }
                    }
                    if (j2 < m) {
                        if (i == index) {
                            result += nums2[j2++];
                            break;
                        } else {
                            j2++;
                        }
                    }
                }
            }
            return result;
        }
    }
}

// 75%
class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int len = n + m;
        ArrayList<Integer> list = new ArrayList<>();
        // nums2读取标志
        int j1 = 0;
        // nums1读取标志
        int j2 = 0;
        for (int i = 0; i < len; i++) {
            if (j1 < n && j2 < m) {
                if (nums1[j1] < nums2[j2]) {
                    list.add(nums1[j1++]);
                } else {
                    list.add(nums2[j2++]);
                }
            } else {
                if (j1 < n) {
                    list.add(nums1[j1++]);
                }
                if (j2 < m) {
                    list.add(nums2[j2++]);
                }
            }
        }
        // 如果两个数组长度为偶数则中位数为中间两个数除于2，长度为奇数中位数为中间数
        if (len % 2 == 0) {
            return (list.get(len / 2) + list.get(len / 2 - 1)) / 2.0;
        } else {
            return list.get(len / 2);
        }
    }
}