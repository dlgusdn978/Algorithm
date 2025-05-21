package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class Bridge_Trucks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	        // 허용 트럭 수 = 다리 길이
	        // 무게 상한 = weight;
	        int answer = 0;
	        // 트럭 대기열
	        Queue<Integer> q = new ArrayDeque<>();
	        for(int i=0; i<truck_weights.length; i++){
	            q.add(truck_weights[i]);
	        }
	        // 다리 위를 지나는 트럭 정보.
	        Queue<Integer> bridge = new ArrayDeque<>();
	        for(int i=0; i<bridge_length; i++){
	            bridge.add(0);
	        }
	        int curWeight = 0;
	        while(!bridge.isEmpty()){
	            int pre = bridge.poll();
	            curWeight -= pre;
	            
	            answer++;
	            
	            if(!q.isEmpty()){
	                if(curWeight+q.peek()<=weight){
	                    int next = q.poll();
	                    curWeight += next;
	                    bridge.add(next);
	                }else{
	                    bridge.add(0);
	                }
	            }
	        } 
	        
	        
	       

	        return answer;
	    }
	}
}
