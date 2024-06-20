package b16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_16903 {

	static class TrieNode{
		TrieNode[] node = new TrieNode[2];
		public TrieNode() {

		}
	}
	static class Trie{
		TrieNode root;
		public Trie() {
			root = new TrieNode();
		}
		public void insert(String binaryString) {
			TrieNode cur = root;
			for(char ch : binaryString.toCharArray()) {
				int bit = ch-'0';
				if(cur.node[bit]==null) {
					cur.node[bit] = new TrieNode();
				}
				cur = cur.node[bit];
			}
			
		}
		public void delete(String binaryString) {
			delete(root, binaryString, 0);
		}
		public boolean delete(TrieNode cur, String binaryString, int depth) {
			if(depth == binaryString.length()) return true;
			int bit = binaryString.charAt(depth)-'0';
			if(cur.node[bit]==null || !delete(cur.node[bit], binaryString, depth+1)) {
				return false;
			}
			cur.node[bit] = null;
			return cur.node[0]==null && cur.node[1]==null;
		}
		// 1110
		public String xorOper(String binaryString) {
			TrieNode cur = root;
			StringBuilder sb = new StringBuilder();
			for(char ch: binaryString.toCharArray()) {
				int  bit = ch-'0';
				if(cur.node[1-bit]!=null) {
					sb.append('1');
					cur = cur.node[1-bit];
				}else {
					sb.append('0');
					cur = cur.node[bit];
				}
			}
		
			return sb.toString();
		}
	}
	static String toBinaryString(int num) {
		return String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0');
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Trie root = new Trie();
		root.insert(toBinaryString(0));
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int oper = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(oper==1) root.insert(toBinaryString(num));
			else if(oper==2) root.delete(toBinaryString(num));
			else {
				String xorRes = root.xorOper(toBinaryString(num));
				sb.append(Integer.parseInt(xorRes,2)).append("\n");
			}
		}
		System.out.println(sb.toString());
		
	}

}
