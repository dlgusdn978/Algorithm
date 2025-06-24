package programmers;

public class Quad_Compression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    static int zero;
	    static int one;
	    public int[] solution(int[][] arr) {
	        int[] answer = new int[2];
	        // �������� ���
	        // ��ü ���� ���� Ž��
	        // 1�� �����ϰų�, 0�� �����Ѵٸ� ���� ���� ++
	        // �����ִٸ�, ���� Ž�� ����
	        divide(arr, 0, 0, arr.length);
	        answer[0] = zero;
	        answer[1] = one;
	        return answer;
	    }
	    static void divide(int[][] arr, int r1, int c1, int bound){
	        if(bound==1){
	            if(arr[r1][c1]==1) one++;
	            else zero++;
	            return;
	        }
	        int[] res = calc(arr, r1, c1, r1+bound, c1+bound);
	        // System.out.println(Arrays.toString(res));
	        if(res[0]!=0 && res[1]!=0){
	            // 4����
	            int nextBound = bound/2;
	            divide(arr, r1, c1, nextBound);
	            divide(arr, r1+nextBound, c1, nextBound);
	            divide(arr, r1, c1+nextBound, nextBound);
	            divide(arr, r1+nextBound, c1+nextBound, nextBound);
	        }else if(res[0]==0) one++;
	        else zero++;
	    }
	    static int[] calc(int[][] arr, int r1, int c1, int r2, int c2){
	        int[] res = new int[2];
	        for(int i=r1; i<r2; i++){
	            for(int j=c1; j<c2; j++){
	                if(arr[i][j]==0) res[0]++;
	                else res[1]++;
	            }
	        }
	        return res;
	    }
	}
}
