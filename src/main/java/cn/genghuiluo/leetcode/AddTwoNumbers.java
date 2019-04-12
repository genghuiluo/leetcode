package cn.genghuiluo.leetcode;

/*
*
* */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(6);
        ListNode a2 = new ListNode(5);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(8);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        System.out.println("8356: " + a1.toString());

        ListNode b1 = new ListNode(6);
        ListNode b2 = new ListNode(5);
        ListNode b3 = new ListNode(3);
        b1.next = b2;
        b2.next = b3;
        System.out.println("356: " + b1.toString());

        AddTwoNumbers atn = new AddTwoNumbers();
        System.out.println("sum shoud be 8712: " + atn.addTwoNumbers(a1,b1).toString());
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode p = l1;
        ListNode q = l2;
        int quo = 0;
        int rem = 0;
        ListNode r = head;

        while (p != null || q != null) {
            int sum = (p != null ? p.val : 0) + (q != null? q.val : 0);
            rem = (sum + quo) % 10;
            quo = (sum + quo) / 10;
            r.next = new ListNode(rem);
            r = r.next;

            if (p != null) {
                p = p.next;
            }

            if (q != null) {
                q = q.next;
            }
        }

        if ( quo > 0 ) {
            r.next = new ListNode(quo);
        }

        return head.next;

    }
}



