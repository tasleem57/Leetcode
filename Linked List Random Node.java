class Solution {
    ListNode head;
    public Solution(ListNode head) {
        this.head=head;
    }
    
    public int getRandom() {
        ListNode node=head;
        int counter=0, res=0;
        while (node!=null){
            // R. Algo: k/k+counter probablity to be put into reservoir. where k is the size of reservoir=1
            counter++;
            if ((int)(Math.random()*counter)==0) res=node.val;
            node=node.next;
        }
        return res;       
    }
}
