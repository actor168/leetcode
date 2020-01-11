class BinarySearchTree {
    
    Node root;
    int height;

    void traverseFrom(Node node) {
        if (node == null) {
            return;
        }
        traverseFrom(node.left);
        System.out.print(node.value + ",");
        traverseFrom(node.right);
    }

    void traverse() {
        traverseFrom(root);
    }

    Node search(int value) {
        Node n = root;
        while (n != null && n.value != value) {
            if (n.value < value) {
                n = n.right;
            }else {
                n = n.right;
            }
        }
        return n;
    }

    Node minimum(Node n) {
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    Node maximum(Node n) {
        while (n.right != null) {
            n = n.right;
        }
        return n;
    }

    Node successor(Node n) {
        if (n.right != null) {
            return minimum(n.right);
        }
        
        Node x = n.parent;
        while (x != null && x.right == n) {
            n = x;
            x = n.parent;
        }

        return x;
    }

    Node predecessor(Node n) {
        if (n.left != null) {
            return maximum(n.left);
        }

        Node x = n.parent;
        while (x != null && x.left == n) {
            n = x;
            x = n.parent;
        }
        return x;
    }

    Node insert(Node n) {
        return null;
    }

    Node delete(Node n) {
        return null;
    }

    public static void main(String[] args) {
        
    }
}

class Node{
    int value;
    Node left;
    Node right;
    Node parent;

    Node(int v){
        this.value = v;
    }
}