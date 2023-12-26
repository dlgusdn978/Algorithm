package b15000;

import java.util.Scanner;

public class Main_15927 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		int length = str.length();
		
		boolean flag = true;

		for(int i=0; i<length/2; i++) {
			if(str.charAt(i) != str.charAt(length-i-1)) {
				System.out.println(length);
				return;
			}else if(str.charAt(i)!=str.charAt(i+1)){
				flag = false;
			}
		}
		System.out.println(flag ? -1 : str.length()-1);
	}

	
}
