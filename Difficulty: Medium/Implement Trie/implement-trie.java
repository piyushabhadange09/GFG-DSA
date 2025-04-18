//{ Driver Code Starts
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// } Driver Code Ends

// User function Template for Java
class Node{
    public Node[] children = new Node[26];
    public boolean end;
    public Node(){
        for(int i=0;i<children.length;i++){
            this.children[i] = null;
        }
        this.end = false;
    }
}

class Trie {
    private Node root =  new Node();

    public void insert(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            if(i == word.length()-1){
                if(curr.children[word.charAt(i)-'a']!=null){
                    curr = curr.children[word.charAt(i)-'a'];
                }
                else{
                    Node node = new Node();
                    curr.children[word.charAt(i)-'a'] = node;
                    curr = node;
                }
                curr.end = true;
            }
            else{
                if(curr.children[word.charAt(i)-'a']!=null){
                    curr = curr.children[word.charAt(i)-'a'];
                }
                else{
                    Node node = new Node();
                    curr.children[word.charAt(i)-'a'] = node;
                    curr = node;
                }
            }
        }
    }

    public boolean search(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            if(curr.children[word.charAt(i)-'a'] == null){
                return false;
            }
            curr = curr.children[word.charAt(i)-'a'];
        }
        return curr.end;
    }

    public boolean isPrefix(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            if(curr.children[word.charAt(i)-'a'] == null){
                return false;
            }
            curr = curr.children[word.charAt(i)-'a'];
        }
        return true;
    }
}


//{ Driver Code Starts.

public class GfG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            int q = sc.nextInt();
            sc.nextLine();
            List<Boolean> ans = new ArrayList<>();
            Trie ob = new Trie();

            for (int i = 0; i < q; i++) {
                int x = sc.nextInt();
                String s = sc.next();
                if (i != q - 1) sc.nextLine();

                if (x == 1) {
                    ob.insert(s);
                } else if (x == 2) {
                    ans.add(ob.search(s));
                } else if (x == 3) {
                    ans.add(ob.isPrefix(s));
                }
            }

            for (Boolean result : ans) {
                System.out.print(result + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends
