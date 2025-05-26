package programmers;

public class Decode_Secret {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    static int score = 0;
	    public int solution(int n, int[][] q, int[] ans) {
	        int answer = 0;
	        int[] arr = new int[5];
	        dfs(n, q, ans, arr, 1, 0);
	        return score;
	    }

	    static void dfs(int n, int[][] q, int[] ans, int[] arr, int idx, int cnt){
	        if(cnt==5){
	            int[] temp = new int[ans.length];

	            for(int i=0; i<temp.length; i++){
	                temp[i] = getCorrectCnt(arr, q[i]);
	            }
	            if(isCorrect(temp, ans)) score++;
	            return;
	        }
	        for(int i=idx; i<=n; i++){
	            arr[cnt] = i;
	            dfs(n, q, ans, arr, i+1, cnt+1);
	        }
	    }
	    
	    static int getCorrectCnt(int[] arr, int[] q){
	        int cnt = 0;
	        for(int i=0; i<arr.length; i++){
	            for(int j=0; j<q.length; j++){
	                if(arr[i]==q[j]) cnt++;
	            }
	        }
	        // System.out.println(cnt);
	        return cnt;
	    }
	    
	    static boolean isCorrect(int[] temp, int[] ans){
	        boolean flag = true;
	        for(int i=0; i<temp.length; i++){
	            if(temp[i]!=ans[i]) flag = false;
	        }
	        return flag;
	    }
	}

}
