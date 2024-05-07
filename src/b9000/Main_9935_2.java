package b9000;

import java.util.Scanner;
import java.util.Stack;

public class Main_9935_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String str = sc.nextLine();
		String sub = sc.nextLine();
		
		Stack<Character> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			s1.push(str.charAt(i));
		}
		// 메인 스택에서 sub의 길이만큼 빼서 서브 스택에 넣음
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
			
			if(s2.size()>=sub.length()) {
				// s2의 top이 sub의 0
				boolean flag = true;
				for(int i=0; i<sub.length(); i++) {
					if(s2.get(s2.size()-i-1)!=sub.charAt(i)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int i=0; i<sub.length(); i++) {
						s2.pop();
					}
				}
			}
		}
		for(char a : s2) {
			sb.append(a);
		}
		if(s2.isEmpty()) System.out.println("FRULA");
		else System.out.println(sb.reverse().toString());

	}

}
