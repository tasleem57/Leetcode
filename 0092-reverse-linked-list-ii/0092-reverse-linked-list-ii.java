class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode  dummyHead = new ListNode(),  rangeHead = null,  prevNode = dummyHead,  currNode = head,  rangeTail = null,  rangeHeadPrev = prevNode; 
        dummyHead.next = head;
        int nodeNum = 1;
        for(; nodeNum<left; nodeNum++){
             prevNode = currNode;
             currNode = currNode.next;              
        }
        rangeHeadPrev = prevNode;
        for(; nodeNum<=right; nodeNum++){
             ListNode  nextNode = currNode.next;
             if(nodeNum == left)rangeHead = currNode;
             if(nodeNum == right)rangeTail = currNode;
             currNode.next = (nodeNum != left) ? prevNode : null;
             prevNode = currNode;
             currNode = nextNode;
        }
        rangeHeadPrev.next = rangeTail;
        rangeHead.next = currNode;
        return dummyHead.next;
    }
}