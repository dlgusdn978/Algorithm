package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1477{

	static int n, m, l;
	static List<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 현재 휴게소 개수
		n = Integer.parseInt(st.nextToken());
		// 추가할 휴게소 개수
		m = Integer.parseInt(st.nextToken());
		// 총 길이
		l = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		list.add(0);
		list.add(l);
		Collections.sort(list);
		
		int left = 1;
		int right = l;
		while(left<=right) {
			int mid = (left+right)/2;
			if(checker(mid)) left = mid+1;
			else right = mid-1;
		}
		System.out.println(left);
	}
	static boolean checker(int mid) {
		int count = 0;
		for(int i=1; i<list.size(); i++) {
			count+= (list.get(i)-list.get(i-1)-1)/mid;
		}
		if(count>m) return true;
		else return false;
	}

}
