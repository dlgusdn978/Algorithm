package b7000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main_7432 {

	static class TrieNode{
		Map<String, TrieNode> map;
		boolean isEndOfWord;
		public TrieNode() {
			map = new HashMap<>();
			isEndOfWord = false;
		}
		
	}
	static class Trie {
		TrieNode root = new TrieNode();
		StringBuilder sb = new StringBuilder();
		public void insert(String str) {
			String[] strs = str.split("\\\\");
			TrieNode cur = root;
			for(String s : strs) {
				cur = cur.map.computeIfAbsent(s, c -> new TrieNode());
			}
			cur.isEndOfWord = true;
		}

		public void searchAll(TrieNode root, int gapCount) {
			TrieNode cur = root;
			
			if(cur==null) return;
			String gap = ""; 
			for(int i=0; i<=gapCount; i++) {
				gap+=" ";
			}
			List<Entry<String, TrieNode>> list = new ArrayList<>(cur.map.entrySet());
			Collections.sort(list, new Comparator<Entry<String, TrieNode>>(){
				@Override
				public int compare(Entry<String, TrieNode> o1, Entry<String, TrieNode> o2) {
					return o1.getKey().compareTo(o2.getKey());
				}
			});
			for(int i=0; i<list.size(); i++) {
				sb.append(gap+list.get(i).getKey()).append("\n");
				searchAll(list.get(i).getValue(), gapCount+1);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		Trie root = new Trie();
		for(int i=0; i<n; i++) {
			root.insert(br.readLine());
		}
		

		root.searchAll(root.root, -1);
		System.out.println(root.sb.toString());
	}

}
