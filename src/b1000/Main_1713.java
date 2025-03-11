package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1713 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		// queue + map

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// ����Ʋ ��
		int n = Integer.parseInt(br.readLine());
		// ��õ ��
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(q.contains(num)) {
				// add
				add(map, num);
			}else {
				if(q.size()>=n) {
					// ���� ������ �� ����
					remove(q, map);
					// add
				}
				add(map,num);
				q.add(num);
			}
			
		}
		List<Integer> list = new ArrayList<>();
		while(!q.isEmpty()) {
			list.add(q.poll());
		}
		Collections.sort(list);
		for(int a : list) {
			System.out.print(a+" ");
		}
	}

	static void add(Map<Integer, Integer> map, int num) {
		if(map.containsKey(num)) map.put(num, map.get(num)+1);
		else map.put(num, 1);
	}
	
	static void remove(Queue<Integer> q, Map<Integer, Integer> map) {
		int num = 0;
		int cnt = Integer.MAX_VALUE;
		// ��õ�� ���� �л� ���� ��
		for(int i=0; i<q.size(); i++) {
			int cur = q.poll();
			if(map.get(cur)<cnt) {
				num = cur;
				cnt = map.get(cur);
			}
			q.add(cur);
		}
		q.remove(num);
		map.remove(num);
	}
}
