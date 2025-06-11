package programmers;

public class Binary_Conversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
	    public int[] solution(String s) {
	        int[] answer = new int[2];
	        int convCnt = 0;
	        int zeroCnt = 0;
	        // 1. 1의 개수 구하기
	        // 2. 1의 갯수만큼 1 붙이기 ex) 1111
	        // 3. 1의 개수 -> 2진수로 변환
	        while(!s.equals("1")){
	            int cnt = 0;
	            for(int i=0; i<s.length(); i++){
	                if(s.charAt(i)=='1') cnt++;
	            }
	            convCnt++;
	            zeroCnt+=(s.length()-cnt);
	            s = Integer.toBinaryString(cnt);
	            
	        }
	        answer[0] = convCnt;
	        answer[1] = zeroCnt;
	        return answer;
	    }
	   
	}
}
