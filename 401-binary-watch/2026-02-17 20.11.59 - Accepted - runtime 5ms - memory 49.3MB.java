class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for(int hour = 0; hour < 12; hour++) {

            for(int minute = 0; minute < 60; minute++) {

                int hourBits = Integer.bitCount(hour);
                int minuteBits = Integer.bitCount(minute);

                if(hourBits + minuteBits == turnedOn) {

                    String time = hour + ":";

                    if(minute < 10)
                        time += "0" + minute;
                    else
                        time += minute;

                    result.add(time);
                }
            }
        }

        return result;
        
    }
}