class MyHashMap {
    int n = 10000;
    List<int[]>[] arr;

    public MyHashMap() {
        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
    }

    public void put(int key, int value) {
        int idx = key % n;
        for (int[] pair : arr[idx]) {
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }
        arr[idx].add(new int[]{key, value});
    }

    public int get(int key) {
        int idx = key % n;
        for (int[] pair : arr[idx]) {
            if (pair[0] == key) {
                return pair[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        int idx = key % n;
        arr[idx].removeIf(pair -> pair[0] == key);
    }
}