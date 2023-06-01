void update_step(int m, int n, int* stepx, int* stepy, int* stepcount, int** grid, int time){
    if (grid[m][n] == 0){
        grid[m][n] = time;
        stepx[*stepcount] = m;
        stepy[*stepcount] = n;
        *stepcount += 1;
    }
}

void input(int a, int b, int c, int d, int e, int f, int x, int* stepx, int* stepy, int* stepcount, int** grid, int time){
    if (a >= 0){
        update_step(a, e, stepx, stepy, stepcount, grid, time);
        if (d >= 0){
            update_step(a, d, stepx, stepy, stepcount, grid, time);
        }
        if (f <= x){
            update_step(a, f, stepx, stepy, stepcount, grid, time);
        }
    }
    if (c <= x){
        update_step(c, e, stepx, stepy, stepcount, grid, time);
        if (d >= 0){
            update_step(c, d, stepx, stepy, stepcount, grid, time);
        }
        if (f <= x){
            update_step(c, f, stepx, stepy, stepcount, grid, time);
        }
    }
    if (d >= 0){
        update_step(b, d, stepx, stepy, stepcount, grid, time);
    }
    if (f <= x){
        update_step(b, f, stepx, stepy, stepcount, grid, time);
    }
}

int shortestPathBinaryMatrix(int** grid, int gridSize, int* gridColSize){
    int x = gridSize-1;
    if (grid[0][0] == 1 || grid[x][x] == 1){
    return -1;
    }
    int stepx[10000];
    int stepy[10000];
    int stepcount = 1;
    stepx[0] = 0;
    stepy[0] = 0;
    int time = 1;
    grid[0][0] = time;
    int lastcount = 0;
    while (lastcount != stepcount && grid[x][x] == 0){
        time++;
        int i = lastcount;
        lastcount = stepcount;
        for (; i < lastcount ; i++){
            input(stepx[i]-1, stepx[i], stepx[i]+1, stepy[i]-1, stepy[i], stepy[i]+1, x, stepx, stepy, &stepcount, grid, time);
        }
        
    }
    return lastcount == stepcount ? -1 : time;
}