package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Main_1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(arr));

		int start = 0;
		int end = 0;
		int total = 0;
		int length = Integer.MAX_VALUE;
		while(true) {
//			System.out.println(start+" "+end);
			if(total>=s) {
				length = Math.min(length, end-start);
				total -= arr[start++];
				
			}else if(end==n){
				break;
			}else {
				total += arr[end++];
			}
			
		}
		System.out.println(length==Integer.MAX_VALUE ? 0 : length);
	}

}
