package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1422 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// k개의 자연수
		int k = Integer.parseInt(st.nextToken());
		
		// 자연수 중에서 n개의 수를 선택
		int n = Integer.parseInt(st.nextToken());
		int max = Integer.MIN_VALUE;
		
		List<BigInteger> b = new ArrayList<BigInteger>();
		for(int i=0; i<k; i++) {
			String str = br.readLine();
			int temp = Integer.parseInt(str);
			b.add(new BigInteger(str));
			max = Math.max(max, temp);
		}

		for(int i=0; i<n-k; i++) {
			b.add(new BigInteger(Integer.toString(max)));
		}
		
		
		Collections.sort(b, new Comparator<BigInteger>() {

			@Override
			public int compare(BigInteger o1, BigInteger o2) {
				// TODO Auto-generated method stub
				BigInteger o3 = new BigInteger(o1.toString()+o2.toString());
				BigInteger o4 = new BigInteger(o2.toString()+o1.toString());
				return o4.compareTo(o3);
			}
		});
		String str = "";
		for(BigInteger a : b) {
			str+=a.toString();
		}
		// 기본 계산 결과
		System.out.println(str);

	}

}
