package b14000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_14426 {

	static class TrieNode{
		Map<Character, TrieNode> children;
		boolean isEndedWord;
		public TrieNode() {
			children = new HashMap<>();
			isEndedWord = false;
		}
		
	}
	static class Trie{
		private TrieNode root;
		public Trie() {
			root = new TrieNode();
		}
		public void insert(String word) {
			TrieNode cur = root;
			for(char ch : word.toCharArray()) {
				cur = cur.children.computeIfAbsent(ch, c -> new TrieNode());
			}
			cur.isEndedWord = true;
		}
		public boolean search(String word) {
			TrieNode cur = root;
			for(char ch : word.toCharArray()) {
				cur = cur.children.get(ch);
				if(cur==null) {
					return false;
				}
			}
			return cur.isEndedWord;
		}
		public boolean startsWith(String prefix) {
			TrieNode cur = root;
			for(char ch : prefix.toCharArray()) {
				cur = cur.children.get(ch);
				if(cur==null) {
					return false;
				}
			}
			return true;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Trie root = new Trie();
		
		for(int i=0; i<n; i++) {
			root.insert(br.readLine());
		}
		int count = 0;
		for(int i=0; i<m; i++) {
			if(root.startsWith(br.readLine())) count++;
		}
		System.out.println(count);
	}

}
