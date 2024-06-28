package b1000;

import java.util.Scanner;

public class Main_1254 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String str = sc.nextLine();
		sb.append(str);
		sb.reverse();
		String temp = sb.toString();
		
//		System.out.println(isPalindrome(str));
		if(isPalindrome(str)) System.out.println(str.length());
		else {
			int max = 0;
			for(int i=1; i<str.length(); i++) {
				String left = str.substring(str.length()-i, str.length());
				String right = temp.substring(0, i);
				
				if(left.equals(right)) max = Math.max(max, i);
			}
			
			System.out.println(str.length()-max+temp.length());
		}

	}
	
	static boolean isPalindrome(String str) {
		boolean flag = true;
		for(int i=0; i<str.length()/2; i++) {
			if(str.charAt(i)!=str.charAt(str.length()-i-1)) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
