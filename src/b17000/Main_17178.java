package b17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17178 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<String> s = new Stack<String>();
		List<String> list = new ArrayList<>();
		Queue<String> q = new ArrayDeque<>();
		String last = "A-000";
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				String temp = st.nextToken();
				list.add(temp);
				q.add(temp);
	
			}
			
		}

		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.split("-")[0].compareTo(o2.split("-")[0])<0) {
					return -1;
				}else if(o1.split("-")[0].compareTo(o2.split("-")[0])>0) {
					return 1;
				}else {
					return Integer.parseInt(o1.split("-")[1])-Integer.parseInt(o2.split("-")[1]);
				}
			}
		});
		int index = 0;
		while(!q.isEmpty()) {
			String cur = q.poll();
			
			while(!s.isEmpty()) {
				if(compare(cur, s.peek())) {
					String pre = s.pop();
					if(pre!=list.get(index++)) break; 
				}else break;
			}
			s.push(cur);
		}

		while(!s.isEmpty()) {
			String cur = s.pop();
			if(cur!=list.get(index++)) break;
		}
//		System.out.println(s.size());
//		for(String a : s) {
//			System.out.println(a);
//		}
		if(index==n*5)System.out.println("GOOD");
		else System.out.println("BAD");
	}

	
	static boolean compare(String str1, String str2) {
		// str1이 더 클 때 true
		if(str1.split("-")[0].compareTo(str2.split("-")[0])>0) {
			return true;
		}else if(str1.split("-")[0].compareTo(str2.split("-")[0])<0) {
			return false;
		}else {
			return Integer.parseInt(str1.split("-")[1]) > Integer.parseInt(str2.split("-")[1]) ? true : false;
		}
	}
}
