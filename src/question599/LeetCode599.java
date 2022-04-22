package src.question599;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * 599. 两个列表的最小索引总和
 * @author YFAN
 * @date 2022/3/14/014
 * @param  * @param null
 * @return
599. 两个列表的最小索引总和
假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
示例 1:
输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
输出: ["Shogun"]
解释: 他们唯一共同喜爱的餐厅是“Shogun”。
示例 2:
输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
输出: ["Shogun"]
解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
提示:
1 <= list1.length, list2.length <= 1000
1 <= list1[i].length, list2[i].length <= 30
list1[i] 和 list2[i] 由空格 ' ' 和英文字母组成。
list1 的所有字符串都是 唯一 的。
list2 中的所有字符串都是 唯一 的。
 */
public class LeetCode599 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] restaurant = solution.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Burger King", "Tapioca Express", "Shogun"});
        for (String s : restaurant) {
            System.out.println(s);
        }
    }
}

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        ArrayList<String> stringList = new ArrayList<>();
        int indexNum = Integer.MAX_VALUE;
        for (int j = 0; j < list2.length && j <= indexNum; j++) {
            String str = list2[j];
            if (map.containsKey(str)) {
                if (map.get(str) + j < indexNum) {
                    stringList.clear();
                    stringList.add(str);
                    indexNum = map.get(str) + j;
                } else if (map.get(str) + j == indexNum) {
                    stringList.add(str);
                }
            }
        }
        return stringList.toArray(new String[stringList.size()]);
    }
}