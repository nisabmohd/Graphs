package GraphAlgos;

import java.util.*;

public class G_DetectCycleUG_BFS {

    public static void main(String[] args) {
        Map<Integer, ArrayList<Integer>> map = GraphAlgos.A__Representation.getDirectedGraph();
        int n = map.size();
        Set<Integer> vis = new HashSet<>();
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (!vis.contains(i)) {
                if (hasCycle(map, i, vis)) {
                    flag = false;
                }
            }
        }
        if (!flag) {
            System.out.println("Has Cycle");
        } else {
            System.out.println("No cycle detected");
        }
    }

    private static boolean hasCycle(Map<Integer, ArrayList<Integer>> map, int s, Set<Integer> vis) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(s, -1));
        while (!q.isEmpty()) {
            Pair node = q.poll();
            for (int item : map.get(node.val)) {
                if (!vis.contains(item)) {
                    vis.add(item);
                    q.add(new Pair(item, node.val));
                } else if (item != node.parent) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Pair {

        int val, parent;

        public Pair(int val, int parent) {
            this.val = val;
            this.parent = parent;
        }

    }
}
