package programmers;

import java.util.Arrays;

public class Word_Puzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    static int min = Integer.MAX_VALUE;
	    public int solution(String[] strs, String t) {
	        int answer = 0;
	        
	        // dp�� Ǯ��.
	        // �� ���ڿ��� ��ȣ�� �Բ� map ����?
	        // 2���� dp
	        int[] dp = new int[t.length()+1];
	        for(int i=0; i<strs.length; i++){
	            if(t.length()>=strs[i].length() && strs[i].equals(t.substring(0, strs[i].length()))) dp[strs[i].length()] = 1;
	        }
	        
	        for(int i=1; i<dp.length; i++){
	            if(dp[i]==0) continue;
	            
	            // �� ���ڿ��� ���̰� t���� ª�ƾ��ϰ�
	            for(int j=0; j<strs.length; j++){
	                int len = i+strs[j].length();
	                // System.out.println(i+" "+strs[j].length());
	                if(len<=t.length() && strs[j].equals(t.substring(i, len))){
	                    if(dp[len]==0) dp[len] = dp[i]+1;
	                    else dp[len] = Math.min(dp[i]+1, dp[len]);
	                }
	            }
	        }
	        System.out.println(Arrays.toString(dp));
	        answer = dp[dp.length-1]!=0 ? dp[dp.length-1] : -1;
	        return answer;
	    }
	    
	}
}
