package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
		
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		
		// pq 2���� ����ؼ� Ǯ��?
		// pq1���� ��� ������ ���� ���ڵ��� ������. �������� ����
		// pq2���� ��� ������ ū ���ڵ��� ������. �������� ����
		
		int n = Integer.parseInt(br.readLine());
		int mid = 0;
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(i==0) {
				mid = num;
			}else {
				if(num<mid) {
					pq.add(num);
					if(pq.size()>=pq2.size()+2) {
						pq2.add(mid);
						mid = pq.poll();
					}
				}else if(num>=mid) {
					pq2.add(num);
					if(pq2.size()>=pq.size()+2) {
						pq.add(mid);
						mid = pq2.poll();
					}
				}
			}
			// ������ ������ Ȧ���� ���� ���� ó�� ����
			// pq�� pq2�� ������� Ŭ ��, pq.peek�� ��� ����
			
			if(i%2==0) {
				sb.append(mid).append("\n");
			}else {
				if(pq.size()>pq2.size()) {
					sb.append(pq.peek()).append("\n");
				}else {
					sb.append(mid).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
		
	}

}
