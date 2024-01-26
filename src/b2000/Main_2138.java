package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2138 {

	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		
		char[] cur = br.readLine().toCharArray();
		
		char[] next = br.readLine().toCharArray();
		char[] copy = cur.clone();
		copy[0] = copy[0]=='0' ? '1' : '0';
		copy[1] = copy[1]=='0' ? '1' : '0';
		boolean[] visit = new boolean[cur.length];

		int count = 0;
		boolean flag = true;
		
		int res1 = checker(cur, next);
		int res2 = checker(copy, next);
		if(res2!=-1) res2++;
		if(res1 == -1) {
			System.out.println(res2);
		}else if(res2 == -1) {
			System.out.println(res1);
		}else {
			System.out.println(Math.min(res1, res2));
		}
		
		
	}

	
	static int checker(char[] arr1, char[] arr2) {
		int count = 0;
		for(int i=0; i<n-1; i++) {
			if(arr1[i]!=arr2[i]) {
				count++;
				arr1[i] = arr1[i]=='0' ? '1' : '0';
				arr1[i+1] = arr1[i+1]=='0' ? '1' : '0';
				if(i!=n-2) {
					arr1[i+2] = arr1[i+2]=='0' ? '1' : '0';
				}
			}
		}
		return arr1[n-1]!=arr2[n-1] ? -1 : count;
	}
}
