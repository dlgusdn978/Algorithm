package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2437 {

	public static void main(String[] args) throws IOException {
		// 1 1 2 3 6 7 30
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
//		System.out.println(Arrays.toString(arr));
		
		int max = 0;
		for(int i=0; i<n; i++) {
			int cur = arr[i];
//			System.out.println(max+" "+cur);
			if(cur>max+1) {
				break;
			}
			max+=cur;
		}
		System.out.println(max+1);
	}

}
