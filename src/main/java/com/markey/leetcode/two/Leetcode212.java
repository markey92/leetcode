package com.markey.leetcode.two;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.two
 * @ClassName: Leetcode212
 * @Author: markey
 * @Description:
 * @Date: 2021/10/7 20:39
 * @Version: 1.0
 */
public class Leetcode212 {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> ans = new HashSet<String>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(board, trie, i, j, ans);
            }
        }

        return new ArrayList<String>(ans);
    }

    public void dfs(char[][] board, Trie parent, int i, int j, Set<String> ans) {
        if (!parent.children.containsKey(board[i][j])) {
            return;
        }
        char ch = board[i][j];
        Trie now = parent.children.get(ch);
        if (now.word != "") {
            // 叶子节点
            ans.add(now.word);
        }

        board[i][j] = '#';
        for (int k = 0; k < dirs.length; k++) {
            int nextI = i + dirs[k][0];
            int nextJ = j + dirs[k][1];
            if (nextI >= 0 && nextI <board.length && nextJ >= 0 && nextJ < board[nextI].length && board[nextI][nextJ] != '#') {
                dfs(board, now, nextI, nextJ, ans);
            }
        }
        board[i][j] = ch;
    }

    class Trie {
        String word;
        Map<Character, Trie> children;

        public Trie() {
            word = "";
            children = new HashMap<>();
        }

        public void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                if (!cur.children.containsKey(word.charAt(i))) {
                    cur.children.put(word.charAt(i), new Trie());
                }
                cur = cur.children.get(word.charAt(i));
            }
            cur.word = word; // 叶子节点是word不为空字符串
        }
    }
}
