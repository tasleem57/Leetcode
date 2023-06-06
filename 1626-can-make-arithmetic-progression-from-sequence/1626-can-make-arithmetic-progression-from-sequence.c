int cmp(const void* a, const void* b) {
    return *(const int*) a - *(const int*) b;
}

bool canMakeArithmeticProgression(int* arr, int arrSize) {
    qsort(arr, arrSize, sizeof(int), cmp);
    int diff = arr[1] - arr[0];
    for(int i = 2; i < arrSize; i++) {
        if(arr[i] - arr[i-1] != diff) return false;
    }
    return true;
}