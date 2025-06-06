package programmers;

public class Jump_Teleport {

	public static void main(String[] args) {
		
	}
	

	public class Solution {
	    public int solution(int n) {
	        int ans = 0;
	        
	        while(n!=0){
	            if(n%2==0) n/=2;
	            else {
	                n-=1;
	                ans++;
	            }
	            
	        }
	        return ans;
	    }
	}
}
