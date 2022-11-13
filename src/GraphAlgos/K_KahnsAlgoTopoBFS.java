package GraphAlgos;

import java.util.*;

public class K_KahnsAlgoTopoBFS {

    public static void main(String[] args) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>(Arrays.asList(1, 2)));
        map.put(1, new ArrayList<>(Arrays.asList(4)));
        map.put(2, new ArrayList<>(Arrays.asList(3)));
        map.put(3, new ArrayList<>(Arrays.asList(4, 1)));
        map.put(4, new ArrayList<>());
        map.put(5, new ArrayList<>(Arrays.asList(6)));
        map.put(6, new ArrayList<>());
        List<Integer> ans = topoBFS(map);
        System.out.println(ans);
    }

    public static List<Integer> topoBFS(Map<Integer, ArrayList<Integer>> map) {
        Queue<Integer> q = new LinkedList<>();
        int[] inDeg = new int[map.size()];
        map.forEach((k, v) -> {
            v.forEach(item -> {
                inDeg[item]++;
            });
        });
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            list.add(node);
            map.get(node).forEach(item -> {
                inDeg[item]--;
                if (inDeg[item] == 0) {
                    q.add(item);
                }
            });
        }
        return list;
    }
}
