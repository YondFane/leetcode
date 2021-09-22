package src.question725;

/*
 * 725. 分隔链表
 * @author YFAN
 * @date 2021/9/22/022
给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
返回一个由上述 k 部分组成的数组。
示例 1：
输入：head = [1,2,3], k = 5
输出：[[1],[2],[3],[],[]]
解释：
第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
示例 2：
输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
输出：[[1,2,3,4],[5,6,7],[8,9,10]]
解释：
输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
提示：
链表中节点的数目在范围 [0, 1000]
0 <= Node.val <= 1000
1 <= k <= 50
 */
public class LeetCode725 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode tempListNode = listNode;
        for (int i = 1; i <= 10; i++) {
            tempListNode.val = i;
            if (i != 10) {
                tempListNode.next = new ListNode();
                tempListNode = tempListNode.next;
            }
        }
        ListNode[] listNodes = new Solution().splitListToParts2(listNode, 3);
        for (ListNode node : listNodes) {
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
            System.out.println();
        }
    }
}

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;// 链表长度
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        // 计算链表分成k份后每份多少个节点
        int part = size / k;
        // 多余的节点也计算出来
        int remainder = size % k;
        // 初始化数组
        ListNode[] listNodes = new ListNode[k];
        for (int i = 0; i < k; i++) {
            ListNode cur = new ListNode();
            ListNode tempListNode = cur;
            for (int j = 0; j < part; j++) {
                tempListNode.next = new ListNode(head.val);
                head = head.next;
                tempListNode = tempListNode.next;
            }
            if (remainder-- > 0) {
                tempListNode.next = new ListNode(head.val);
                head = head.next;
            }
            listNodes[i] = cur.next;
        }
        return listNodes;
    }

    /*
     * 空间复杂度优化
     * @author YFAN
     * @date 2021/9/22/022
     * @param  * @param head
     * @param k
     * @return src.question725.ListNode[]
     */
    public ListNode[] splitListToParts2(ListNode head, int k) {
        int size = 0;// 链表长度
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        // 计算链表分成k份后每份多少个节点
        int part = size / k;
        // 多余的节点也计算出来
        int remainder = size % k;
        // 初始化数组
        ListNode[] listNodes = new ListNode[k];
        ListNode tempHead = head;
        for (int i = 0; i < k && tempHead != null; i++) {
            listNodes[i] = tempHead;// 此处已经是第一个了 下面j初始为1
            int partSize = part + (remainder-- > 0 ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                tempHead = tempHead.next;
            }
            ListNode next = tempHead.next;
            tempHead.next = null;
            tempHead = next;
        }
        return listNodes;
    }
}