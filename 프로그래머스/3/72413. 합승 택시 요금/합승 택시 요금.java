import java.util.*;
import java.math.*;
class Node {
    int to;
    int weight;

    public Node(int to, int weight){
        this.to = to;
        this.weight = weight;
    }
}
class Solution {
    //양방향 그래프 map
    private List<Node>[] nodes;
    private int INF = Integer.MAX_VALUE;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        nodes = new List[n+1];
        for(int i=0; i<=n; i++){
            nodes[i] = new ArrayList<>();
        }

        //배열에서 nodes으로
        for(int[] item: fares){
            //양방향 연결
            nodes[item[0]].add(new Node(item[1], item[2]));
            nodes[item[1]].add(new Node(item[0], item[2]));
        }

        // 무방향 그래프이므로 S, A, B 각각에서 딱 3번만 다익스트라
        int[] distS = dikstra(n, s);
        int[] distA = dikstra(n, a);
        int[] distB = dikstra(n, b);

        int min = INF;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, distS[i] + distA[i] + distB[i]);
        }

        return min;
    }

    private int[] dikstra(int n, int start) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.weight > dist[cur.to]) continue; // 이미 더 짧은 경로로 확정된 정점이면 무시

            for(Node next: nodes[cur.to]){
                int newDist = dist[cur.to] + next.weight;
                if(dist[next.to] > newDist){
                    dist[next.to] = newDist;
                    pq.offer(new Node(next.to, newDist));
                }
            }
        }

        return dist;
    }
}