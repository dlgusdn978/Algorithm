package b26000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_26215 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int sum = 0;
		while(list.size()>1) {
			Collections.sort(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
			int min = list.remove(0);
			int max = list.remove(0);
			
			if(min-1>0) list.add(min-1);
			if(max-1>0) list.add(max-1);
			sum += 1;
//			System.out.println(min+" "+max+" "+list.size());
		}
		if(list.size()==1) {
			sum += list.get(0);
		}
		if(sum>1440) System.out.println(-1);
		else System.out.println(sum);
		
	}

}
