public class Main002 {
    public static void main(String[] args){ 
        new Main002().fun();
    }
    
    public void fun(){
        ListNode t = new ListNode(5);
        
        ListNode t1 = new ListNode(5);
       
        ListNode res = addTwoNumbers(t,t1);
        ListNode tt = res;
        while (tt!= null){
            System.out.println(tt.val);
            tt = tt.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmpNode1 = l1;
        ListNode tmpNode2 = l2;
        ListNode t = null;
        int inc = 0;
        ListNode tmp = new ListNode(-1);
        ListNode res = tmp;
        while (tmpNode1 != null && tmpNode2 != null){
            t = new ListNode(inc);
            int val = tmpNode1.val + tmpNode2.val + t.val;
            if (val<10){
                t.val = val;
                inc = 0;
            }else {
                t.val = val%10;
                inc = val/10;
            }
            tmp.next = t;
            tmp = tmp.next;
            
            tmpNode1 = tmpNode1.next;
            tmpNode2 = tmpNode2.next;
        }
        while (tmpNode1 != null){
            t = new ListNode(inc);
            int val = tmpNode1.val + t.val;
            if (val<10){
                t.val = val;
                inc = 0;
            }else {
                t.val = val%10;
                inc = val/10;
            }

            tmp.next = t;
            tmp = tmp.next;
            tmpNode1 = tmpNode1.next;
        }

        while (tmpNode2 != null){
            t = new ListNode(inc);
            int val = tmpNode2.val + t.val;
            if (val<10){
                t.val = val;
                inc = 0;
            }else {
                t.val = val%10;
                inc = val/10;
            }
            tmp.next = t;
            tmp = tmp.next;
            tmpNode2 = tmpNode2.next;
        }
        
        if (inc != 0){
            tmp.next = new ListNode(inc);
        }
        return res.next;
    }
    
    
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
