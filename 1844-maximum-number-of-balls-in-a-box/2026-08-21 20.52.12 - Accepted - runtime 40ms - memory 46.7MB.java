class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxBalls = 0;
        for(int i = lowLimit; i <= highLimit; i++)
        {
                    int boxNumber = getBoxNumber(i);
                    map.put(boxNumber, map.getOrDefault(boxNumber, 0) + 1);
                    maxBalls = Math.max(maxBalls, map.get(boxNumber));
        }
        return maxBalls;

    }
    public int getBoxNumber(int n)
    {
        int sum = 0;
        while(n > 0)
                {
                            sum += (n % 10); 
                                        n /= 10;         
                 }

          return sum;                                        

    }

        
    }
