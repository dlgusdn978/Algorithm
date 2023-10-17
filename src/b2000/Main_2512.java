package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2512 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		int total = 0;
		for(int i=0; i<n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			total += temp;
			arr[i] = temp;
		}

		int max = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		if(max>=total) {
			System.out.println(arr[arr.length-1]);
		}else {
			
			int start = 0;
			int end = arr[arr.length-1];
			
			while(start<end) {
				int mid = (start+end)/2;
				if(start == mid || end==mid) break;
				// รัวี
				int count = 0;
				for(int a : arr) {
					count += (a < mid ? a : mid);
					
				}
				
				
				if(count>max) {
					end = mid;
				}else {
					start = mid;
				}
			}
			System.out.println(start);
		}
		
	}

}
