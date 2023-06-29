class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int[] directionRow = new int[]{1, -1, 0, 0};
        int[] directionColumn = new int[]{0, 0, 1, -1};
        int rows = grid.length;
        int columns = grid[0].length();
        int points = rows * columns;
        int allKeys = 0;
        int startPoint = 0;
        
        for (int r = 0; r < rows; r++) {
            String row = grid[r];
            
            for (int c = 0; c < columns; c++) {
                char v = row.charAt(c);
               
                if (v == '@') {
                    startPoint = r * columns + c;
                }
                boolean isKey = v >= 'a' && v <= 'f';
                if (isKey) {
                    allKeys = (allKeys << 1) | 1;
                }
            }
        }
        int states = points * (allKeys + 1);
        int[] queue = new int[states];
        int queueHead = 0;
        int queueTail = 0;
        boolean[] visited = new boolean[states];
        int distance = 0;
        int noKeys = 0;
        int startState = noKeys * points + startPoint;
        queue[queueHead++] = startState;
        
        visited[startState] = true;
        
        while (true) {
            int size = queueHead - queueTail;
            if (size == 0) {
                break;
            }
            while (--size >= 0) {
                int state = queue[queueTail++];
                int keys = state / points;
                int point = state % points;
                int row = point / columns;
                int column = point % columns;

                if (keys == allKeys) {
                    return distance;
                }
                for (int i = 0; i < 4; i++) {
                    int nextRow = row + directionRow[i];
                    int nextColumn = column + directionColumn[i];
                    if (nextRow < 0 || nextColumn < 0 || nextRow >= rows || nextColumn >= columns) {
                        continue;
                    }
                    char v = grid[nextRow].charAt(nextColumn);
                    if (v == '#') {
                        continue;
                    }
                    int nextKey = keys;
                    if (v != '.') {
                        boolean isLock = v >= 'A' && v <= 'F';
                        if (isLock && !isOpen(keys, v)) {
                            continue;
                        }
                        boolean isKey = v >= 'a' && v <= 'f';
                        if (isKey) {
                            nextKey = addKey(nextKey, v);
                        }
                    }
                    int nextPoint = nextRow * columns + nextColumn;
                    int nextState = nextKey * points + nextPoint;
                    if (!visited[nextState]) {
                        queue[queueHead++] = nextState;
                        visited[nextState] = true;
                    }
                }
            }
            distance++;
        }
        return -1;
    }
    public int addKey(int keys, char key) {
        int keyId = 1 << (key - 'a');
        return keys | keyId;
    }
    public boolean isOpen(int keys, char lock) {
        int lockId = 1 << (lock - 'A');
        return (keys & lockId) > 0;
    }
}