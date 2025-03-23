package b22000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_22234 {
	
	static class Node{
		int num;
		int processTime;
		long entranceTime;
		public Node(int num, int processTime, long entranceTime) {
			this.num = num;
			this.processTime = processTime;
			this.entranceTime = entranceTime;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// ������� �մ�
		int n = Integer.parseInt(st.nextToken());
		// Ÿ������
		int t = Integer.parseInt(st.nextToken());
		// �ҿ� �ð�
		int w = Integer.parseInt(st.nextToken());
		
		// Ÿ������ 6
		// ���� �ҿ�ð��� 10�̸�, 4��ŭ ����� q�� �� �ڷ� ������
		// �� �ڷ� ���� ��, �� �ҿ��� �ð����� ������ ��� �ð��� ������ ���� q�� �־��ֱ�
		// ���� �ҿ�ð��� 5��, 5��ŭ �ð��� �ҿ��ϰ� q���� ����.
		
		// ��� ť
		Queue<Node> wq = new ArrayDeque<>();
		// ���� ���� ť
		List<Node> eq = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int processTime = Integer.parseInt(st.nextToken());
			
			wq.add(new Node(num, processTime, 0));
		}
		
		// ���� �����ϴ� �ο�
		int next = Integer.parseInt(br.readLine());
		for(int i=0; i<next; i++) {
			st= new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int processTime = Integer.parseInt(st.nextToken());
			int entranceTime = Integer.parseInt(st.nextToken());
			
			eq.add(new Node(num, processTime, entranceTime));
		}
		Collections.sort(eq, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return (int) (o1.entranceTime-o2.entranceTime);
			}
		});
		int[] timeTable = new int[w];
		long curTime = 0;
		while(curTime<w) {
			Node cur = wq.poll();
//			System.out.println(cur.num+" "+curTime);
			if(cur.processTime>t) {
				curTime += t;
				while(!eq.isEmpty()) {
					if(eq.get(0).entranceTime<=curTime) wq.add(eq.remove(0));
					else break;
				}
				wq.add(new Node(cur.num, cur.processTime-t, curTime));
			}else {
				curTime += cur.processTime;
				while(!eq.isEmpty()) {
					if(eq.get(0).entranceTime<=curTime) wq.add(eq.remove(0));
					else break;
				}
			}
			timeTable[(int) (curTime-1>=w ? w-1 : curTime-1)] = cur.num;
		}
		for(int i=timeTable.length-1; i>0; i--) {
			if(timeTable[i-1]==0) timeTable[i-1] = timeTable[i];
		} 
		StringBuilder sb = new StringBuilder();
		for(int a : timeTable) {
			sb.append(a).append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}

}
