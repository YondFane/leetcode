package src.algorithmSorting.insertSort;

import java.util.Arrays;

/**
 * @Description 插入排序
 * 基本思想是:
 * 把n个待排序的元素看成为一个有序表和一个无序表。
 * 开始时有序表中只包含1个元素，无序表中包含有n-1个元素，
 * 排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，
 * 使之成为新的有序表，重复n-1次可完成排序过程。
 *
 * 时间复杂度 O(n^2)
 * 算法稳定
 * @Author YFAN
 * @Date 2021/6/4

 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {1, 32, 55, 232311, 55, 123123, 12312, 58785, 77, 89, 0, 660, 1223, 124312, -1, 123, -123, 556, 82, 8,
                1, 32, 55, 11, 51235, 123123, 12312, 4455, 77, 89, 80, 707, 123, -12312, -1, 1243, 123, 556, 8232, 1238, 3,
                1, 32, 5445, 1188, -55, 123123, -12312, 55, 77, 89, 909, 130, 123, 12312, -1, 1123, 123, 556, 82, 8, 387};
        System.out.println(Arrays.toString(array));
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 1 从第一个元素开始，该元素可以认为已经被排序；
     * 2 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 3 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 4 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 5 将新元素插入到该位置后；
     * 重复步骤2~5。
     * @Description
     * @Author YFAN
     * @Date 2021/6/4
     * @params [array]
     */
    public static void insertionSort(int[] array) {
        int preIndex = 0;
        int curValue = 0;
        // 默认第一个已经排序
        for (int i = 1; i < array.length; i++) {
            curValue = array[i];
            preIndex = i - 1;
            // 已排序元素中小于等于当前元素的下标
            while (preIndex >= 0 && array[preIndex] > curValue) {
                // 元素往后移动
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            // 插入到适合位置中
            array[preIndex + 1] = curValue;
        }
    }
}
