package src.算法排序.希尔排序;

import java.util.Arrays;

/**
 * @Description 希尔排序
 * 基本思想是:
 * 对于n个待排序的数列，取一个小于n的整数gap(gap被称为步长)将待排序元素分成若干个组子序列，所有距离为gap的倍数的记录放在同一个组中；
 * 然后，对各组内的元素进行直接插入排序。 这一趟排序完成之后，每一个组的元素都是有序的。然后减小gap的值，并重复执行上述的分组和排序。
 * 重复这样的操作，当gap=1时，整个数列就是有序的。
 *
 * 时间复杂度是 O(n^(1.3-2))
 * 算法稳定
 * @Author YFAN
 * @Date 2021/6/8
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {1, 32, 55, 232311, 55, 123123, 12312, 58785, 77, 89, 0, 660, 1223, 124312, -1, 123, -123, 556, 82, 8,
                1, 32, 55, 11, 51235, 123123, 12312, 4455, 77, 89, 80, 707, 123, -12312, -1, 1243, 123, 556, 8232, 1238, 3,
                1, 32, 5445, 1188, -55, 123123, -12312, 55, 77, 89, 909, 130, 123, 12312, -1, 1123, 123, 556, 82, 8, 387};
        System.out.println(Arrays.toString(array));
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 希尔排序
     * <p>
     * 希尔排序是插入排序经过改进的一个更高效的版本
     * 也叫做缩小增量排序
     *
     * @param array
     */
    public static void shellSort(int[] array) {
        int len = array.length;
        // k为增量
        for (int k = len / 2; k > 0; k /= 2) {
            for (int i = k; i < len; i++) {
                int j = i;
                int curValue = array[i];
                // 已排序元素（k增量间隔）中小于等于当前元素的下标
                while (j - k >= 0 && array[j - k] > curValue) {
                    // 元素往后移动（k增量间隔向后移动）
                    array[j] = array[j - k];
                    j -= k;
                }
                // 插入到适合位置中
                array[j] = curValue;
            }
        }
    }
}
