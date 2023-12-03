package src.question506;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 506. 相对名次
 *
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 *
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 *
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 *
 * 示例 1：
 *
 * 输入：score = [5,4,3,2,1]
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
 * 示例 2：
 *
 * 输入：score = [10,3,8,9,4]
 * 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * 解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
 *
 * 提示：
 *
 * n == score.length
 * 1 <= n <= 104
 * 0 <= score[i] <= 106
 * score 中的所有值 互不相同
 */
public class LeetCode506 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Solution().findRelativeRanks(new int[]{1, 5, 6, 2, 4, 7, 9})));

    }
}

class Solution {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, String> map = new HashMap<>();
        Integer[] copyScore = new Integer[score.length];
        int index = 0;
        for (int i : score) {
            copyScore[index++] = i;
        }
        String[] result = new String[score.length];
        Arrays.sort(copyScore, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });
        index = 1;
        for (int num : copyScore) {
            String sortStr = index + "";
            if (index == 1) {
                sortStr = "Gold Medal";
            } else if (index == 2) {
                sortStr = "Silver Medal";
            } else if (index == 3) {
                sortStr = "Bronze Medal";
            }
            map.put(num, sortStr);
            index++;
        }
        index = 0;
        for (int num : score) {
            result[index++] = map.get(num);
        }
        return result;
    }
}


/**
 * 优秀题解
 */
class Solution2 {
    public String[] findRelativeRanks(int[] score) {
        String [] res = new String[score.length];
        int max = 0;
        // 找出最大值
        for (int i = 0; i < score.length; i++) {
            if(score[i] > max ){
                max = score[i];
            }
        }
        // 创建一个最大值+1的数组
        int [] map = new int[max+1];
        // map数组赋值
        for(int i =0;i<score.length;i++){
            // i+1 跟初始值区分开来 0为未使用位置
            map[score[i]] = i+1;
        }
        // 排序使用
        int count = 1;
        // 从大到小循环
        for(int j=map.length-1; j>=0;j--){
            // 不为0
            if(map[j] != 0){
                switch (count){
                    case 1:res[map[j] - 1] = "Gold Medal";break;
                    case 2:res[map[j] - 1] = "Silver Medal";break;
                    case 3:res[map[j] - 1] = "Bronze Medal";break;
                    default:res[map[j] - 1] = String.valueOf(count);
                }
                count++;
            }
        }

        return res;
    }
}