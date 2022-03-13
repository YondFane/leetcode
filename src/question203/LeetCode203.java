package src.question203;

import java.util.List;

/*
 * 203. 移除链表元素
 * @author YFAN
 * @date 2022/3/13/013
203. 移除链表元素
给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
示例 1：
输入：head = [1,2,6,3,4,5,6], val = 6
输出：[1,2,3,4,5]
示例 2：
输入：head = [], val = 1
输出：[]
示例 3：
输入：head = [7,7,7,7], val = 7
输出：[]
提示：
列表中的节点数目在范围 [0, 104] 内
1 <= Node.val <= 50
0 <= val <= 50
 */
public class LeetCode203 {
    public static void main(String[] args) {

    }
}


class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 创建新ListNode
        ListNode newHead = new ListNode(-1);
        ListNode headTemp = head;
        ListNode newHeadTemp = newHead;
        while (headTemp!=null) {
            if (headTemp.val != val) {
                // 将不等于val的ListNode连接到newHead上
                newHeadTemp.next = new ListNode(headTemp.val);
                newHeadTemp = newHeadTemp.next;
            }
            headTemp = headTemp.next;
        }
        return newHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}