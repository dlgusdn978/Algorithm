package b9000;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main_9202 {

	static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
	static class TrieNode{
		Map<Character, TrieNode> map;
		boolean isEndOfWord;
		public TrieNode() {
			map = new HashMap<>();
			isEndOfWord = false;
		}
	}
	
	static class Trie{
		public TrieNode root;
		public Trie() {
			root = new TrieNode();
		}
		public void insert(String word) {
			TrieNode cur = root;
			for(char ch : word.toCharArray()) {
				cur = cur.map.computeIfAbsent(ch, c -> new TrieNode());
			}
			cur.isEndOfWord = true;
		}
		public boolean getStartWord(char start) {
			TrieNode cur = root;
			for(char ch : cur.map.keySet()) {
				if(start==ch) return true;
			}
			return false;
		}
		public boolean search(String word, boolean flag) {
			TrieNode cur = root;
			for(char ch : word.toCharArray()) {
				if(!cur.map.containsKey(ch)) return false;
				cur = cur.map.get(ch);
			}
			if(flag) {
				return cur.isEndOfWord;
			}
			return true;
			
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		// d d d d
		// d d d d
		// d d d d
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		Trie root = new Trie();

		for(int i=0; i<n; i++) {
			String str = br.readLine();		
			root.insert(str);

		}
		br.readLine();

		int boggleCount = Integer.parseInt(br.readLine());
		for(int i=0; i<boggleCount; i++) {
			
			char[][] arr = new char[4][4];
			for(int j=0; j<4; j++) {
				arr[j] = br.readLine().toCharArray();
			}
			br.readLine();
			Set<String> set = new HashSet<>();
			boolean[][] visited;
			for(int r=0; r<4; r++) {
				for(int c=0; c<4; c++) {
					if(!root.getStartWord(arr[r][c])) continue;
					String str = "";
					visited = new boolean[4][4];
					visited[r][c] = true;
					dfs(root, set, arr, visited, str+arr[r][c], r, c);
				}
			}
			String str = "";
			int score = 0;
			for(String word:set) {
				score += getScore(word);
				if(word.length()>str.length()) {
					str = new String(word);
				}
				if(word.length()==str.length()) {
					str = str.compareTo(word)<0 ? new String(str) : new String(word); 
				}
			}

			sb.append(score+" "+str+" "+set.size()).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void dfs(Trie trie, Set<String> set, char[][] boggle, boolean[][] visited, String str, int r, int c) {
		if(trie.search(str, true)) set.add(str);
		
		visited[r][c] = true;
		for(int i=0; i<8; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<4 && nc>=0 && nc<4 && !visited[nr][nc] && trie.search(str+boggle[nr][nc], false)) {
				dfs(trie, set, boggle, visited, str+boggle[nr][nc], nr, nc);
			}
		}
		visited[r][c] = false;
	}
	static int getScore(String word) {
		int len = word.length();
		if(len<=2) return 0;
		if(len<=4) return 1;
		if(len==5) return 2;
		if(len==6) return 3;
		if(len==7) return 5;
		return 11;
	}
}
