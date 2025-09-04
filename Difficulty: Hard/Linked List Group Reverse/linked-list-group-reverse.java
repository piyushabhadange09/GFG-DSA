

/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
        Node outerTemp = head;
        Node innerTemp = head;
        Node connectingNode = null;
        Node newHead = null;
        
        while(outerTemp != null){
            int i = k;
            while(i > 0 && innerTemp != null){
                innerTemp = innerTemp.next;
                i--;
            }
            
            Node curr = outerTemp;
            Node nextNode = curr;
            Node prev = null;
            while(curr != innerTemp){
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            
            if(newHead == null) newHead = prev;
            
            if(connectingNode != null){
                connectingNode.next = prev;
            }
            
            connectingNode = outerTemp;
            outerTemp = innerTemp;
        }
        
        return newHead;
    }
}