class MyHashMap {

    /** Initialize your data structure here. */
    class Node {
        int key;
        int value;
        Node next;
    }

    private Node[] bucket;
    
    public MyHashMap() {
        bucket = new Node[10000];
    }

    private int hash(int key) {
        return key%10000;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hash(key);
        Node p = bucket[hash];
        
        Node q = new Node();
        q.key = key;
        q.value = value;
        q.next = null;

        if (p == null) {
            bucket[hash] = q;
            return;
        }
        Node pre = p;
        while(p != null && p.key != key) {
            pre = p;
            p = p.next;
        }
        
        if (p == null) {
            pre.next = q;
        } else {
            p.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hash(key);
        Node p = bucket[hash];

        while(p != null && p.key != key) {
            p = p.next;
        }
        if (p != null && p.key == key) {
            return p.value;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hash(key);
        
        Node p = bucket[hash];
        
        if (p == null) {
            return;
        }
        
        if (p.key == key) {
            bucket[hash] = p.next;
            return;
        }

        Node pre = p;
        while(p != null && p.key != key) {
            pre = p;
            p = p.next;
        }

        if (p != null && p.key == key) {
            pre.next = p.next;
        }  
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(73751,1);
        hashMap.put(83751,14);
        int res = hashMap.get(73751);
        System.out.println(res);
        res = hashMap.get(83751);
        System.out.println(res);
        hashMap.remove(83751);
        res = hashMap.get(83751);
        System.out.println(res);
        res = hashMap.get(73751);
        System.out.println(res);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */