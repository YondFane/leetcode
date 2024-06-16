package src.algorithmSorting.selectSort;

import java.util.Arrays;

/**
 * @Description 选择排序
 * 基本思想是:
 * 首先在未排序的数列中找到最小(or最大)元素，然后将其存放到数列的起始位置；
 * 接着，再从剩余未排序的元素中继续寻找最小(or最大)元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 *
 * 时间复杂度 O(n^2)
 * 算法稳定
 * @Author YFAN
 * @Date 2021/6/4
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 1, 1, 1, 3, 4, 5, -1};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            // 每趟找出数组中剩余未排序中最小元素的下标
            for (int j = i; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            // 交换 将每趟最小值放到当前数组序列起始位置
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
