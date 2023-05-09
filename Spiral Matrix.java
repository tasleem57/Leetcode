class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        int total = m * n;
        int startingRow = 0;
        int endingRow = m - 1;
        int startingCol = 0;
        int endingCol = n - 1;
        
        while (count < total) {
            // Traverse top row from left to right
            for (int i = startingCol; count < total && i <= endingCol; i++) {
                ans.add(matrix[startingRow][i]);
                count++;
            }
            startingRow++;
            
            // Traverse right column from top to bottom
            for (int i = startingRow; count < total && i <= endingRow; i++) {
                ans.add(matrix[i][endingCol]);
                count++;
            }
            endingCol--;
            
            // Traverse bottom row from right to left
            for (int i = endingCol; count < total && i >= startingCol; i--) {
                ans.add(matrix[endingRow][i]);
                count++;
            }
            endingRow--;
            
            // Traverse left column from bottom to top
            for (int i = endingRow; count < total && i >= startingRow; i--) {
                ans.add(matrix[i][startingCol]);
                count++;
            }
            startingCol++;
        }
        
        return ans;
    }
}
