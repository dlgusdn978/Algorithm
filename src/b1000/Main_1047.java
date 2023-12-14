package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1047 {

	static class Node{
		int r;
		int c;
		int weight;
		int index;
		public Node(int r, int c, int weight, int index) {
			this.r = r;
			this.c = c;
			this.weight = weight;
			this.index = index;
		}
		
	}
	static List<Node> list, listR, listC;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		list = new ArrayList<>();
		listR = new ArrayList<>();
		listC = new ArrayList<>();
		// 나무 수
		int n = Integer.parseInt(br.readLine());
		// 나무 좌표, 만들 수 있는 울타리 갯수
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.add(new Node(r, c, weight, i));
			listR.add(new Node(r, c, weight, i));
			listC.add(new Node(r, c, weight, i));
		}
		
		Collections.sort(listR, new Comparator<Node>(){

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.r == o2.r ? Integer.compare(o1.c, o2.c) : Integer.compare(o1.r, o2.r);
			}
			
		});
		
		Collections.sort(listC, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.c == o2.c ? Integer.compare(o1.r, o2.r) : Integer.compare(o1.c, o2.c);
			}
			
		});
		
		int[] checker = new int[41];
		ArrayList<Integer> listW = new ArrayList<>();
		int res = Integer.MAX_VALUE;
		
		for(int ri=0; ri<n; ri++) {
			for(int rj=ri; rj<n; rj++) {
				for(int ci=0; ci<n; ci++) {
					for(int cj=ci; cj<n; cj++) {
						
						Arrays.fill(checker, 0);
						listW.clear();
						
						int minR = Math.min(Math.min(listR.get(ri).r, listR.get(rj).r), Math.min(listC.get(ci).r, listC.get(cj).r));
						int maxR = Math.max(Math.max(listR.get(ri).r, listR.get(rj).r), Math.max(listC.get(ci).r, listC.get(cj).r));
						int minC = Math.min(Math.min(listR.get(ri).c, listR.get(rj).c), Math.min(listC.get(ci).c, listC.get(cj).c));
						int maxC = Math.max(Math.max(listR.get(ri).c, listR.get(rj).c), Math.max(listC.get(ci).c, listC.get(cj).c));
						
						int round = (maxR-minR+maxC-minC)*2;
						int count = 0;
						int length = 0;
						
						for(int i=0; i<n; i++) {
							int r = list.get(i).r;
							int c = list.get(i).c;
							int w = list.get(i).weight;
							
							if(r >= minR && r <= maxR && c>= minC && c<= maxC) {
								listW.add(w);
							}else {
								count++;
								length+=w;
							}
						}
						
						Collections.sort(listW);
						
						while(round>length && !listW.isEmpty()) {
							length += listW.get(listW.size()-1);
							count++;
							listW.remove(listW.size()-1);
						}
						
						if(round <= length) {
							res = Math.min(res, count);
						}
					}
				}
			}
		}
		System.out.println(res);
	}


}
