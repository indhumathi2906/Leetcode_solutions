class Solution {
    public boolean canReach(int[] arr, int start) {
         boolean[] visited = new boolean[arr.length];
        return check(arr, start, visited);
    }

    public boolean check(int[] arr, int start, boolean[] visited) {
        if (start < 0 || start >= arr.length || visited[start]) {
            return false;
        }

        if (arr[start] == 0) {
            return true;
        }

        visited[start] = true;

        int forward = start + arr[start];
        int backward = start - arr[start];

        return check(arr, forward, visited) || check(arr, backward, visited);
    }
}