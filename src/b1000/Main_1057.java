package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1057 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 참가자 수
		int num = Integer.parseInt(st.nextToken());
		// 지민이 번호
		int s = Integer.parseInt(st.nextToken());
		// 한수 번호
		int e = Integer.parseInt(st.nextToken());
		
		int count = 0;
		while(s!=e) {
			s = s%2==1 ? (s+1)/2 : s/2;
			e = e%2==1 ? (e+1)/2 : e/2;
			count++;
		}
		System.out.println(count);

	}

}
