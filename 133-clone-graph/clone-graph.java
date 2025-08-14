/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
       HashMap<Node, Node> map = new HashMap<>();

       Node root = new Node(node.val);
       map.put(node, root);

       Queue<Node> que = new LinkedList<>();
       que.add(node);

       while(!que.isEmpty()){
            Node cur = que.poll();
            for(Node i : cur.neighbors){
                if(!map.containsKey(i)){
                    Node new_cur = new Node(i.val);
                    map.put(i, new_cur);
                    que.add(i);
                }
                map.get(cur).neighbors.add(map.get(i));
            }
       }

       return root;
        
    }
}