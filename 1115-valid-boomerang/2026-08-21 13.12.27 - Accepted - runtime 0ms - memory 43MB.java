class Solution {
        public boolean isBoomerang(int[][] points) {
                // No two points should be equal
                        if ((points[0][0] == points[1][0] && points[0][1] == points[1][1]) ||
                                    (points[1][0] == points[2][0] && points[1][1] == points[2][1]) ||
                                                (points[2][0] == points[0][0] && points[2][1] == points[0][1])) {
                                                            return false;
                                                                    }

                                                                            int x1 = points[0][0], y1 = points[0][1];
                                                                                    int x2 = points[1][0], y2 = points[1][1];
                                                                                            int x3 = points[2][0], y3 = points[2][1];

                                                                                                    // Check collinearity using cross product
                                                                                                            return (y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1);
                                                                                                                }
                                                                                                                }
