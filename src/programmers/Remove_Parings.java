package programmers;

import java.util.Stack;

public class Remove_Parings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(String s){
        int answer = 0;
        
        // 스택에 문자 하나씩 삽입
        // 이전에 넣은 문자와 현재 넣으려는 문자가 같다면 넣지 않고 s의 top 제거
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(!stack.isEmpty() && stack.peek()==s.charAt(i)){
                stack.pop();
            }else stack.push(s.charAt(i));
        }

        if(stack.isEmpty()) answer = 1;
        else answer = 0;
        
        return answer;
      
    }
}
