class Solution {
        public int oddCells(int m, int n, int[][] indices) {
                int[] rows = new int[m];
                        int[] cols = new int[n];

                                for (int[] indice : indices) {
                                            rows[indice[0]]++;
                                                        cols[indice[1]]++;
                                                                }

                                                                        int oddRows = 0, oddCols = 0;

                                                                                for (int num : rows) {
                                                                                            if ((num & 1) == 1) {
                                                                                                            oddRows++;
                                                                                                                        }
                                                                                                                                }

                                                                                                                                        for (int num : cols) {
                                                                                                                                                    if ((num & 1) == 1) {
                                                                                                                                                                    oddCols++;
                                                                                                                                                                                }
                                                                                                                                                                                        }

                                                                                                                                                                                                return oddRows * (n - oddCols)
                                                                                                                                                                                                             + oddCols * (m - oddRows);
                                                                                                                                                                                                                 }
                                                                                                                                                                                                                 }
