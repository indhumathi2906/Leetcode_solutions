class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
      
        Map<String, Integer> wordCount = new HashMap<>();

        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        
       
        for (String word : words1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
    
        for (String word : words2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
  
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        
   
        return result.toArray(new String[0]);
    }
}