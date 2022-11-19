package src.算法排序.选择排序;

import java.util.Arrays;

/**
 * @Description 选择排序
 * @Author YFAN
 * @Date 2021/6/4
 * 时间复杂度 O(n^2)
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
