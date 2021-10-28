package problems;

public class Day2_AddTwoSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remember = 0;
        int sum = l1.val + l2.val;

        if (sum >= 10) {
            remember = 1;
            sum = sum % 10;
        } else {
            remember = 0;
        }

        ListNode result = new ListNode(sum + remember);
        ListNode head = result;

        while (l1.next != null || l2.next != null) {
            int sum2 = 0;

            if (l1.next != null) {
                l1 = l1.next;
            }

            if (l2.next != null) {
                l2 = l2.next;
            }

            sum2 = l1.val;
            sum2 += l2.val;

            if (sum2 >= 10) {
                remember = 1;
                sum2 = sum2 % 10;
            } else {
                remember = 0;
            }

            ListNode newNode = head;
            newNode.next = new ListNode(sum2 + remember);
            head = newNode.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        return result;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
