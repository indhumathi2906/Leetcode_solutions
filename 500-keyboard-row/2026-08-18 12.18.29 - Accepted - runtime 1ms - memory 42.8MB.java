class Solution {
        public String[] findWords(String[] words) {
                HashSet<Character> set1 = new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
                        HashSet<Character> set2 = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
                                HashSet<Character> set3 = new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));
                                        List<String> result = new ArrayList<>();
                                                
                                                        for(String word : words){
                                                                    String lower = word.toLowerCase();
                                                                                char first = lower.charAt(0);

                                                                                            HashSet<Character> currentSet;
                                                                                                        if(set1.contains(first)){
                                                                                                                        currentSet = set1;
                                                                                                                                    }else if(set2.contains(first)){
                                                                                                                                                    currentSet = set2;
                                                                                                                                                                }else{
                                                                                                                                                                                currentSet = set3;
                                                                                                                                                                                            }

                                                                                                                                                                                                        boolean flag = true;
                                                                                                                                                                                                                    for(int i=1; i<lower.length(); i++){
                                                                                                                                                                                                                                    if(!currentSet.contains(lower.charAt(i))){
                                                                                                                                                                                                                                                        flag = false;
                                                                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    if(flag){
                                                                                                                                                                                                                                                                                                                                    result.add(word);
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                            return result.toArray(new String[0]);
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                }
