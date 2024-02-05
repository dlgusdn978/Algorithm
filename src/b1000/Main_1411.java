package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main_1411 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] arr = new String[n];

		for(int i=0; i<n; i++) {
			arr[i] = br.readLine();
		}
		int count = 0;
		// aa,bb
		// aa,cc
		// bb,cc
		// ab,cd
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				Map<Character, Character> map = new HashMap<>();
				char[] a = arr[i].toCharArray();
				char[] b = arr[j].toCharArray();
//				System.out.println(Arrays.toString(a));
//				System.out.println(Arrays.toString(b));
				// 먼저 같은 문자가 존재하는 경우 선점.
				for(int k=0; k<a.length; k++) {
					if(a[k]==b[k]) map.put(a[k], b[k]);
				}
				// 다른 문자일 때 치환 값 입력
				for(int k=0; k<a.length; k++) {
					if(a[k]!=b[k]) {
						if(!map.containsKey(a[k])&&!map.containsValue(b[k])) {
							map.put(a[k], b[k]);
						}
					}
				}
				// 값 변경
				for(int k=0; k<a.length; k++) {
					if(a[k]!=b[k]) {
						if(map.containsKey(a[k])) a[k] = map.get(a[k]);
					}
				}
				// 일치 비교
				boolean flag = true;
				for(int k=0; k<a.length; k++) {
					if(a[k]!=b[k]) flag = false;
				}
				if(flag) count++;
//				System.out.println();
			}
		}
		System.out.println(count);
	}

}
