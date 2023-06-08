void search(int** grid, int cSize, int row, int start, int end, int* ans) {
    while(start < end) {
        int mid = start + (end - start) / 2;
        if(grid[row][mid] >= 0) {
            start = mid+1;
            if(grid[row][start] < 0) {
                (*ans) += (cSize - start);
                return;
            }
        } else {
            end = mid;
        }
    }
}

int countNegatives(int** grid, int gridSize, int* gridColSize) {
    if(gridSize == 1 && gridColSize[0] == 1) return grid[0][0] < 0 ? 1 : 0;
    
    int rSize = gridSize, cSize = gridColSize[0], ridx = 0, ans = 0;
    for(int r = rSize - 1; r >= 0; r--) {
        if(grid[r][0] >= 0) {
            ridx = r;
            ans = (rSize - ridx - 1) * cSize;
            break;
        }
    }
    for(int r = 0; r <= ridx; r++) {
        if(grid[r][cSize-1] >= 0) continue;
        search(grid, cSize, r, 0, cSize-1, &ans);
    }
    return ans;
}