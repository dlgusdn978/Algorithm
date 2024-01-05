package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2607 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[26];
//		System.out.println('A'-65);

		// 첫 번째 문자열
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			arr[str.charAt(i)-65] += 1;
		}
		
//		System.out.println(Arrays.toString(arr));
		int count = 0;
		
		for(int i=0; i<n-1; i++) {
			boolean flag = true;
			String temp = br.readLine();
//			System.out.println(temp);
			int diff = 0;
			int[] temp2 = new int[26];
			for(int j=0; j<temp.length(); j++) {
				temp2[temp.charAt(j)-65] += 1;
			}
			
			for(int j=0; j<26; j++) {
					if(arr[j]!=temp2[j]) {
						diff+= Math.abs(arr[j]-temp2[j]);
						flag = false;
					}else {
						diff+=Math.abs(arr[j]-temp2[j]);
					}
			}
//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(temp2));
			if(flag) {
				count++;
//				System.out.println(temp);
			}
			else {
				if(diff<=1) {
					count++;
//					System.out.println(temp+"?");
				}
				else if(diff<=2 && Math.abs(str.length()-temp.length())<1) {
					count++;
//					System.out.println(temp);
				}
				
			}
		}
		System.out.println(count);
	}

}
