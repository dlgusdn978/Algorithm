package b14000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_14725 {

	static class TrieNode{
		Map<String, TrieNode> map;
		boolean isEndOfWord;
		public TrieNode() {
			map = new HashMap<>();
			isEndOfWord = false;
		}
	}
	static class Trie{
		TrieNode root;
		StringBuilder sb;
		public Trie() {
			root = new TrieNode();
			sb = new StringBuilder();
		}
		public void insert(String str) {
			TrieNode root = this.root;
			String[] strs = str.split(" ");
			for(int i=1; i<=Integer.parseInt(strs[0]); i++) {
				String word = strs[i];
				root = root.map.computeIfAbsent(word, c -> new TrieNode());
			}
			
			root.isEndOfWord = true;
		}
		
		public void find(TrieNode trie, int index) {
			TrieNode root = trie;
			Set<String> list = root.map.keySet();
			String[] strs = new String[list.size()];
			int idx = 0;
			for(String temp : list) {
				strs[idx++] = temp;
			}
			Arrays.sort(strs);

			String res = "";
			for(int i=0; i<index; i++) {
				res += "--";
			}
			for(String str : strs) {

				sb.append(res+str.toString()).append("\n");
				find(root.map.get(str), index+1);
			}
		}
		public void getResult() {
			System.out.println(sb.toString());
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());

		Trie root = new Trie();
		for(int i=0; i<n; i++) {
			root.insert(br.readLine());
		}
		root.find(root.root, 0);
		root.getResult();
	}

}
