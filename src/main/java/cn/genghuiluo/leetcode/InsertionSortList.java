package cn.genghuiluo.leetcode;

/*
* https://leetcode.com/problems/insertion-sort-list/
*
* */

public class InsertionSortList {

    public static void main (String[] args) {
        ListNode a1 = new ListNode(6);
        ListNode a2 = new ListNode(5);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(8);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        System.out.println("befor: " + a1.toString());

        InsertionSortList isl = new InsertionSortList();
        System.out.println("after: " + isl.insertionSortList(a1).toString());
    }

    ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode node = head;

        while (node != null) {
            ListNode prev = dummy;
            ListNode next = node.next;

            while (prev.next != null && node.val > prev.next.val) {
                prev = prev.next;
            }

            node.next = prev.next;
            prev.next = node;
            node = next;
        }

        return dummy.next;
    }
}

class ListNode {

    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.valueOf(val));

        ListNode node = next;
        while (node != null) {
            s.append(" => ").append(String.valueOf(node.val));
            node = node.next;
        }
        return s.toString();
    }

}

