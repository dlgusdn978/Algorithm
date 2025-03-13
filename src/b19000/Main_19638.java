package b19000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_19638 {

	public static void main(String[] args) throws IOException {
		// 망치로 맞았을 때 키가 반토막
		// 인구수 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 로직
		// 우선순위 큐 사용 내림차순으로.
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
			
		});
		
		// 거인나라 인구수 n
		int n = Integer.parseInt(st.nextToken());
		// 센티의 키 m
		int m = Integer.parseInt(st.nextToken());
		// 뿅망치 사용 횟수 제한
		int k = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) {
			// 거인의 키가 이미 센티보다 작은 경우는 제외.
			int height = Integer.parseInt(br.readLine());
			if(m<=height) pq.add(height);
		}
		
		int cnt = 0;
		// while문 수행. q.isempty 거나, 뿅망치 사용가능 횟수가 0일 때 종료
		// while 로직 내부에는 요소를 1/2한 뒤, 해당 요소가 센티의 키보다 크거나 같으면 다시 넣고, 작으면 제외.		
		while(!pq.isEmpty() && cnt!=k) {
			int cur = pq.poll();
			if(cur>=m) {
				int next = cur/2;
				if(cur==1) pq.add(1);
				else if(next>=m) pq.add(next);
				cnt++;
			}
		}
		
		if(pq.isEmpty()) {
			System.out.println("YES");
			System.out.println(cnt);
		}else {
			System.out.println("NO");
			System.out.println(pq.poll());
		}
	}

}
