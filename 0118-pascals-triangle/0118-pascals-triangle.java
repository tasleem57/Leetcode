class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> dp = new ArrayList<>();

    for (int i = 0; i < n; ++i) {
      Integer[] temp = new Integer[i + 1];
      Arrays.fill(temp, 1);
      dp.add(Arrays.asList(temp));
    }

    for (int i = 2; i < n; ++i)
      for (int j = 1; j < dp.get(i).size() - 1; ++j)
        dp.get(i).set(j, dp.get(i - 1).get(j - 1) + dp.get(i - 1).get(j));

    return dp;
    }
}