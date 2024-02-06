package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_1786 {

	static char[] t;
	static char[] p;
	static int[] pi;
	static int total;
	public static void main(String[] args) throws IOException {
		// 문자열 매칭
		// 접두사와 접미사의 최대 공통 문자 길이를 구하고, 
		// 일치하지 않을 때는 접미사의 위치로 이동.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = br.readLine().toCharArray();
		p = br.readLine().toCharArray();
		pi = getSubset();
		ArrayList<Integer> res = kmp();
		// 그러면, 일치하지 않는 경우에는 일치하는 문자열까지만 끊어서
		// suffix==prefix 를 구하고, 해당 위치로 이동하는 방식?
		
		// 인덱스를 0부터 시작.
		// 일치 카운트 세고,
		// 카운트 == str.length 라면 total +1 하고, 아니라면 prefix==suffix 비교하러.
		System.out.println(res.size());
		for(int a : res) {
			System.out.println(a+1);
		}
		
	}
	
	static ArrayList<Integer> kmp() {
		int count = 0;
		ArrayList<Integer> list = new ArrayList<>();
		int j=0;
		for(int i=0; i<t.length; i++) {
			while(j>0 && t[i] != p[j]) {
				j = pi[j-1];
			}
			if(t[i]==p[j]) {
				if(j==p.length-1) {
					list.add(i-j);
					j = pi[j];
				}else {
					j++;
				}
			}
		}
		return list;
	}
	static int[] getSubset() {
		int[] pi = new int[p.length];
		int j=0;
		for(int i=1; i<p.length; i++) {
			while(j>0 && p[i] != p[j]) {
				j = pi[j-1];
			}
			if(p[i]==p[j]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
}
