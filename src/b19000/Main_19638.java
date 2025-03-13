package b19000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_19638 {

	public static void main(String[] args) throws IOException {
		// ��ġ�� �¾��� �� Ű�� ���丷
		// �α��� 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// ����
		// �켱���� ť ��� ������������.
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
			
		});
		
		// ���γ��� �α��� n
		int n = Integer.parseInt(st.nextToken());
		// ��Ƽ�� Ű m
		int m = Integer.parseInt(st.nextToken());
		// �и�ġ ��� Ƚ�� ����
		int k = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) {
			// ������ Ű�� �̹� ��Ƽ���� ���� ���� ����.
			int height = Integer.parseInt(br.readLine());
			if(m<=height) pq.add(height);
		}
		
		int cnt = 0;
		// while�� ����. q.isempty �ų�, �и�ġ ��밡�� Ƚ���� 0�� �� ����
		// while ���� ���ο��� ��Ҹ� 1/2�� ��, �ش� ��Ұ� ��Ƽ�� Ű���� ũ�ų� ������ �ٽ� �ְ�, ������ ����.		
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
