class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            groupMap.computeIfAbsent(size, k -> new ArrayList<>()).add(i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> group : groupMap.values()) {
            int size = group.size();
            for (int i = 0; i < size; i += groupSizes[group.get(i)]) {
                result.add(group.subList(i, i + groupSizes[group.get(i)]));
            }
        }

        return result;
    }
}
