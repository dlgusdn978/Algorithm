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
	        // 1. 1�� ���� ���ϱ�
	        // 2. 1�� ������ŭ 1 ���̱� ex) 1111
	        // 3. 1�� ���� -> 2������ ��ȯ
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
