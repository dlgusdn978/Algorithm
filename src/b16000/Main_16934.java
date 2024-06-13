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
		
		public int insert(String word) {
			TrieNode cur = root;
			int count = 0;
			for(char ch : word.toCharArray()) {
				if(cur.map.get(ch)==null) count++;
				cur = cur.map.computeIfAbsent(ch, c->new TrieNode());
			}
			if(!map.containsKey(word)) {
				map.put(word, 1);
			}else {
				map.put(word, map.get(word)+1);
			}

			return count;
		}
		public boolean search(String word) {
			TrieNode cur = root;
			boolean flag = false;
			for(char ch: word.toCharArray()) {
				cur = cur.map.get(ch);
			}
			flag = cur.isEndOfWord;
			cur.isEndOfWord = true;
			return flag;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 가입한 유저의 별칭을 겹치지 않는 선에서 prefix로 따오되,
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Trie root = new Trie();
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			int res = root.insert(str);
			boolean isEndOfWord = root.search(str);
			if(res==str.length()) {
				System.out.println(str.charAt(0));
			}else if(res==0) {
				System.out.println(str+root.map.get(str));
			}else {
				if(!isEndOfWord) System.out.println(str.substring(0, str.length()));
				else System.out.println(str.substring(0, str.length()-res+1));
			}
		}

	}

}
