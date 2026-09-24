import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordCount = new HashMap<>();

        int i = 0, n = paragraph.length();
        while (i < n) {
            while (i < n && !Character.isLetter(paragraph.charAt(i))) {
                i++;
            }
            StringBuilder temp = new StringBuilder();
            while (i < n && Character.isLetter(paragraph.charAt(i))) {
                temp.append(Character.toLowerCase(paragraph.charAt(i)));
                i++;
            }
            String word = temp.toString();
            if (!word.isEmpty() && !bannedSet.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        String ans = "";
        int maxFreq = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }
}