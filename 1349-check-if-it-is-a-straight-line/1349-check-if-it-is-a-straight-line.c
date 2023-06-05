bool checkStraightLine(int** A, int n, int* s){
    int dx,dy;
    dx = A[1][0] - A[0][0];
    dy = A[1][1] - A[0][1];
    for(int i = 2 ; i < n ; i++){
        if(dx*(A[i][1] - A[0][1]) != dy*(A[i][0] - A[0][0])) return false;
    }
    return true;
}