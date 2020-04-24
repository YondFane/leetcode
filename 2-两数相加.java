package 两数相加_2;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 **/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(0);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode root = solution.addTwoNumbers(l1, l2);

        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode temp = root;
        // 进位标识
        int flag = 0 ;

        // 判断l1、l2是否都不为空，都为空则结束循环
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                // 指向下一个
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                // 指向下一个
                l2 = l2.next;
            }
            // 两数之和 + 进位
            sum += flag;
            temp.next = new ListNode(sum%10);
            // 刷新进位
            flag = sum/10;
            // 指向下一个ListNode
            temp = temp.next;
        }
        // 判断进行标识是否为 1
        if (flag ==1) {
            temp.next = new ListNode(flag);
        }
        return root.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}