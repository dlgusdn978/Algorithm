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
		// �� : ������ �ڽ��� ���̸�ŭ ��� ����. ���� � ��������. �����ϸ� ���� +1, �����ϸ� ���. 
		// ���� : ���� ���� ������ �������. ���̸� 2�� ���� ���� �������-
		// ���� : ���̰� 5�� ������ �ֺ��� 1 ���� ����.
		// �ܿ� : �� ������ ��� �߰�.
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// ���� ũ�� n
		n = Integer.parseInt(st.nextToken());
		// ���� ���� �� m
		m = Integer.parseInt(st.nextToken());
		// k �� ��
		k = Integer.parseInt(st.nextToken());

		// �ų� �� �������� �־����� ������ ��
		curGround = new int[n][n];
		// ���� ������ �����ִ� ������ ��
		curEnergy = new int[n][n];
		
		// �� ���� ó�� �� ���� ����
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
		
		// �� ���� ���� 
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			pq.add(new Tree(r-1, c-1, age, false));
		}
		// k �� ���
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
			// ���� ��ġ�� ��� ���� ������ ���̺��� ���ٸ� ��� ó��
			if(curEnergy[cur.r][cur.c]<cur.age) {
				list.add(new Tree(cur.r, cur.c, cur.age, true));
			}else {
//				System.out.println("���ߤ�����");
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
