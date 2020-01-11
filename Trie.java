class Trie {
    
    class TrieNode {
        // change this value to adapt to different cases
        static final int N = 26;
        TrieNode[] children = new TrieNode[N];

        // you might need some extra values according to different cases
        boolean isEnd;
        boolean hasValue;
    };

    /** Usage:
     *  Initialization: TrieNode root = new TrieNode();
     *  Return a specific child node with char c: root.children[c - 'a']
     */

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
         root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode pos = this.root;
        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if (pos.children[ ch - 'a' ] == null) {
                pos.children[ ch - 'a' ] = new TrieNode();
            } 
            pos = pos.children[ch - 'a'];
            pos.hasValue = true;
            if (i == word.length() -1) {
                pos.isEnd  = true;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode pos = root;
        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if (pos.children[ ch - 'a' ] == null 
                || !pos.children[ ch - 'a' ].hasValue ) {
                    return false;
            } 
            pos = pos.children[ch - 'a'];
            if (i == word.length() -1) {
                return  pos.isEnd;
            }
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode pos = root;
        for (int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if (pos.children[ ch - 'a' ] == null 
                || !pos.children[ ch - 'a' ].hasValue ) {
                    return false;
            } 
            pos = pos.children[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */