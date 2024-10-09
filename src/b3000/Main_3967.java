package b3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3967 {
	static boolean flag = false;
	static String res = "";
	public static void main(String[] args) throws IOException {
		// 매직스타 사전순으로 가장 앞서는 방법
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] alphabet = new boolean[26];
		char[] magicStar = new char[12];

		// 'A' = 65;
		char[][] arr = new char[5][9];
		int index = 0;

		for(int i=0; i<5; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				char cur = str.charAt(j);
				if(cur-65>=0 && cur-65<=25) {
					alphabet[cur-65] = true;
					magicStar[index++] = cur;
				}else if(cur=='x') magicStar[index++] = '.';
				arr[i][j] = cur;
			}
		}
//		System.out.println(Arrays.toString(magicStar));
		index = 0;
		dfs(magicStar, alphabet, 0);
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j]!='.') arr[i][j] = res.charAt(index++);
			}
		}
		for(char[] a : arr) {
			for(char b : a) {
				System.out.print(b);
			}
			System.out.println();
		}
		//     0
		// 1  2  3  4
		//   5    6
		// 7  8  9  10
		//     11
	}

	static void dfs(char[] magicStar,boolean[] alphabet, int count) {
		if(flag) return;
		if(count==5) {
			int line1 = getLineSum(magicStar[1], magicStar[2], magicStar[3], magicStar[4]);
//			System.out.println(line1);
//			System.out.println(Arrays.toString(magicStar));
			if(line1!=26) return;
		}
		if(count==8) {
			int line2 = getLineSum(magicStar[0], magicStar[2], magicStar[5], magicStar[7]);
			if(line2!=26) return;
		}
		if(count==11) {
			int line3 = getLineSum(magicStar[0], magicStar[3], magicStar[6], magicStar[10]);
			int line4 = getLineSum(magicStar[7], magicStar[8], magicStar[9], magicStar[10]);
			if(line3!=26) return;
			if(line4!=26) return;
		}
		if(count==12) {
			int line5 = getLineSum(magicStar[1], magicStar[5], magicStar[8], magicStar[11]);
			int line6 = getLineSum(magicStar[4], magicStar[6], magicStar[9], magicStar[11]);
			if(line5!=26) return;
			if(line6!=26) return;
//			System.out.println(Arrays.toString(magicStar));
			flag = true;
			for(char c : magicStar) {
				res+=c;
			}
			return;
		}
//		System.out.println(Arrays.toString(magicStar));
		if(magicStar[count]!='.') dfs(magicStar, alphabet, count+1);
		else {
			for(int j=0; j<alphabet.length; j++) {
				if(alphabet[j]) continue;
				alphabet[j] = true;
				magicStar[count] = (char) (j+65);
				dfs(magicStar, alphabet, count+1);
				magicStar[count] = '.';
				alphabet[j] = false;
			}
		}
	}
	static int getLineSum(char c1, char c2, char c3, char c4) {
		int sum = (c1-64)+(c2-64)+(c3-64)+(c4-64);
		return sum;
	}
}
