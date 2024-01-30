package b15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_15903 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		// ī�� ��
		int n = Integer.parseInt(st.nextToken());
		// ī�� ��ü ��
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		for(int i=0; i<m; i++) {
			Long left = pq.poll();
			Long right = pq.poll();
			Long sum = left+right;
			pq.add(sum);
			pq.add(sum);
		}
		
		// ��ü 1000000
		// ���� 1000
		// ī�� ��ü 15000
		// 30���� ��ü
		// 2 4 8 16 32 64 128 256 512 1024 2048 4096 8192 16384 32768 65536 
		
		Long total = 0L;
		for(Long a : pq) {
			total+=a;
		}
		System.out.println(total);
		
	}

}
