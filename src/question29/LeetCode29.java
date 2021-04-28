package src.question29;

import com.sun.javafx.image.IntPixelGetter;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

/**两数相除
 * @Author YFAN
 * @Description
 * @Date 23:00 2020/7/10/010
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
返回被除数 dividend 除以除数 divisor 得到的商。
整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

示例 1:
输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3

示例 2:
输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2

提示：
被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 **/
public class LeetCode29 {
    public static void main(String[] args) {
        int a = -2147483648;
        int b = -1;
        System.out.println(a/b);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-1*Integer.MAX_VALUE);
        //100 11
        //100 11*2 11*2*2 11*2*2*2 88 12  == 9
        //100 7*2 7*4 7*8 7*16 8 + 44
        //100 2*2 2*4 2*32 32 + 36 50
        //100 3*32 96 1 33 80
        Solution solution = new Solution();
        System.out.println(solution.divide(a, b));
        
    }
}

//执行用时：
//1 ms
//, 在所有 Java 提交中击败了
//100.00%
//的用户
//内存消耗：
//37.1 MB
//, 在所有 Java 提交中击败了
//7.69%
//的用户
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {return 0;}
        // 迎合过去的机器瓶颈
        if (dividend == Integer.MIN_VALUE && divisor == -1) {return Integer.MAX_VALUE;}
        // 判断正负
        boolean sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor <0);
        // 转为负数
        long _dividend  = dividend > 0 ? -dividend : dividend;
        long _divisor = divisor > 0 ? -divisor : divisor;
        // 结果
        long result = 0;
        // 循环调用fun方法进行左移
        while (_dividend <= _divisor) {
            long[] array = fun(_dividend, _divisor);
            result += array[0];
            _dividend-=array[1];
        }
        // 根据sign正负返回值
        if(sign) {
            return (int)result;
        } else {
            return -(int)result;
        }
    }
    /**
     循环对除数进行左移  divisor * 2^n
     @return  2^n 和 divisor * 2^n
     **/
    public long[] fun(long dividend, long divisor) {
        long result = 1;
        while (dividend <= divisor) {
            result<<=1;
            divisor<<=1;
        }
        result>>=1;
        divisor>>=1;
        return new long[]{result, divisor};
    }
}