typedef struct Node {
    int bomb;
    struct Node *next;
} Node;

int inRange(int **bombs, int i, int j) {
    int x1, y1, r1, x2, y2;
    long long rangeSquared, distanceSquared;
    x1 = bombs[i][0];
    y1 = bombs[i][1];
    r1 = bombs[i][2];
    x2 = bombs[j][0];
    y2 = bombs[j][1];
    rangeSquared = (long long) r1 * (long long) r1;
    distanceSquared = (long long) (x1 - x2) * 
                      (long long) (x1 - x2) + 
                      (long long) (y1 - y2) * 
                      (long long) (y1 - y2);
    return distanceSquared <= rangeSquared;
}

int dfs(Node **bombList, int node, int *visited) {
    int count = 1;
    Node *n = bombList[node];
    int neighbour;
    visited[node] = 1;
    while (n != NULL) {
        neighbour = n->bomb;
        if (!visited[neighbour]) {
            count += dfs(bombList, neighbour, visited);
        }
        n = n->next;
    }
    return count;
}

int maximumDetonation(int** bombs, int bombsSize, int* bombsColSize){
    int i, j, visited[bombsSize];
    int numberDetonated, maxNumberDetonated = INT_MIN;
    Node **bombList = (Node**) calloc(bombsSize, sizeof(Node*));
    Node *dest;

    /* Build up adjacency list */
    for (i = 0; i < bombsSize; ++i) {
        for (j = 0; j < bombsSize; ++j) {
            if (i != j && inRange(bombs, i, j)) {
                dest = (Node*) malloc(sizeof(Node));
                dest->bomb = j;
                dest->next = bombList[i];
                bombList[i] = dest;
            }
        }
    }
    /* determine how many bombs will be detonated from each bomb */
    for (i = 0; i < bombsSize; ++i) {
        memset((void*) visited, 0, bombsSize * sizeof(int));
        numberDetonated = dfs(bombList, i, visited);
        if (numberDetonated > maxNumberDetonated) {
            maxNumberDetonated = numberDetonated;
        }
    }
    return maxNumberDetonated;
}