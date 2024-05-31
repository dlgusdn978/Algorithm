package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main_2910 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		// 위치
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// 개수
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		int index = 0;
		// 알아야 할 정보
		// 1. 해당 num 의 위치
		// 2. 해당 num의 개수
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!map.containsKey(num)) {
				map.put(num, map.size());
				map2.put(num, 1);
			}else map2.put(num, map2.get(num)+1);
			list.add(num);
		}
		
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return map2.get(o2)==map2.get(o1) ? map.get(o1)-map.get(o2):map2.get(o2)-map2.get(o1);
			}
		});

		for(int a : list) {
			sb.append(a+" ");
		}
		System.out.println(sb.toString());
	}

}
