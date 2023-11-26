package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1037 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		//16
		//2 4 8 
		//진짜 약수가 홀수 개라면 n/2 번째의 제곱
		//24
		//2 3 4 6 8 12
		//진짜 약수가 짝수 개라면
		//n/2 -1 * n/2 
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int result = 0;
		if(n%2==0) {
			result = arr[n/2-1] * arr[n/2];
		}else {
			result = (int) Math.pow(arr[n/2], 2);
		}
		System.out.println(result);
	}

}
