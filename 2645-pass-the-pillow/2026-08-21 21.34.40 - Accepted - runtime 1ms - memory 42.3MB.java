class Solution {
        public int passThePillow(int n, int time) {
                int person = 1;
                        int direction = 1;

                            
                                        for(int i = 0; i < time; i++){
                                                    person = person + direction;

                                                                
                                                                            if(person == n){
                                                                                            direction = -1;
                                                                                                        }

                                                                                                                    
                                                                                                                                if(person == 1){
                                                                                                                                                direction = 1;
                                                                                                                                                            }
                                                                                                                                                                    }
                                                                                                                                                                            return person;
                                                                                                                                                                                }
                                                                                                                                                                                }
