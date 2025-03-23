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
		
		// 대기중인 손님
		int n = Integer.parseInt(st.nextToken());
		// 타임퀀텀
		int t = Integer.parseInt(st.nextToken());
		// 소요 시간
		int w = Integer.parseInt(st.nextToken());
		
		// 타임퀀텀 6
		// 업무 소요시간이 10이면, 4만큼 남기고 q의 맨 뒤로 보내기
		// 맨 뒤로 보낼 때, 총 소요한 시간보다 입장후 대기 시간이 작으면 먼저 q에 넣어주기
		// 업무 소요시간이 5면, 5만큼 시간을 소요하고 q에서 제거.
		
		// 대기 큐
		Queue<Node> wq = new ArrayDeque<>();
		// 새로 입장 큐
		List<Node> eq = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int processTime = Integer.parseInt(st.nextToken());
			
			wq.add(new Node(num, processTime, 0));
		}
		
		// 새로 입장하는 인원
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
