package Leetcode.Medium;

import java.util.List;
import java.util.*;

class Node{
    int val;
    List<Node> neighbors;
    Node(int v,List k){

    }
}
public class LCCloneGraph {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Deque<Node> q = new ArrayDeque<>();
        Node ans = new Node(node.val, new ArrayList<>());
        map.put(node, ans);
        q.add(node);
        while(!q.isEmpty()) {
            Node cur = q.poll();
            for(Node nei : cur.neighbors) {
                if(!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val, new ArrayList<>()));
                    q.add(nei);
                }
                map.get(cur).neighbors.add(map.get(nei));
            }
        }
        return ans;
    }
}
