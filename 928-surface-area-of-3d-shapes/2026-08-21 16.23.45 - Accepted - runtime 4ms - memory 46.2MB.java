class Solution {
        public int surfaceArea(int[][] grid) {
                int surfaceArea = 0;
                        //total area including faces that r hidden
                                for(int i = 0; i < grid.length; i++){
                                            for(int j = 0; j < grid[0].length; j++){
                                                            int height = grid[i][j];

                                                                            //when height = 0
                                                                                            if(height == 0) continue;
                                                                                                            surfaceArea += 4 * height + 2;

                                                                                                                            //touching cube pairs
                                                                                                                                            if(j + 1 < grid[0].length){
                                                                                                                                                                int right = grid[i][j + 1];
                                                                                                                                                                                    surfaceArea -= 2 * Math.min(height, right);
                                                                                                                                                                                                    }

                                                                                                                                                                                                                    //Down/Bottom neighbor
                                                                                                                                                                                                                                    if(i + 1 < grid.length){
                                                                                                                                                                                                                                                         int down = grid[i + 1][j];
                                                                                                                                                                                                                                                                              surfaceArea -= 2 * Math.min(height, down);
                                                                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                                                                                          }
                                                                                                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                                                                                                          return surfaceArea;
                                                                                                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                                                                                                              }
