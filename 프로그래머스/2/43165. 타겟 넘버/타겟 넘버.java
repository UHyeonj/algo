import java.util.*;

class Solution {
    private static int T, len, answer;
    private static int[] values;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        T = target;
        len = numbers.length;
        values = numbers;
        
        dfs(0,0);
        
        return answer;
    }
    
    private static void dfs(int cnt, int sum){
        
        if(cnt == len){
            if(sum == T) answer++;
            return;
        }
        
        dfs(cnt+1, sum+values[cnt]);
        dfs(cnt+1, sum-values[cnt]);
    }
}


//무조건 더하거나 빼야한다.
//재귀의 분기 마다 뺄지 더할지를 정한다.