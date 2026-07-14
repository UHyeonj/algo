import java.util.*;

class Solution {
    public long solution(int n) {
        long answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(1);
        queue.add(2);
        
        if(n <= 2) {
            return n;
        }
        
        int temp = 1;
        for(int i=2; i<=n; i++) {
            temp = queue.poll()%1234567 + queue.peek()%1234567;
            queue.add(temp);
        }
        
        return queue.poll()%1234567;
    }
}