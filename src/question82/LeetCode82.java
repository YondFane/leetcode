package src.question82;

import javax.print.DocFlavor;
import java.util.*;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: src.question82
 * @Author: YANF
 * @CreateTime: 2025-05-11  22:49
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode82 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(4);
        ListNode t = solution.deleteDuplicates(listNode);
        while (t != null) {
            System.out.println(t.val);
            t = t.next;
        }
    }
}

/**
 * 非优解
 */
class Solution2 {
    // 1 - 2 - 2 - 3
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);
            map.put(p.val, map.getOrDefault(p.val, 0) + 1);
            p = p.next;
        }
        ListNode q = new ListNode();
        ListNode t = q;
        for (ListNode listNode : list) {
            if (map.get(listNode.val) == 1) {
                q.next = listNode;
                q = q.next;
                q.next = null;
            }

        }
        return t.next;
    }
}
class Solution {
    // 1 - 2 - 2 - 3
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode q = new ListNode(0, head);
        ListNode p = q;
        while (p.next != null && p.next.next != null) {
            if (p.next.val != p.next.next.val) {
                p = p.next;
            } else {
                int x = p.next.val;
                while (p.next != null && p.next.val == x) {
                    p.next = p.next.next;
                }
            }
        }
        return q.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}