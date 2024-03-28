package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Main_1043 {

	static int n;
	static int m;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 제일 많은 인원이 방문하는 파티부터 순서대로 정렬.
		// boolean flag 를 확인하여 마지막까지 true라면 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
	
		int know = Integer.parseInt(st.nextToken());
		int groupCount = 0;
		List<Integer> knowPeople = new ArrayList<>();
		if(know!=0) {
			for(int i=0; i<know; i++) {
				knowPeople.add(Integer.parseInt(st.nextToken()));
			}
			
			List<Integer>[] party = new ArrayList[m];
			makeSet();
			
			if(knowPeople.size()>=2) {
				for(int i=0; i<knowPeople.size()-1; i++) {
					union(knowPeople.get(i), knowPeople.get(i+1));
				}
			}
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				party[i] = new ArrayList<>();
				int count = Integer.parseInt(st.nextToken());
				for(int j=0; j<count; j++) {
					party[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			for(int i=0; i<m; i++) {
				if(party[i].size()>=2) {
					for(int j=0; j<party[i].size()-1; j++) {
						union(party[i].get(j), party[i].get(j+1));
					}
				}
			}
			
			for(int i=0; i<m; i++) {
				int knowPerson = knowPeople.get(0);
				boolean flag = true;
				for(int j=0; j<party[i].size(); j++) {
					int participant = party[i].get(j);
					if(findSet(knowPerson)==findSet(participant)) {
						flag = false;
					}
				}
				if(flag) groupCount++;
			}
			
			System.out.println(groupCount);
		}else {
			System.out.println(m);
			return;
		}
		
		
		
		
	}

	static void makeSet() {
		parents = new int[n+1];
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int v1) {
		if(v1==parents[v1]) return v1;
		else return parents[v1] = findSet(parents[v1]);
	}
	
	static boolean union(int v1, int v2) {
		int aRoot = findSet(v1);
		int bRoot = findSet(v2);
		if(aRoot==bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}
