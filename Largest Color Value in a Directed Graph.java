class Solution {
    static final int[] q = new int[100000];

    public int largestPathValue(String colors, int[][] edges) {
        final int n = colors.length();
        final char[] cs = colors.toCharArray();
        final int[][] best = new int[n][];
        final int[][] nexts = next(n, edges, 0);
        final int[][] prevs = next(n, edges, 1);
        final int[] counts = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            if ((counts[i] = nexts[i].length) == 0) {
                q[len++] = i;
            }
        }
        for (int i = 0; i < len; i++) {
            final int node = q[i];
            final int[] max = new int[26];
            for (int next : nexts[node]) {
                final int[] other = best[next];
                for (int j = 0; j < 26; j++) {
                    max[j] = Math.max(max[j], other[j]);
                }
            }
            max[cs[node] - 'a']++;
            best[node] = max;
            for (int prev : prevs[node]) {
                if (--counts[prev] == 0) {
                    q[len++] = prev;
                }
            }
        }
        if (len < n) return -1;
        int max = 0;
        for (int[] b : best) {
            for (int b1 : b) {
                max = Math.max(max, b1);
            }
        }
        return max;
    }

    static final int[] counts = new int[100000];

    static int[][] next(final int n, final int[][] edges, final int idx) {
        for (int[] e : edges) {
            counts[e[idx]]++;
        }
        final int[][] r = new int[n][];
        for (int i = 0; i < n; i++) r[i] = new int[counts[i]];
        for (int[] e : edges) {
            final int n1 = e[idx];
            r[n1][--counts[n1]] = e[1 - idx];
        }
        return r;
    }
}
