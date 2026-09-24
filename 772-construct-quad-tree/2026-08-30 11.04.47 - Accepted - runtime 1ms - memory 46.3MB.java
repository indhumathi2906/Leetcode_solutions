/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
   int[][] arr;
    public Node dfs(int n,int r,int c){
        boolean allsame=true;
        int curval=arr[r][c];
        for(int i=r;i<r+n;i++){
            for(int j=c;j<c+n;j++){
                if(curval!=arr[i][j]){
                    allsame=false;
                    break;
                }
            }
        }
        if(allsame) return new Node(arr[r][c]==1, true);
        n/=2;
        Node topleft=dfs(n,r,c), topright=dfs(n,r,c+n), bottomleft=dfs(n,r+n,c), bottomright=dfs(n,r+n,c+n);
        return new Node(true,false,topleft,topright,bottomleft,bottomright);
    }
    public Node construct(int[][] arr) {
        this.arr=arr;
        return dfs(arr.length,0,0);
    }
}