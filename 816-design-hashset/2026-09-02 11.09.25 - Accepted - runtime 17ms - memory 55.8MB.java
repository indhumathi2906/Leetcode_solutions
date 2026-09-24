

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
 class MyHashSet {

    private static final int SIZE = 769;
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<Integer>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }
    
    public void add(int key) {
        LinkedList<Integer> bucket = buckets[hash(key)];
        if (!bucket.contains(key)) { // avoid duplicate add
            bucket.add(key);
        }
    }
    
    public void remove(int key) {
        buckets[hash(key)].remove((Integer) key); // remove(key) will use remove by index method (remove(int index)) because the key is also in type int, so we use (Integer)
    }
    
    public boolean contains(int key) {
        return buckets[hash(key)].contains(key);
    }
}