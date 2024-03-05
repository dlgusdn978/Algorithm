package b1000;

import java.util.Scanner;
import java.util.Stack;

public class Main_1918 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		StringBuilder sb = new StringBuilder();
		// 스택 2개 활용?
		// a+b+c+d => abcd+++
		
		Stack<Character> s = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			char cur = str.charAt(i);
			
			switch(cur) {
			case '+':
			case '-':
			case '*':
			case '/':
				while(!s.isEmpty() && getPriority(s.peek())>=getPriority(cur)) {
					sb.append(s.pop());
				}
				s.push(cur);
				break;
				
			case '(':
				s.push(cur);
				break;
			case ')':
				while(!s.isEmpty() && s.peek()!= '(') {
					sb.append(s.pop());
				}
				s.pop();
				break;
			default :
				sb.append(cur);
				
			}
//			System.out.println(s);
//			System.out.println(sb.toString());
		}
		while(!s.isEmpty()) {
			sb.append(s.pop());
		}
		System.out.println(sb.toString());
	}

	
	static int getPriority(char oper) {
		if(oper=='(' || oper==')') {
			return 0;
		}else if(oper=='+' || oper=='-') {
			return 1;
		}else if(oper=='*' || oper=='/') {
			return 2;
		}
		return -1;
	}
}
