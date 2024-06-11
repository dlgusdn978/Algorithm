package b5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_5670 {

	static class TrieNode{
		Map<Character, TrieNode> map;
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
		
		public void insert(String word) {
			TrieNode cur = root;
			for(char ch : word.toCharArray()) {
				cur = cur.map.computeIfAbsent(ch, c->new TrieNode());
			}
			cur.isEndOfWord = true;
		}
		// endofword = true, 단어의 끝.
		public int search(String word) {
			TrieNode cur = root;
			int count = 0;
			for(int i=0; i<word.length(); i++) {
				if(i==0) {
					count++;
					cur = cur.map.get(word.charAt(i));
					continue;
				}
				int size = cur.map.size();
				boolean flag = cur.isEndOfWord;
				cur = cur.map.get(word.charAt(i));
				if(size>1 || flag) count++;
				
//				cur = cur.map.get(word.charAt(i));
				
			}
			return count;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 검색하는 글자의 마지막 글자 이전 => 단어 자동 완성
		// abcdef -> abcde를 abcdef로.
		// 두번째 글자부터 추론 시작.
		// 두번째 글자부터 map의 size가 1이라면 자동으로 글자 추가.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = "";
		while((str = br.readLine()) != null) {
			// 글자 개수
			int num = Integer.parseInt(str);
			List<String> list = new ArrayList<>();
			
			Trie root = new Trie();
			for(int i=0; i<num; i++) {
				String word = br.readLine();
				list.add(word);
				root.insert(word);
			}
			double sum = 0.0;
			for(int i=0; i<list.size(); i++) {
				sum += root.search(list.get(i));
			}
			System.out.printf("%.2f", sum/list.size());
			System.out.println();
		}
	}

}
