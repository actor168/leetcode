public class Main002 {
    public static void main(String[] args){
        
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmpNode1 = l1;
        ListNode tmpNode2 = l2;
        ListNode res = new ListNode(0);;
        int inc = 0;
        ListNode tmp = res;
        while (tmpNode1 != null && tmpNode2 != null){
            int val = tmpNode1.val + tmpNode2.val + inc;
            if (val<10){
                tmp.val += val;
            }else {
                tmp.val += val%10;
                tmp.next = new ListNode(val/10);
                tmp = tmp.next;
            }
            
        }
        return null;
    }
    
    
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
