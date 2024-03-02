package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		
		int[] arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<m; i++) {
			
			int start = 0;
			int end = arr.length-1;
			int cur = arr2[i];
			boolean flag = false;
			while(start<=end) {
				int mid = (start+end)/2;
				if(cur==arr[mid]) {
					flag = true;
					break;
				}
				if(cur<arr[mid]) {
					end = mid-1;
				}else if(cur>arr[mid]) {
					start = mid+1;
				}
			}
			if(flag) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		System.out.println(sb.toString());
	}

}
