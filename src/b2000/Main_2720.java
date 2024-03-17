package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2720 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = {25, 10, 5, 1};
		for(int i=0; i<n; i++) {
			int money = Integer.parseInt(br.readLine());
			
			for(int j=0; j<arr.length; j++) {
				sb.append(money/arr[j]+" ");
				money = money%arr[j];
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
