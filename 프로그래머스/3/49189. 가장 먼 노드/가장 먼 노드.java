import java.util.*;
import java.math.*;

class Solution {
    private int max;
    private int[] dist;
    private List<Integer>[] nodes;
    private int INF = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] edge) {
        nodes = new ArrayList[n+1];
        dist = new int[n+1];
        max = 0;
        
        Arrays.fill(dist, INF);
        
        for(int i=0; i<=n; i++){
            nodes[i] = new ArrayList<>();
        }
        
        for(int[] arr: edge){
            int from = arr[0];
            int to = arr[1];
            
            nodes[from].add(to);
            nodes[to].add(from);
        }
        
        diakistra();
        
        int answer = 0;
        
        for(int i=1; i<=n; i++){
            if(max == dist[i]){
                answer++;
            }
        }
        
        return answer;
    }
    
    private void diakistra(){
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(1);
        dist[1] = 0;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            
            for(int next: nodes[curr]){
                if(dist[next] > dist[curr] + 1){
                    dist[next] = dist[curr] + 1;
                    max = Math.max(max, dist[next]);
                    queue.offer(next);
                }
            }
        }
    }
}

//max dist를 구한다.
//기본적으로 다익스트라를 이용해서 각 거리를 구한다.
//dist 배열을 확인하면서 max랑 같은 값을 찾는다.