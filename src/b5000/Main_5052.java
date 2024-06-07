package b5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main_5052 {

	static class TrieNode {
		Map<Character, TrieNode> children;
		boolean isEndOfWord;
		public TrieNode() {
			children = new HashMap<>();
			isEndOfWord = false;
		}
	}
	static class Trie{
		TrieNode root = new TrieNode();
		
		public void insert(String word) {
			TrieNode cur = root;
			for(char ch : word.toCharArray()) {
				cur = cur.children.computeIfAbsent(ch, c -> new TrieNode());
			}
			cur.isEndOfWord = true;
		}
		public boolean startsWith(String prefix) {
			TrieNode cur = root;
			int count = 0;
			for(char ch : prefix.toCharArray()) {
				cur = cur.children.get(ch);
				count++;
				if(count<prefix.length() && cur.isEndOfWord) return false;
			}
			return true;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			int n = Integer.parseInt(br.readLine());
			String[] strs = new String[n];
			Trie trie = new Trie();
			for(int i=0; i<n; i++) {
				String str = br.readLine();
				strs[i] = str;
				trie.insert(str);
			}
			boolean flag = true;
			for(int i=0; i<n; i++) {
				if(!trie.startsWith(strs[i])) flag = false;
			}
			System.out.println(flag ? "YES" : "NO");
		}

	}

}
