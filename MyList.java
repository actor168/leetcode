class MyList {

    private int LEN;
    
    private Node head;

    int length() {
        return LEN;
    }

    boolean insert(int value) {
        Node cur = new Node(value);
        cur.next = head;
        head = cur;
        LEN++;
        return true;
    }

    int delete(int pos) {
        if (LEN <= 0) {
            return -1;
        }

        if ( LEN < pos ) {
            return -1;
        }

        int cur = 0;
        Node cNode = head;
        while ( cur < LEN-pos) {
            cur++;
            cNode = cNode.next;
        }

        int value = cNode.next.value;
        cNode.next = cNode.next.next;

        return value;
    }

    int find(int value) {
        
        if (LEN <= 0) {
            return -1;
        }

        int cur = 0;
        Node cNode = head;
        while (cNode != null && cNode.value != value) {
            cNode = cNode.next;
            cur++;
        }
        return LEN - cur;
    }

    void merge(MyList list) {

    }

    MyList sort() {
        return null;
    }

    int min() {
        Node cNode = head;
        int min = cNode.value;
        while (cNode != null) {
            if (cNode.value < min) {
                min = cNode.value;
            }
            cNode = cNode.next;
        }
        return min;
    }

    int max() {
        Node cNode = head;
        int max = cNode.value;
        while (cNode != null) {
            if (cNode.value > max) {
                max = cNode.value;
            }
            cNode = cNode.next;
        }
        return max;
    }

    void traverseFrom(Node node) {
        if (node == null) {
            return;
        }
        traverseFrom(node.next);

        if (node.equals(head)) {
            System.out.print(node.value);
        }else{
            System.out.print(node.value + ",");
        }
    }

    void traverse() {
        traverseFrom(head);
        // Node cNode = head;
        // while (cNode != null) {
        //     System.out.print(cNode.value + ",");
        //     cNode = cNode.next;
        // }
    }

    int pop() {
        return 0;
    }

    public static void main(String[] args) {
        MyList list = new MyList();
        list.insert(3);
        list.insert(4);
        list.insert(5);
        //list.traverse();

        int max = list.max();
        System.out.println(max);

        int min = list.min();
        System.out.println(min);

        int pos = list.find(5);
        System.out.println(pos);
    }

    private class Node {
        int value;
        Node next;
    
        public Node(int v) {
            this.value = v;
        }
    }
}

