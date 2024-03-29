package b16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16235 {

	static int n, m, k;
	static int[][] curGround, curEnergy;
	static PriorityQueue<Tree> pq;
	static List<Tree> list;
	static class Tree{
		int r;
		int c;
		int age;    
		boolean isDead;
		public Tree(int r, int c, int age, boolean isDead) {
			this.r = r;
			this.c = c;
			this.age = age;
			this.isDead = isDead;
		}
	}
	static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		// 봄 : 나무가 자신의 나이만큼 양분 섭취. 나이 어린 나무부터. 섭취하면 나이 +1, 부족하면 사망. 
		// 여름 : 봄에 죽은 나무가 양분으로. 나이를 2로 나눈 값이 양분으로-
		// 가을 : 나이가 5의 배수라면 주변에 1 나무 생성.
		// 겨울 : 각 토지에 양분 추가.
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 토지 크기 n
		n = Integer.parseInt(st.nextToken());
		// 구매 묘목 수 m
		m = Integer.parseInt(st.nextToken());
		// k 년 후
		k = Integer.parseInt(st.nextToken());

		// 매년 각 토지마다 주어지는 에너지 양
		curGround = new int[n][n];
		// 현재 토지에 남아있는 에너지 양
		curEnergy = new int[n][n];
		
		// 각 과정 처리 후 나무 정보
		list = new ArrayList<Tree>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int energy = Integer.parseInt(st.nextToken());
				curGround[i][j] = energy;
				curEnergy[i][j] = 5;
			}
		}
		
		pq = new PriorityQueue<>(new Comparator<Tree>() {
			@Override
			public int compare(Tree o1, Tree o2) {
				return o1.age-o2.age;
			}
		});
		
		// 각 나무 정보 
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			pq.add(new Tree(r-1, c-1, age, false));
		}
		// k 년 경과
		for(int i=0; i<k; i++) {
			processSpring();
			processSummer();
			if(pq.isEmpty()) break;
			processFall();
			processWinter();
		}
//		for(int[] a : curEnergy) {
//			for(int b: a) {
//				System.out.print(b+" ");
//			}
//			System.out.println();
//		}
		System.out.println(pq.size());
	}

	static void processSpring() {
//		System.out.println("?");
		while(!pq.isEmpty()){
			Tree cur = pq.poll();
			// 현재 위치의 양분 값이 나무의 나이보다 적다면 사망 처리
			if(curEnergy[cur.r][cur.c]<cur.age) {
				list.add(new Tree(cur.r, cur.c, cur.age, true));
			}else {
//				System.out.println("영야ㅐㅇ분");
				curEnergy[cur.r][cur.c] -= cur.age;
				list.add(new Tree(cur.r, cur.c, cur.age+1, cur.isDead));
			}
		}
//		System.out.println(list.size());
//		while(!list.isEmpty()) {
//			pq.add(list.remove(list.size()-1));
//		}
//		System.out.println(pq.size());
	}
	static void processSummer() {
//		System.out.println("??");
		while(!list.isEmpty()) {
			Tree cur = list.remove(list.size()-1);
			if(cur.isDead) {
				curEnergy[cur.r][cur.c] += cur.age/2;
			}else {
				pq.add(cur);
			}
		}
//		while(!list.isEmpty()){
//			pq.add(list.remove(list.size()-1));
//		}
//		System.out.println(pq.size());
	}
	static void processFall() {
//		System.out.println("???");
		while(!pq.isEmpty()) {
			Tree cur = pq.poll();
			if(cur.age%5==0) {
				for(int i=0; i<8; i++) {
					int nr = cur.r+dr[i];
					int nc = cur.c+dc[i];
					if(nr>=0 && nr<n && nc>=0 && nc<n) {
						list.add(new Tree(nr, nc, 1, false));
					}
				}
			}
			list.add(cur);
		}
		while(!list.isEmpty()) {
			pq.add(list.remove(list.size()-1));
		}
	}
	static void processWinter() {
//		System.out.println("????");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				curEnergy[i][j] += curGround[i][j];
			}
		}
	}
}
