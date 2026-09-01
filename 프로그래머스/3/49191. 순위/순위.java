import java.util.*;
import java.math.*;

class Solution {
    private List<Integer>[] wins;
    private List<Integer>[] loses;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        wins = new ArrayList[n+1];
        loses = new ArrayList[n+1];
        
        for(int i=0; i<=n; i++){
            wins[i] = new ArrayList<>();
            loses[i] = new ArrayList<>();
        }
        
        for(int[] temp: results){
            int win = temp[0];
            int lose = temp[1];
            
            wins[win].add(lose);
            loses[lose].add(win);
        }
        
        for(int i=1; i<=n; i++){
            int front = bfs(i, wins, n);
            int back = bfs(i, loses, n);
            
            if(front + back == n-1){
                answer++;
            }
        }
        
        return answer;
    }
    
    private int bfs(int start, List<Integer>[] list, int n){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        
        int cnt = 0;
        
        while(!queue.isEmpty()){
            int temp = queue.poll();
            
            for(int next: list[temp]){
                if(!visited[next]){
                    cnt++;
                    visited[next] = true;
                    queue.add(next);     
                }
            }
        }
        
        return cnt;
    }
}

//앞 뒤로 개수 확인한다.