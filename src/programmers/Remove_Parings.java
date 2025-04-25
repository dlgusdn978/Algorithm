package programmers;

import java.util.Stack;

public class Remove_Parings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(String s){
        int answer = 0;
        
        // ���ÿ� ���� �ϳ��� ����
        // ������ ���� ���ڿ� ���� �������� ���ڰ� ���ٸ� ���� �ʰ� s�� top ����
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
