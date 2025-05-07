package programmers;
import java.util.*;
public class Number_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	    public int solution(int[] A, int[] B) {
	        // n명씩 두 팀으로 나눠 게임
	        // 1인 1개 무작위 자연수
	        // 숫자가 큰 쪽이 승리, 승점 1점.
	        // 1 3 5 7
	        // 2 2 6 8
	        int answer = 0;
	        Arrays.sort(A);
	        Arrays.sort(B);
	        Queue<Integer> q = new ArrayDeque<>();
	        
	        for(int i=0; i<B.length; i++){
	            q.add(B[i]);    
	        }
	        
	        for(int i=0; i<A.length; i++){
	            while(!q.isEmpty()){
	                int num = q.poll();
	                if(A[i]<num){
	                    answer++;
	                    break;
	                }
	            }
	        }
	        return answer;
	    }
	
}
