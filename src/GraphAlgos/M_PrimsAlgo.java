package GraphAlgos;

import java.util.*;

public class M_PrimsAlgo {

    public static void main(String[] args) {
        Map<Integer, ArrayList<Pair<Integer, Integer>>> map = new HashMap<>();
        map.put(0, new ArrayList<>(Arrays.asList(new Pair<>(1, 2), new Pair<>(2, 4))));
        map.put(1, new ArrayList<>(Arrays.asList(new Pair<>(0, 2), new Pair<>(2, 3))));
        map.put(2, new ArrayList<>(Arrays.asList(new Pair<>(1, 3), new Pair<>(0, 4))));
        System.out.println(primsalgo(map));
    }

    public static int primsalgo(Map<Integer, ArrayList<Pair<Integer, Integer>>> map) {
        int ans = 0;
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        Set<Integer> vis = new HashSet<>();
        q.add(new Pair<>(0, 0));
        while (!q.isEmpty()) {
            Pair<Integer, Integer> pair = q.poll();
            if (vis.contains(pair.getKey())) {
                continue;
            }
            ans += pair.getValue();
            vis.add(pair.getKey());
            map.get(pair.getKey()).forEach(item -> {
                q.add(item);
            });
        }
        return ans;
    }

}

class Pair<F, S> {

    private final F first;
    private final S second;

    public F getKey() {
        return first;

    }

    public S getValue() {
        return second;

    }

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
    }

    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
    }

    public static <A, B> Pair<A, B> create(A a, B b) {
        return new Pair<>(a, b);
    }
}
