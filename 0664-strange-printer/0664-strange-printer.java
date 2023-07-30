class Solution {
    static char ch[]=new char[100]; int n;
    public int strangePrinter(String s) {
        setCompressedString(s);
        return f(0,n-1,new Integer[n][n]);
    }
    private void setCompressedString(String s){
        int x=s.length(),k=0;
        for(int i=0;i<x;i++) 
            if(i==x-1 || s.charAt(i)!=s.charAt(i+1))
                ch[k++]=s.charAt(i);
        n=k;
    }
    private int f(int i, int j, Integer[][] memo){
        if(i==j) return 1;
        if(memo[i][j]!=null) return memo[i][j];
        int res=101;
        for(int k=i;k<j;k++)
            res=Math.min(res, f(i,k,memo)+f(k+1,j,memo));
        return memo[i][j]=ch[i]==ch[j]? res-1:res;
    }
}