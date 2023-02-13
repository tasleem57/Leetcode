class Solution {
public:
int countOdds(int low, int high) {
int count=0;
if( (low&1)==0 && (high&1)==0){
count=(high-low)/2;
}
else if(((low&1)!=0 && (high&1)!=0)||((low&1)!=0||(high&1)!=0)){
count = ceil((high-low)/2)+1;
}
return count;
}
};
