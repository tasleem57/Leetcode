class Solution {
    public int minDeletions(String s) {
        // Create a map to store character frequencies
        Map<Character, Integer> charFrequency = new HashMap<>();
        
        // Create a set to keep track of existing frequencies in new string
        Set<Integer> existingFrequencies = new HashSet<>();
        
        // Count character frequencies
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Create a max heap to store frequencies
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Push frequencies into the max heap
        for (int freq : charFrequency.values()) {
            maxHeap.offer(freq);
        }

        int deletions = 0;
        while (!maxHeap.isEmpty()) {
            int curFreq = maxHeap.poll();
            
            // Adjust frequency if it already exists in the new string
            while (curFreq > 0 && existingFrequencies.contains(curFreq)) {
                curFreq--;
                deletions++;
            }
            
            // Add the adjusted frequency to the set
            existingFrequencies.add(curFreq);
        }
        return deletions;
    }
}