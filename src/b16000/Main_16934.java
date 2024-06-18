package b16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_16934 {

	static class TrieNode{
		Map<Character, TrieNode> map;
		boolean isEndOfWord;
		public TrieNode() {
			map = new HashMap<Character, TrieNode>();
			isEndOfWord = false;
		}
	}
	static class Trie{
		TrieNode root;
		Map<String, Integer> map;
		public Trie() {
			root = new TrieNode();
			map = new HashMap<>();
		}
		
		public int  insert(String word) {
			TrieNode cur = root;
			int count = 0;
			for(char ch : word.toCharArray()) {
				if(cur.map.containsKey(ch)) {
					count++;
				}
				cur = cur.map.computeIfAbsent(ch, c->new TrieNode());
			}
			if(!map.containsKey(word)) {
				map.put(word, 1);
			}else {
				map.put(word, map.get(word)+1);
			}

			return count;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 가입한 유저의 별칭을 겹치지 않는 선에서 prefix로 따오되,
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		Trie root = new Trie();
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			int count = root.insert(str);
			if(count<str.length()) {
//				System.out.println(str.substring(0, count+1));
				sb.append(str.substring(0, count+1)).append("\n");
			}else {
//				System.out.println(str+root.map.get(str));
				if(root.map.get(str)!=1) sb.append(str+root.map.get(str)).append("\n");
				else sb.append(str).append("\n");

			}
		}
		System.out.println(sb.toString());

	}

}
