/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> level = new LinkedList<>();
        if (root == null) return null;
        level.add(root);

        while(!level.isEmpty()){
            int levelSize = level.size();
            Queue<Node> temp = new LinkedList<>();

            while(levelSize> 0){
                Node current = level.poll();
                temp.add(current);
                if(current.left!=null) level.add(current.left);
                if(current.right!=null) level.add(current.right);
                levelSize--;
            }

            Node current = temp.poll();
            while(!temp.isEmpty()){
                Node forward = temp.poll();
                current.next = forward;
                current = forward;
            }
            current.next = null;
            
            
        }

        return root;
    }
}