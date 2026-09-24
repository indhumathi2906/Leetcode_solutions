class Pair {
    private int row;
    private int col;
    private int distance;

    public Pair(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public int getDist() {
        return this.distance;
    }

    public void setDistance(int d) {
        this.distance = d;
    }
}

class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        List<Pair> cordinates = new ArrayList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                cordinates.add(new Pair(i, j, 0));
            }
        }
        
        for(Pair pair : cordinates) {
            int row = pair.getRow();
            int col = pair.getCol();
            int dist = pair.getDist();

            dist = Math.abs(rCenter - row) + Math.abs(cCenter - col);
            pair.setDistance(dist);
        }

        Collections.sort(cordinates, new Comparator<Pair>() {
            @Override 
            public int compare(Pair p1, Pair p2) {
                return p1.getDist() - p2.getDist();
            }
        });

        int[][] result = new int[rows * cols][2];
        int index = 0;

        for(Pair pair : cordinates) {
            int row = pair.getRow();
            int col = pair.getCol();

            result[index][0] = row;
            result[index][1] = col;

            index++;
        }

        return result;
    }
}