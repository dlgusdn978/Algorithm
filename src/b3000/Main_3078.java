package b3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3078 {

	public static void main(String[] args) throws IOException {
		// 자신과 반 등수의 차이가 k 를 넘으면 친구가 아니다.
		// 등수의 차이가 k보다 작거나 같으면서 이름의 길이가 같아야 함.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// 이름의 길이
		int[] names = new int[n];
		// k 범위 내 이름의 이름 길이 리스트
		int[] nameLength = new int[21];
		
		for(int i=0; i<n; i++) {
			names[i] = br.readLine().length();
		}
		
		for(int i=0; i<=(k==n ? k-1 : k); i++) {
			nameLength[names[i]]+=1;
		}
		
//		System.out.println(Arrays.toString(nameLength));

		long count = 0;
		
		int start = 0;
		int end = (k==n ? k-1 : k);
		
		while(start<end) {
			count+= nameLength[names[start]]-1;
			
			nameLength[names[start]] -= 1;
			start++;
			
			if(end!=n-1) {
				end++;
				nameLength[names[end]] += 1;
			}
		}
		System.out.println(count);
	}

}
