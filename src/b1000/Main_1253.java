package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1253 {

	static int n;
	static int[] arr;
	static boolean[] visit;
	static int count;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Á¤·ÄÇØ¾ßµÊ
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		visit = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length; i++) {
			int start = 0;
			int end = arr.length-1;
			
			while(start<end) {
				if(start==i) start++;
				else if(end==i)end--;
				else {
					int mid = arr[start]+arr[end];
					if(mid == arr[i]) {
						count++;
						break;
					}else if(mid>arr[i]) {
						end--;
					}else {
						start++;
					}
				}
			}
		}
		System.out.println(count);
	}

	

}
