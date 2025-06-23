package programmers;

public class Carpet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    public int[] solution(int brown, int yellow) {
	        int[] answer = new int[2];
	        int rc = brown/2;
	        int r = rc-1;
	        int c = 1;
	        while(c<=r){
	            if((r-1)*(c-1)==yellow) break;
	            r--;
	            c++;
	        }
	        answer[0] = r+1;
	        answer[1] = c+1;
	        return answer;
	    }
	}
}
