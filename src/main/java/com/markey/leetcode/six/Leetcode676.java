package com.markey.leetcode.six;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.six
 * @ClassName: Leetcode676
 * @Author: markey
 * @Description:
 * @Date: 2021/3/12 21:21
 * @Version: 1.0
 */
public class Leetcode676 {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[] {"hello","leetcode"});
        System.out.println(magicDictionary.search("hhllo"));
    }
    static class MagicDictionary {
        Trie root;
        /** Initialize your data structure here. */
        public MagicDictionary() {
            root = new Trie();
        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                root.insert(word);
            }
        }

        public boolean search(String searchWord) {
            return root.search(searchWord);
        }

        class Trie {
            private Node root;

            public Trie() {
                this.root = new Node(false);
            }

            public void insert(String word) {
                Node node = root;
                for (char c : word.toCharArray()) {
                    if (node.children[c - 'a'] == null) {
                        node.children[c - 'a'] = new Node(false);
                    }
                    node = node.children[c - 'a'];
                }
                node.isWord = true;
            }

            public boolean search(String word) {
                return search(root, word, 0, 0);
            }

            public boolean search(Node parent, String word, int index, int changeNum) {
                if (changeNum > 1) {
                    return false;
                }
                if (index == word.length()) {
                    return parent.isWord && changeNum == 1;
                }
                char c = word.charAt(index);
                for (int i = 0; i < 26; i++) {
                    if (parent.children[i] == null) {
                        continue;
                    }
                    if ((c - 'a') == i) {
                        if (search(parent.children[i], word, index + 1, changeNum)) {
                            return true;
                        }
                    } else {
                        if (search(parent.children[i], word, index + 1, changeNum + 1)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }

        class Node {
            boolean isWord;
            Node[] children;

            public Node(boolean isWord) {
                this.isWord = isWord;
                this.children = new Node[26];
            }
        }
    }
}
