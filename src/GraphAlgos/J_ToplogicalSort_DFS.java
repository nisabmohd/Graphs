package GraphAlgos;

import java.util.*;

public class J_ToplogicalSort_DFS {

    public static void main(String[] args) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>(Arrays.asList(1,3)));
        map.put(1, new ArrayList<>(Arrays.asList(2)));
        map.put(2, new ArrayList<>());
        map.put(3, new ArrayList<>(Arrays.asList(4)));
        map.put(4, new ArrayList<>());
        Stack<Integer> stack = new Stack<>();
        Set<Integer> vis = new HashSet<>();
        int n = map.size();
        for (int i = 0; i < n; i++) {
            if (!vis.contains(i)) {
                topo(map, stack, 0, vis);
            }
        }
        System.out.println(stack);
    }

    public static void topo(Map<Integer, ArrayList<Integer>> map, Stack<Integer> stack, int s, Set<Integer> vis) {
        vis.add(s);
        map.get(s).forEach(item -> {
            if (!vis.contains(item)) {
                topo(map, stack, item, vis);
            }
        });
        stack.push(s);
    }
}
