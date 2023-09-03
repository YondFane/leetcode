package src.算法排序.冒泡排序;

import java.util.Arrays;

/**
 * @Description 冒泡排序
 * 遍历若干次要排序的数列，每次遍历时，都会从前往后依次的比较相邻两个数的大小；
 * 如果前者比后者大，则交换它们的位置。
 * 这样，一次遍历之后，最大的元素就在数列的末尾！
 * 采用相同的方法再次遍历时，第二大的元素就被排列在最大元素之前。
 * 重复此操作，直到整个数列都有序为止
 *
 * 时间复杂度 O(n^2)
 * 算法稳定
 * @Author YFAN
 * @Date 2021/6/4
 */
public class BubbleSort {
    public static void main(String[] args) {
        method1();
    }

    /**
     * 普通冒泡排序
     */
    private static void method1() {
        int[] array = {1, 32, 55, 232311, 55, 123123, 12312, 58785, 77, 89, 0, 660, 1223, 124312, -1, 123, -123, 556, 82, 8,
                1, 32, 55, 11, 51235, 123123, 12312, 4455, 77, 89, 80, 707, 123, -12312, -1, 1243, 123, 556, 8232, 1238, 3,
                1, 32, 5445, 1188, -55, 123123, -12312, 55, 77, 89, 909, 130, 123, 12312, -1, 1123, 123, 556, 82, 8, 387};
        long start = System.currentTimeMillis();
        System.out.println("排序前：" + Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("排序后：" + Arrays.toString(array));
        long takeTime = System.currentTimeMillis() - start;
        System.out.println("用时：" + takeTime);
    }
}
