package LeetCode;

public class Add2NumLinkedList {
    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     */


    public static void main(String[] args) {
        ListNode l01 = new ListNode(3);
        ListNode l02 = new ListNode(4, l01);
        ListNode l1 = new ListNode(2, l02);

        ListNode l21 = new ListNode(4);
        ListNode l22 = new ListNode(6, l21);

        ListNode l2 = new ListNode(5, l22);

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(getNumber(l1));
        System.out.println(getNumber(l2));

        System.out.println(addTwoNumbers(l1,l2));

        int sum = getNumber(getReverseNode(l1)) + getNumber(getReverseNode(l2));
        System.out.println(sum);


    }
        public static int getNumber(ListNode node) {
        int num =0 ;
            do {
                num = num * 10 + node.val;
                node = node.next;
            } while(node != null);
            return num;
        }

    public static ListNode getReverseNode(ListNode node) {
        ListNode prev = null;
        ListNode next = null;

        while(node != null) {
         next = node.next;
         node.next = prev;
         prev = node;
         node = next;
        }
         return prev;
    }
    /*
        int num1 = 0 , num2 =0;

        int num = num1+ num2;
     */


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overflow = 0;

        ListNode result = new ListNode();
        ListNode current = result;

        while(l1 != null || l2 != null || overflow != 0){

            int sum = 0;

            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            sum += overflow;


            overflow = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        return result.next;
    }

    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
