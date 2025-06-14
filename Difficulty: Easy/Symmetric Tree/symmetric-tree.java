/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class Solution {
    boolean fun(Node n1,Node n2){
        if(n1==null && n2==null){
            return true;
        }
        if(n1==null || n2==null){
            return false;
        }
        if(fun(n1.left,n2.right)==false){
            return false;
        }
        if(fun(n1.right,n2.left)==false){
            return false;
        }
        if(n1.data!=n2.data){
            return false;
        }
        return true;
       
    }
    public boolean isSymmetric(Node root) {
        // Code here
        return fun(root,root);
    }
}