package com.livedrof.j2se.algorithm.backtracking;

import org.junit.Test;

import java.util.*;

/**
 * 单词矩阵:
 * 给定一份单词的清单，设计一个算法，创建由字母组成的面积最大的矩形，其中每一行组成一个单词(自左向右)，每一列也组成一个单词(自上而下)。不要求这些单词在清单里连续出现，但要求所有行等长，所有列等高。
 * 如果有多个面积最大的矩形，输出任意一个均可。一个单词可以重复使用。
 *
 * 示例 1:
 * 输入: ["this", "real", "hard", "trh", "hea", "iar", "sld"]
 * 输出:
 * [ "this",
 *    "real",
 *    "hard" ]
 *
 * 示例 2:
 * 输入: ["aa"]
 * 输出: ["aa","aa"]
 *
 * 说明：
 * words.length <= 1000
 * words[i].length <= 100
 * 数据保证单词足够随机
 */
public class WordMatixSolution {
    @Test
    public void test() {
        String[] a = new WordMatixSolution().maxRectangle(new String[]{"this", "real", "hard", "trh", "hea", "iar", "sld"});
        System.out.println(Arrays.asList(a));
    }

    class Trie {
        private Trie[] children;
        private boolean mIsEnd;
        private int height;

        public Trie() {
            children = new Trie[26];
        }

        public void addChild(char c) {
            children[c - 'a'] = new Trie();
        }

        public boolean hasChild(char c) {
            return children[c - 'a'] != null;
        }

        public Trie getChild(char c) {
            return children[c - 'a'];
        }

        public void setEnd() {
            this.mIsEnd = true;
        }

        public boolean isEnd() {
            return mIsEnd;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    private List<String>[] lenToListMap;
    private Trie root;
    private Set<String> wordSet;
    private int maxArea;
    private List<String> ansWordList;

    private void createLenToListMap(String[] words) {
        lenToListMap = new ArrayList[101];
        for (String word : words) {
            int len = word.length();
            if (lenToListMap[len] == null) {
                lenToListMap[len] = new ArrayList<>();
            }
            lenToListMap[len].add(word);
        }
    }

    private void addWord(String word) {
        Trie cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.hasChild(c)) {
                cur.addChild(c);
            }
            cur = cur.getChild(c);
        }
        cur.setEnd();
    }

    private void createWordsTrie(String[] words) {
        root = new Trie();
        for (String word : words) {
            addWord(word);
        }
    }

    private boolean hasPrefixsAllInSet(List<String> tmpWordList, int wordLen) {
        for (int j = 0; j < wordLen; j++) {
            StringBuilder prefixSb = new StringBuilder();
            for (String word : tmpWordList) {
                prefixSb.append(word.charAt(j));
            }

            if (!wordSet.contains(prefixSb.toString())) {
                return false;
            }
        }
        return true;
    }

    private boolean isAreaBigger(List<String> tmpWordList) {
        if (ansWordList.isEmpty()) {
            return true;
        }
        return tmpWordList.get(0).length() * tmpWordList.size() > ansWordList.get(0).length() * ansWordList.size();
    }

    private boolean hasPrefixsAllExisted(String word, Trie[] tries) {
        for (int i = 0; i < word.length(); i++) {
            Trie cur = tries[i];
            char c = word.charAt(i);
            if (!cur.hasChild(c)) {
                return false;
            }
        }

        return true;
    }

    private Trie[] getChildTries(Trie[] prevTries, String word) {
        int wordLen = word.length();
        Trie[] tries = new Trie[wordLen];
        for (int i = 0; i < wordLen; i++) {
            char c = word.charAt(i);
            tries[i] = prevTries[i].getChild(c);
        }
        return tries;
    }

    private int getMinHeight(Trie[] tries) {
        int minHeight = Integer.MAX_VALUE;
        for (Trie trie : tries) {
            minHeight = Math.min(minHeight, trie.height);
        }
        return minHeight;
    }

    private void dfs(List<String> tmpWordList, List<Trie[]> trieList, int wordLen) {
        // 计算当前字典树节点的高度最小值
        int minHeight = getMinHeight(trieList.get(trieList.size() - 1));
        // 如果继续往下可能生成的最大面积没有超过已有的最大面积，直接返回即可
        if ((minHeight - 1 + trieList.size()) * wordLen <= maxArea) {
            return;
        }

        if (!tmpWordList.isEmpty() && hasPrefixsAllInSet(tmpWordList, wordLen) && isAreaBigger(tmpWordList)) {
            ansWordList = new ArrayList<>(tmpWordList);
            maxArea = ansWordList.get(0).length() * ansWordList.size();
        }

        List<String> sameLenWordList = lenToListMap[wordLen];
        for (String word : sameLenWordList) {
            Trie[] curLevelTries = trieList.get(trieList.size() - 1);
            if (hasPrefixsAllExisted(word, curLevelTries)) {
                trieList.add(getChildTries(curLevelTries, word));
                tmpWordList.add(word);
                dfs(tmpWordList, trieList, wordLen);
                tmpWordList.remove(tmpWordList.size() - 1);
                trieList.remove(trieList.size() - 1);
            }
        }
    }

    private int calcHeight(Trie root) {
        if (root == null) {
            return 0;
        }

        int maxHeight = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            maxHeight = Math.max(maxHeight, calcHeight(root.getChild(c)));
        }

        root.setHeight(maxHeight + 1);
        return maxHeight + 1;
    }

    public String[] maxRectangle(String[] words) {
        if (words == null || words.length == 0) {
            return new String[0];
        }

        createLenToListMap(words);
        createWordsTrie(words);
        calcHeight(root);

        wordSet = new HashSet<>(new ArrayList<>(Arrays.asList(words)));
        ansWordList = new ArrayList<>();

        for (String word : words) {
            int wordLen = word.length();
            List<Trie[]> trieList = new ArrayList<>();
            Trie[] tries = new Trie[wordLen];
            for (int i = 0; i < wordLen; i++) {
                tries[i] = root;
            }
            if (!hasPrefixsAllExisted(word, tries)) {
                continue;
            }

            trieList.add(tries);
            List<String> tmpWordList = new ArrayList<>();
            dfs(tmpWordList, trieList, wordLen);
        }

        String[] ansArr = new String[ansWordList.size()];
        return ansWordList.toArray(ansArr);
    }
}
