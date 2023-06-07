int minFlips(int a, int b, int c){
    int flips = 0;
    while ( a||b||c){
        
        if ( c&1){
            if( !(a&1) && !(b&1))
                flips++;
        }
        else {
            flips += (a&1) +(b&1);
        }
        a >>= 1;
        b >>= 1;
        c >>= 1;
        
    }
    return flips;

}