import java.util.*;
import java.io.*;

class Solution {
    public static boolean[] visited;
    public static int[][] cComputers;
    public static int len;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        cComputers = computers;
        len = n;
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }
        
        
        return answer;
    }
    
    public static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<Integer>();
        
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i=0; i<len; i++){
                int next = cComputers[cur][i];
                if(next == 1 && !visited[i]){
                    visited[i] = true;
                    q.offer(i);   
                }
            }
        }
        
        
    }
}
//0부터 n-1까지 각가 bfs를 돌린다.
//단 이미 방문 했으면 돌리지 않는다.