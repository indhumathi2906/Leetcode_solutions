class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int len1 =0,len2=0;
        for(int i=0;i<n;i++)
            {
                if(start <= destination)
                {
                if(i>=start && i<destination)len1+=distance[i];
                else len2+=distance[i];
                }
                else
                {
                    if(i>=start || i<destination)len1+=distance[i];
                    else len2+=distance[i];
                }
            }
        return Math.min(len1,len2);
    }
}