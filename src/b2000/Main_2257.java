package b2000;

import java.util.Scanner;
import java.util.Stack;

public class Main_2257 {

	public static void main(String[] args) {
		// 수소 h = 1, 탄소 c = 12, 산소 o = 16
		Scanner sc = new Scanner(System.in);
	
		char[] arr = sc.nextLine().toCharArray();
//		System.out.println(('3'-48)*2);
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<arr.length; i++) {
			char cur = arr[i];
			if(cur==')') {
				String str = "";
				String reverse = "";
				while(true) {
					char temp = stack.pop();
					if(temp=='(') break;
					str += temp;
				}
				for(int j=str.length()-1; j>=0; j--) {
					reverse += str.charAt(j);
				}
				if(i!=arr.length-1) {
					char temp = arr[i+1];
					if(temp-48>=2 && temp-48<=9) {
						// temp 회 반복.
						for(int k=0; k<temp-48; k++) {
							for(int l=0; l<reverse.length(); l++) {
								stack.add(reverse.charAt(l));
							}
						}
						i++;
					}else {
						for(int l=0; l<reverse.length(); l++) {
							stack.add(reverse.charAt(l));
						}
					}
				}else {
					for(int l=0; l<reverse.length(); l++) {
						stack.add(reverse.charAt(l));
					}
				}
			}else {
				stack.add(cur);
			}
		}
//		System.out.println(stack);
		
		int count = 0;
		while(!stack.isEmpty()) {
			char cur = stack.pop();
			if(cur-48>=2 && cur-48<=9) {
				char next = stack.pop();
				if(next == 'H') {
					count += (1*(cur-48));
				}else if(next == 'C') {
					count += (12*(cur-48));
				}else if(next == 'O') {
					count += (16*(cur-48));
				}
			}else {
				if(cur == 'H') {
					count += 1;
				}else if(cur == 'C') {
					count += 12;
				}else if(cur == 'O') {
					count += 16;
				}
			}
		}
		System.out.println(count);
	}

}
