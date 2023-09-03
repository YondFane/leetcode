package src.算法排序.基数排序;

import java.util.Arrays;

/**
 * @Description 基数排序
 * 基本思想是:
 * 将整数按位数切割成不同的数字，然后按每个位数分别比较。
 * 具体做法是: 将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。
 * 然后，从最低位开始，依次进行一次排序。
 * 这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
 *
 * 时间复杂度 O(n+k）
 * 算法稳定
 * @Author YFAN
 * @Date 2021/6/4
)
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] array = {1, 32, 55, 232311, 55, 123123, 12312, 58785, 77, 89, 0, 660, 1223, 124312, -1, 123, -123, 556, 82, 8,
                1, 32, 55, 11, 51235, 123123, 12312, 4455, 77, 89, 80, 707, 123, -12312, -1, 1243, 123, 556, 8232, 1238, 3,
                1, 32, 5445, 1188, -55, 123123, -12312, 55, 77, 89, 909, 130, 123, 12312, -1, 1123, 123, 556, 82, 8, 387};
        long start = System.currentTimeMillis();
        System.out.println("排序前：" + Arrays.toString(array));
        int max = queryArrayMax(array);
        //最大值是几位数
        int len = (max + "").length();
        sort(array, len);
        System.out.println("排序后：" + Arrays.toString(array));
        long takeTime = System.currentTimeMillis() - start;
        System.out.println("用时：" + takeTime);
    }

    /**
     * 基数排序 （桶排序）
     * 创建20个桶子 （如果不考虑负数直接使用10个桶子）
     * 2-10桶子 装余数-1到-9的数 (1号桶子不用)
     * 11-20 装余数0-9的数
     *
     * @param nums
     * @param d
     */
    public static void sort(int[] nums, int d) {
        //创建20个数组 1-10负数 11-20整数
        int[][] temp = new int[20][nums.length];
        //计数数组
        int[] order = new int[20];
        //
        int n = 1;
        //依据从低位到高位的余数添加进temp二维数组中
        while (d-- > 0) {
            for (int i = 0; i < nums.length; i++) {
                int remainder = (nums[i] / n) % 10;
                //负数进1-10数组 正数进11-20数组
                remainder = remainder < 0 ? -remainder : remainder + 10;
                temp[remainder][order[remainder]] = nums[i];
                order[remainder]++;
            }
            int index = 0;
            //将桶子连接起来放进数组中
            for (int j = 0; j < order.length; j++) {
                if (order[j] > 0) {
                    for (int k = 0; k < order[j]; k++) {
                        nums[index++] = temp[j][k];
                    }
                }
                //置0
                order[j] = 0;
            }
            n *= 10;
        }
    }

    /**
     * 获取数组最大值
     *
     * @param nums
     * @return
     */
    public static int queryArrayMax(int[] nums) {
        int result = nums[0];
        for (int item : nums) {
            result = result > item ? result : item;
        }
        return result;
    }
}
