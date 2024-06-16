package src.algorithmSorting.bucketSort;

/**
 * @Description: 桶排序
 *
 * https://www.pdai.tech/md/algorithm/alg-sort-x-bucket.html
 *
 * 平均时间复杂度: O(n + k)
 * 最佳时间复杂度: O(n + k)
 * 最差时间复杂度: O(n ^ 2)
 * 空间复杂度: O(n * k)
 *
 * 算法稳定
 * @Author: YFAN
 * @CreateTime: 2023-09-03 22:21
 * @Version: 1.0
 */
public class BucketSort {

    public static void main(String[] args) {
        int i;
        int a[] = {8,2,3,4,3,6,6,3,9};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        bucketSort(a, 10); // 桶排序

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }

    /*
     * 桶排序
     *
     * 参数说明:
     *     a -- 待排序数组
     *     max -- 数组a中最大值的范围
     */
    public static void bucketSort(int[] a, int max) {
        int[] buckets;

        if (a==null || max<1)
            return ;

        // 创建一个容量为max的数组buckets，并且将buckets中的所有数据都初始化为0。
        buckets = new int[max];

        // 1. 计数
        for(int i = 0; i < a.length; i++)
            buckets[a[i]]++;

        // 2. 排序
        for (int i = 0, j = 0; i < max; i++) {
            while( (buckets[i]--) >0 ) {
                a[j++] = i;
            }
        }

        buckets = null;
    }
}
