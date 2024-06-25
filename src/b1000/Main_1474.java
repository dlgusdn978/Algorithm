package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1474 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 단어의 수 n
		int n = Integer.parseInt(st.nextToken());
		// 총 길이 m
		int m = Integer.parseInt(st.nextToken());

		int count = 0;
		String[] strs = new String[n];
		for(int i=0; i<n; i++) {
			strs[i] = br.readLine();
			count += strs[i].length();
		}
		
		// _로 채울 문자열
		int rem = m-count;
		
		// _문자 집합 개수 share
		int share = rem/(n-1);
		// _문자 집합을 제외한 나머지 add
		int add = rem%(n-1);
		// _ 기본집합 개수
		int basic = (n-1)-add;
		
		// 붙일 문자열 con
		String con = "";
		for(int i=0; i<share; i++) {
			con+="_";
		}
//		System.out.println(add+" "+basic);
		String res = strs[0];
		for(int i=1; i<n; i++) {
			if(add !=0 && basic != 0) {
				String temp1 = con+"_"+strs[i];
				String temp2 = con+strs[i];
				if(temp1.compareTo(temp2)>=0) {
					res += temp2;
					basic--;
				}else {
					res += temp1;
					add--;
				}
			}else {
				if(basic==0) {
					res+=con+"_"+strs[i];
				}else {
					res+=con+strs[i];
				}
			}
		}
		System.out.println(res);
		
		
	}

}
