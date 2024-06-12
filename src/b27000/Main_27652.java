package b27000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_27652 {

	// 지금 필요한 것.
	// 같은 원소 a 라도 다른 단어에 속한 a 일 수 있음.
	// <aba, a>->
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
		public Trie() {
			root = new TrieNode();
		}
		public void insert(String word, boolean isPrefix) {
			TrieNode cur = root;
			cur = cur.map.computeIfAbsent(word, c -> new TrieNode());
			
			if(isPrefix) {
				for(int i=0; i<word.length(); i++) {
					cur = cur.map.computeIfAbsent(word.substring(i, i+1), c -> new TrieNode());
				}
			}else {
				for(int i=word.length()-1; i>=0; i--) {
					cur = cur.map.computeIfAbsent(word.substring(i, i+1), c -> new TrieNode());
				}
			}
			
			cur.isEndOfWord = true;
		}
		public void delete(String word) {
			root.map.remove(word);
		}
		public int find(String prefix, boolean isPrefix) {
			TrieNode cur = root;
			int count = 0;
			for(String a : cur.map.keySet()) {
				if(!a.contains(prefix)) continue;
//				System.out.println("key 값 :                                                " +a);
				TrieNode sub = root.map.get(a);
				boolean flag = true;
				if(isPrefix) {
					if(a.startsWith(prefix)) count++;
//					for(int i=0; i<prefix.length(); i++) {
//						String substr = prefix.substring(i, i+1);
//						if((!cur.isEndOfWord && sub.map.get(substr)==null) || !a.substring(i, i+1).equals(substr)) {
//
//							flag = false;
//							break;
//						}
//						sub = sub.map.get(substr);
//					}
//					if(flag) count++;
				}else {
					if(a.endsWith(prefix)) count++;
//					for(int i=0; i<prefix.length(); i++) {
//						String substr = prefix.substring(prefix.length()-i-1, prefix.length()-i);
//						if((!cur.isEndOfWord && sub.map.get(substr)==null) || !a.substring(a.length()-i-1, a.length()-i).equals(substr)) {
//							flag = false;
//							break;
//						}
//
//						sub = sub.map.get(substr);
//					}
//					if(flag) count++;
				}
				
			}
			return count;
		}

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Trie a = new Trie();
		Trie b = new Trie();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			String oper = st.nextToken();
			
			if(oper.equals("find")) {
				int res = 0;
				String word = st.nextToken();
				for(int j=1; j<word.length(); j++) {
					int resA = a.find(word.substring(0, j), true);
					int resB = b.find(word.substring(j, word.length()), false);
					res += resA*resB;
				}
				sb.append(res).append("\n");
			}else {
				String obj = st.nextToken();
				String word = st.nextToken();
				if(oper.equals("add")) { 
					if(obj.equals("A")) a.insert(word, true);
					else b.insert(word, false);
				}else {
					if(obj.equals("A")) a.delete(word);
					else b.delete(word);
				}
			}
			
			
		
		}
		System.out.println(sb.toString());
	}

}
