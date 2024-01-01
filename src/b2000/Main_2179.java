package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Main_2179 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 길이가 긴 문자열부터 연산을 수행하고
		// 비교 문자열이 최대 접두사 길이보다 작을 때는 continue;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		
		// 순서 비교해서 출력할 때 사용.

		for(int i=0; i<n; i++) {
			String str = br.readLine();
			list.add(str);
		}
		
		int strlen = 0;
		int comparelen = 0;
		int max = 0;
		
		for(int i=0; i<n-1; i++) {
			String str1 = list.get(i);
			for(int j=i+1; j<n; j++) {
				String str2 = list.get(j);
				int count = 0;
				int length = Math.min(str1.length(), str2.length());
				for(int k=0; k<length; k++) {
					if(str1.charAt(k)==str2.charAt(k)) {
						count++;
					}else {
						break;
					}
				}
				if(max<count) {
					max = count;
					strlen = i;
					comparelen = j;
				}
			}
		}
		System.out.println(list.get(strlen));
		System.out.println(list.get(comparelen));
	}

}
