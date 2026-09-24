class Solution {
        public String categorizeBox(int length, int width, int height, int mass) {
                long vol = (long)length * width * height;
                        boolean Bulky = false;
                                boolean Heavy = false;
                                        if(vol >= 1000000000|| length >= 10000 || width >= 10000 || height >= 10000){
                                                    Bulky = true;
                                                            }
                                                                    if(mass >= 100){
                                                                                Heavy = true;;
                                                                                        }
                                                                                                if(Bulky && Heavy){
                                                                                                            return "Both";
                                                                                                                    }
                                                                                                                            if(Bulky && !Heavy){
                                                                                                                                        return "Bulky";
                                                                                                                                                }
                                                                                                                                                        if(!Bulky && Heavy){
                                                                                                                                                                    return "Heavy";
                                                                                                                                                                            }
                                                                                                                                                                                    return "Neither";
                                                                                                                                                                                        }
                                                                                                                                                                                        }
