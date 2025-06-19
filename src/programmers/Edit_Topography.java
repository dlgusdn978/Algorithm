package programmers;

public class Edit_Topography {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static class Solution {
	   
	    public long solution(int[][] land, int P, int Q) {
	        int min = Integer.MAX_VALUE;
	        int max = Integer.MIN_VALUE;
	        int[] flat = new int[land.length * land.length];
	        int idx = 0;
	        for(int[] row : land){
	            for(int h : row){
	                flat[idx++] = h;
	                min = Math.min(min, h);
	                max = Math.max(max, h);
	            }
	        }
	        
	        long answer = Long.MAX_VALUE;
	        int low = min;
	        int high = max;
	        
	        while(low<=high){
	            int mid = (low+high)/2;
	            long cost1 = getCost(flat, P, Q, mid);
	            long cost2 = getCost(flat, P, Q, mid+1);
	            answer = Math.min(answer, Math.min(cost1, cost2));
	            
	            if(cost1<cost2){
	                high = mid -1;
	            }else{
	                low = mid+1;
	            }
	        }
	        
	        return answer;
	    }
	    static long getCost(int[] flat, int P, int Q, int height){
	        long add = 0;
	        long remove = 0;
	        for(int h : flat){
	            if(h<height){
	                add += height-h;
	            }else{
	                remove += h-height;
	            }
	        }
	        return add*P + remove*Q;
	    }
	   
	}
}
