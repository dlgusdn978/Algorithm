package b2000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2251 {

	static int aMax, bMax, cMax;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		
		aMax = Integer.parseInt(st.nextToken());
		bMax = Integer.parseInt(st.nextToken());
		cMax = Integer.parseInt(st.nextToken());
		
		// c에만 물이 가득 차있는 상태
		// 만약 c에 물에 차있을 때, 해당 용량이 이미 기록된 경우 리턴?
		List<Integer> cVal = new ArrayList<Integer>();
		Set<String> set = new HashSet<>();
		pour(set, cVal, 0, 0, cMax);
		Collections.sort(cVal);
		for(int a: cVal) {
			System.out.println(a);
		}
	}
	static void pour(Set<String> set, List<Integer> cVal, int a, int b, int c) {
		String str = a+" "+b+" "+c;
		if(set.contains(str)) return;
		if(a==0) cVal.add(c);
		set.add(str);
		// 경우의 수를 나눠야 함
		// 1. a 항아리 물 양 모두를 b에 부을 수 있는 경우
		// 2. a 항아리 물 양 일부만 b에 부을 수 있는 경우
		// bMax-b 값이 b에 더 부을 수 있는 양 =  Math.min(bMax-b, a)
		// 
		//a에서 다른 항아리로 붓는 경우
		if(a!=0) {
			int pourAtoB = Math.min(bMax-b, a);
			int pourAtoC = Math.min(cMax-c, a);
			if(pourAtoB!=0) pour(set, cVal, a-pourAtoB, b+pourAtoB, c);
			if(pourAtoC!=0) pour(set, cVal, a-pourAtoC, b, c+pourAtoC);
		}
		if(b!=0) {
			int pourBtoA = Math.min(b, aMax-a);
			int pourBtoC = Math.min(cMax-c, b);
			if(pourBtoA!=0) pour(set, cVal, a+pourBtoA, b-pourBtoA, c);
			if(pourBtoC!=0) pour(set, cVal, a, b-pourBtoC, c+pourBtoC);
		}
		if(c!=0) {
			int pourCtoA = Math.min(aMax-a, c);
			int pourCtoB = Math.min(bMax-b, c);
			if(pourCtoA!=0) pour(set, cVal, a+pourCtoA, b, c-pourCtoA);
			if(pourCtoB!=0) pour(set, cVal, a, b+pourCtoB, c-pourCtoB);
		}
		
	}
}
