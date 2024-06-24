package b1000;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1105 {

	public static void main(String[] args) {
		// 각 자리수가 다르면 0개
		// 각 자리수가 같으면 자릿수 별로 비교해서 둘 다 8인 경우 +1개
		Scanner sc = new Scanner(System.in);
		String[] strs = sc.nextLine().split(" ");
		
		int count = 0;
		if(strs[0].length()==strs[1].length()) {
			for(int i=0; i<strs[0].length(); i++) {
				if(strs[0].charAt(i)==strs[1].charAt(i)) {
					if(strs[0].charAt(i)=='8') count++;
				}else break;
			}
		}
		System.out.println(count);
		
		

	}

}
