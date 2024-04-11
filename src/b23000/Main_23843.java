package b23000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_23843 {

	public static void main(String[] args) throws IOException {
		// n개의 전자기기
		// 콘센트 m개
		// 한번에 하나만 충전 가능
		// 모든 전자 기기를 충전하기 위한 최소 시간.
		

		
		// case 1. 충전 시간이 가장 높은 기기가 우선순위 높을 때.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 전자기기 개수
		int n = Integer.parseInt(st.nextToken());
		// 충전 개수
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		// 입력 검증
//		for(int a : pq) {
//			System.out.println(a);
//		}
		int count = 0;
		while(pq.size()>=m) {
			List<Integer> list = new ArrayList<Integer>();
			
			int min = Integer.MAX_VALUE;
			for(int i=0; i<m; i++) {
				int cur = pq.poll();
				min = Math.min(cur, min);
				list.add(cur);
			}
			for(int i=0; i<m; i++) {
				int next = list.remove(0);
				if(next-min>0) pq.add(next-min);
			}
			
			count += min;
			
		}
		if(!pq.isEmpty()) {
			int max = Integer.MIN_VALUE;
			for(int a: pq) {
				max = Math.max(max, a);
			}
			count += max;
		}
		
		System.out.println(count);
		
		
	}

}
