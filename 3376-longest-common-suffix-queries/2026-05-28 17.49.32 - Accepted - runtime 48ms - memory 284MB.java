class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int index = -1;
    }

    TrieNode root = new TrieNode();

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        int shortestIndex = 0;

        for (int i = 1; i < wordsContainer.length; i++) {
            if (wordsContainer[i].length() < wordsContainer[shortestIndex].length()) {
                shortestIndex = i;
            }
        }

        root.index = shortestIndex;

        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i, wordsContainer);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }

    private void insert(String word, int idx, String[] wordsContainer) {
        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (node.children[c] == null) {
                node.children[c] = new TrieNode();
            }

            node = node.children[c];

            if (node.index == -1 ||
                wordsContainer[idx].length() < wordsContainer[node.index].length()) {
                node.index = idx;
            }
        }
    }

    private int search(String query) {
        TrieNode node = root;

        for (int i = query.length() - 1; i >= 0; i--) {
            int c = query.charAt(i) - 'a';

            if (node.children[c] == null) {
                break;
            }

            node = node.children[c];
        }

        return node.index;
    }
}