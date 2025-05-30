package programmers;

public class Estimated_Matchsheet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution{
    public int solution(int n, int a, int b){

        int answer = 1;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        while(true){
            if(min%2==1 && min+1==max) break;
            
            if(min%2==1) min++;
            if(max%2==1) max++;
            
            min/=2;
            max/=2;
            answer++;
        }
        return answer;
    }
}
}
