class Solution {
    public int addDigits(int num) {
        int temp = 0 ;
        temp = numnum(num);
        while(temp > 9){
           temp = numnum(temp);
        }
        return temp;
        
    }
    
    public int numnum(int num){
      int temp = 0;
      while(num > 9){
            temp += num % 10 ;
            num /= 10;
        }
        return temp + num;
    }
}
