package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1935 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] val = new long[26];
		String str = br.readLine();
		
		Stack<String> s1 = new Stack<>();
		Stack<String> s2 = new Stack<>();
		for(int i=0; i<n; i++) {
			val[i] = Long.parseLong(br.readLine());
		}
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)-65>=0 && str.charAt(i)-65<=25) {
				s1.push(String.valueOf(val[str.charAt(i)-65]));
			}else {
				s1.push(String.valueOf(str.charAt(i)));
			}
		}
		
		
		while(s1.size()+s2.size()>=2) {
			String cur = s1.pop();
			String next = s1.pop();
			String next2 = s1.pop();
			if(checker(cur) && !checker(next) && !checker(next2)) {
				s1.push(calc(cur, next2, next));
				while(!s2.isEmpty()) {
					s1.push(s2.pop());
				}
			}else {
				s2.push(cur);
				s1.push(next2);
				s1.push(next);
			}
			

		}
		System.out.printf("%.2f", Double.parseDouble(s1.peek()));
	}

	static boolean checker(String str) {
		if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")) {
			return true;
		}
		return false;
	}
	
	static String calc(String oper, String num1, String num2) {
		String temp = "";
		switch(oper) {
		case "+":
			temp = String.valueOf(Double.parseDouble(num1)+Double.parseDouble(num2));
			break;
		case "-":
			temp = String.valueOf(Double.parseDouble(num1)-Double.parseDouble(num2));
			break;
		case "*":
			temp = String.valueOf(Double.parseDouble(num1)*Double.parseDouble(num2));
			break;
		case "/":
			temp = String.valueOf(Double.parseDouble(num1)/Double.parseDouble(num2));
			break;
		}
		return temp;
	}
}
