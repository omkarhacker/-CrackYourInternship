class WordDictionary {
    class Node {
        Node child[] = new Node[26];
        boolean end = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int indx = word.charAt(i) - 'a';
            if (curr.child[indx] == null) {
                curr.child[indx] = new Node();
            }
            curr = curr.child[indx];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        return isTrue(word, 0, root);
    }

    public boolean isTrue(String word, int k, Node root) {
        if (k == word.length()) {
            return root.end == true;
        }
        char ch = word.charAt(k);
        int indx = ch - 'a';
        if (ch == '.') {
            for (int j = 0; j < 26; j++) {
                if (root.child[j] != null && isTrue(word, k + 1, root.child[j])) {
                    return true;
                }
            }
            return false;
        } else {
            if (root.child[indx] == null) {
                return false;
            }
            return isTrue(word, k + 1, root.child[indx]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */