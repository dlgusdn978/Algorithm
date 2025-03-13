package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1790 {

	public static void main(String[] args) throws IOException {
		// 1->9
		// 10->89
		// 100->899
		// f(x) = 9*1(x=1), 9*10^(n-1)-1 (x>1)
		
		
		// 자리수가 5개인 경우에는
		// 4개인 경우의 자리수까지 모두 n에서 제외.
		// 5자리수의 범위 내에서 (n/5)번째 수의 (자리수-나머지)값 구하면 된다.
		// 조건 1. 수의 길이가 k보다 작아서 k번째 자리가 없는 경우에는 -1 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int pow = 1;
		int val = 10;
		int digits = 0;
		char ch = ' ';
		for(int i=1; i<=n; i++) {
			if(i>=val) {
				pow++;
				val = (int) Math.pow(10, pow);
			}
			digits += pow;
			if(digits>=k) {
				String str = String.valueOf(i);
				ch = str.charAt(str.length()-(digits>k ? digits-k : 0) - 1);
				break;
			}
		}

		if(digits>=k) {
			System.out.println(ch);
		}else {
			System.out.println(-1);
		}
	}

}
