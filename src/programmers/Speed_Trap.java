package programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

public class Speed_Trap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    public int solution(int[][] routes) {
	        int answer = 0;
	        //[[-20, -15], [-18, -13], [-14, -5], [-5, -3]];
	        Arrays.sort(routes, new Comparator<int[]>(){
	            @Override
	            public int compare(int[] o1, int[] o2){
	                return o1[1]-o2[1];
	            }
	        });
	        Queue<int[]> q = new ArrayDeque<>();
	        for(int i=0; i<routes.length; i++){
	            int[] arr = {routes[i][0], routes[i][1]};
	            q.add(arr);
	        }
	        
	        while(!q.isEmpty()){
	            int[] cur = q.poll();
	            
	            while(!q.isEmpty()){
	                int[] next = q.peek();
	                if(cur[1]<next[0]) break;
	                else q.poll();
	            }
	            answer++;   
	        }
	        return answer;
	    }
	}
}
