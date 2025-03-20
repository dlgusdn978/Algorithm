package b20000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_20006 {

	static class Node{
		int level;
		String str;
		public Node(int level, String str) {
			this.level = level;
			this.str = str;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<Node>> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			if(!findRoom(list, p, str, m)) openRoom(list, p, str);
		}
		StringBuilder sb = new StringBuilder();
		for(List<Node> l : list) {
			Collections.sort(l, new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return o1.str.compareTo(o2.str);
				}
			});
			if(l.size()==m) sb.append("Started!").append("\n");
			else sb.append("Waiting!").append("\n");
			
			for(Node player : l) {
				sb.append(player.level+" "+player.str).append("\n");
			}
		}
		System.out.println(sb.toString().trim());
	}
	static void openRoom(List<List<Node>> list, int p, String str) {
		list.add(new ArrayList<>());
		list.get(list.size()-1).add(new Node(p, str));
	}
	static boolean findRoom(List<List<Node>> list, int p, String str, int m) {
		boolean flag = false;
		for(int i=0; i<list.size(); i++) {
			int leader = list.get(i).get(0).level;
			if(list.get(i).size()<m && match(leader, p)) {
				list.get(i).add(new Node(p, str));
				flag = true;
				break;
			}
		}
		return flag;
	}
	static boolean match(int p1, int p2) {
		if(Math.abs(p1-p2)<=10) return true;
		else return false;
	}
}
