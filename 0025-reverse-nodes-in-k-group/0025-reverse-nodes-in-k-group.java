class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        ListNode ptr = head;
        while(ptr != null){
            ListNode temp = ptr;
            int i = k;
            while(i-- > 0){
                temp = temp.next;

                if(temp == null){
                    return head.next;
                }
            }

            ListNode next = temp.next;

            temp.next = null;
            temp = ptr.next;
            ptr.next = null;

            ListNode prev = null, tail = temp;

            while(temp != null){
                ListNode nextNode = temp.next;
                temp.next = prev;
                prev = temp;
                temp = nextNode; 
            }

            ptr.next = prev;
            tail.next = next;
            ptr = tail;
            
        }

        return head.next;
    }
}