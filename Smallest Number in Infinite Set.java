class SmallestInfiniteSet {
    private int minNum = 1;
    private PriorityQueue<Integer> heap = new PriorityQueue<>();

    public int popSmallest() {
        if (!heap.isEmpty()) {
            return heap.poll();
        }
        minNum++;
        return minNum - 1;
    }

    public void addBack(int num) {
        if (minNum > num && !heap.contains(num)) {
            heap.offer(num);
        }
    }
}
