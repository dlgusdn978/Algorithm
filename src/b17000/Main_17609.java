package b17000;

import java.util.Scanner;

public class Main_17609 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		String[] arr = new String[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextLine();
		}

		// 투 포인터 형식으로/
		for(int i=0; i<n; i++) {
			String str = arr[i];
			int start = 0;
			int end = str.length()-1;
			boolean flag = true;
			while(start<=end) {
				if(str.charAt(start)==str.charAt(end)) {
					start++;
					end--;
				}else {
					if(isPalindrome(str, start+1, end)||isPalindrome(str, start, end-1)) {
						System.out.println(1);
						flag = false;
						break;
					}else {
						System.out.println(2);
						flag = false;
						break;
					}
				}
				//abcffdba
			}
			if(flag) System.out.println(0);

		}
	}
	static boolean isPalindrome(String str, int start, int end) {
		while(start<=end) {
			if(str.charAt(start)!=str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

}
