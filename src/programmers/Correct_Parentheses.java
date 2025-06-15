package programmers;

import java.util.Stack;

public class Correct_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    boolean solution(String s) {
	        boolean answer = true;

	        Stack<Character> stack = new Stack<>();
	        for(int i=0; i<s.length(); i++){
	            if(stack.isEmpty()) stack.push(s.charAt(i));
	            else{
	                if(stack.peek()=='(' && s.charAt(i)==')') stack.pop();
	                else stack.push(s.charAt(i));
	            }
	        }
	        if(!stack.isEmpty()) answer = false;
	        return answer;
	    }
	}
}
