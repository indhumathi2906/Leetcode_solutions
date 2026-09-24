class Solution {
        public boolean isMatch(String s, String p) {
                int n=s.length();
                        int m=p.length();
                                int i=0;
                                        int j=0;
                                                int match=0;
                                                        int idx=-1;
                                                                while(i<n){
                                                                            if(j<m&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')){
                                                                                               i++;
                                                                                                                  j++;
                                                                                                                              }
                                                                                                                                          else if(j<m&&p.charAt(j)=='*'){
                                                                                                                                                          match=i;
                                                                                                                                                                          idx=j;
                                                                                                                                                                                          j++;
                                                                                                                                                                                                      }
                                                                                                                                                                                                                  else if(idx!=-1){
                                                                                                                                                                                                                                   j=idx+1;
                                                                                                                                                                                                                                                    match++;
                                                                                                                                                                                                                                                                     i=match;

                                                                                                                                                                                                                                                                                 }
                                                                                                                                                                                                                                                                                             else return false;
                                                                                                                                                                                                                                                                                                     }
                                                                                                                                                                                                                                                                                                             while(j<p.length()&&p.charAt(j)=='*') j++;
                                                                                                                                                                                                                                                                                                                     return j==p.length();
                                                                                                                                                                                                                                                                                                                         }
                                                                                                                                                                                                                                                                                                                         
}