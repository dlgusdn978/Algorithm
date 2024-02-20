package b18000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_18291 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//tc  ¼ö
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			long res = fastExponentiation(2, num-2, 1000000007);
			System.out.println(res);
		}

	}

	static long fastExponentiation(long base, long exponent, long modulus) {
		long res = 1;
		base = base % modulus;
		
		while(exponent>0) {
			if((exponent & 1) == 1) {
				res = (res * base) % modulus;
			}
			
			exponent = exponent >> 1;
			base = (base * base) % modulus;
		}
		return res;
	}
}
