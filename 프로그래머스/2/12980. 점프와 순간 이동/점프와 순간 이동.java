import java.util.*;
import java.math.*;

public class Solution {
    public int solution(int n) {
        int answer = findMin(n);
        
        return answer;
    }
    private static int findMin(int num){
        int fuel = 1;
        while(true){
            if(num == 1) break;
            
            if(num%2 != 0){
                fuel+=1;
            }
            num /= 2;
        }
        return fuel;
    }
}
//이동 방법
//1. 한번에 K칸 앞으로 점프 -> 건전지 사용량이 든다.
//2. 현재까지 온 거리 * 2 에 해당하는 위치로 순간이동 -> 건전지 사용량이 줄지 않는다.
//반절씩 계속 나눈다. 나머지가 생기면 카운트 그리고 마지막에 1이면 멈춘다. -> 첫 시작 1은 더해준다.