package src.question234;

import java.util.ArrayList;
import java.util.List;

/**
 234. 回文链表
 简单
 相关标签
 相关企业
 给你一个单链表的头节点 head ，请你判断该链表是否为
 回文链表
 。如果是，返回 true ；否则，返回 false 。

 示例 1：

 输入：head = [1,2,2,1]
 输出：true
 示例 2：

 输入：head = [1,2]
 输出：false

 提示：

 链表中节点数目在范围[1, 105] 内
 0 <= Node.val <= 9

 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class LeetCode234 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
//        root.next.next.next = new ListNode(1);

        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(root));
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

class Solution {
    public boolean isPalindrome(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        int size = listNodes.size();
        int mid = size / 2;
        for (int i = 0; i < mid; i++) {
            ListNode l1 = listNodes.get(i);
            ListNode l2 = listNodes.get(size - i - 1);
            if (l1.val != l2.val) {
                return false;
            }
        }
        return true;
    }
}


/**
 * 优解
 */
class Solution2 {
    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode n1 = null;//新链表的头
        ListNode o1 = head;//旧头
        while(p2 != null && p2.next != null){
            p1 = p1.next;//即o2
            p2 = p2.next.next;
            //反转链表
            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }

        if(p2 != null){
            p1 = p1.next;
        }
        while(n1 != null){
            if(n1.val != p1.val){
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }
}


/**
 *
 作者：力扣官方题解
 链接：https://leetcode.cn/problems/palindrome-linked-list/solutions/457059/hui-wen-lian-biao-by-leetcode-solution/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution3 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}


/**
 * 递归解法
 */
class Solution4 {
    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
}
