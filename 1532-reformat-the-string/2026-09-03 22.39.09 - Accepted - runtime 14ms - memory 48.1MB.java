class Solution {
    public String reformat(String s) {
        int n = s.length();
        String num = "";
        String str = "";
        for(char ch : s.toCharArray())
            {
                if(ch<97)num+=ch;
                else str+=ch;
            }
        if(Math.abs(num.length()-str.length())>1)return "";
        String longi="",shorti="";
        if(num.length()>str.length())
        {
            longi = num;
            shorti = str;
        }
        else
        {
            longi = str;
            shorti = num;
        }
        int ilong=0,ishort=0;
        String ans = "";
        while(ilong < longi.length() && ishort < shorti.length())
            {
                 ans+=longi.charAt(ilong);
                 ans+=shorti.charAt(ishort);
                 ilong++;
                 ishort++;
            }
        if(ilong != longi.length())ans+=longi.charAt(ilong);

        return ans;
    }
}