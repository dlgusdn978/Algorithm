package b10000;

import java.util.Scanner;
import java.util.Stack;

public class Main_10799 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		Stack<Character> s = new Stack<>();
		
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='(') {
				s.push('(');
				continue;
			}
			if(str.charAt(i)==')') {
				s.pop();
				if(str.charAt(i-1)=='(') {
					count+=s.size();
				}else {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
