int maxValue(int n, int index, int maxSum){
    
    long long sum;
    //cnL : items of left side   
    //cnR : items of right side
    int cnL = index;
    int cnR = n - cnL - 1;
    
    int left = 1, right = maxSum;
    int mid;
    while(left < right){
        sum = 0;
        mid = right -(right - left)/2;
        //left
        if(cnL > 0){
            if(mid > cnL)
                sum = sum + (long long)((mid-1) + (mid - cnL)) * cnL / 2; 
            else{
                sum = sum + (long long)((mid - 1) + 1)*(mid - 1)/2;
                sum = sum + cnL - (mid - 1);
            }
        }
        //right
        if(cnR > 0){
            if(mid > cnR)
                sum = sum + (long long)((mid-1) + (mid - cnR))* cnR /2;
            else{
                sum = sum + (long long)((mid - 1) + 1)*(mid - 1)/2;
                sum = sum + cnR - (mid - 1);
            }
        }
        //val of index
        sum += mid;
        
        if(sum <= maxSum)
            left = mid;
        else
            right = mid - 1;
    }
    
    return left;
    
}