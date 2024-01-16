package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1934 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int t = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<t; tc++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			int gcd = getGCD(left, right);
			System.out.println(left*right/gcd);
		}
	}

	static int getGCD(int left, int right) {
		while(right!=0) {
			int temp = left;
			left = right;
			right = temp%right;
		}
		return left;
	}
}
