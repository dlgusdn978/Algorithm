package programmers;

import java.util.HashMap;
import java.util.Map;

public class Autocomplete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
	    
	    class TrieNode{
	        Map<Character, TrieNode> map;
	        boolean isEndOfWord;
	        public TrieNode(){
	            map = new HashMap<>();
	            isEndOfWord = false;
	        }
	    }
	    class Trie{
	        TrieNode root;
	        public Trie(){
	            root = new TrieNode();
	        }
	    
	        public void insert(String word){
	            TrieNode node = root;
	            for(int i=0; i<word.length(); i++){
	                char ch = word.charAt(i);
	                if(node.map.containsKey(ch)) node.map.get(ch).isEndOfWord = true;
	                node.map.computeIfAbsent(ch, k -> new TrieNode());
	                
	                node = node.map.get(ch);
	                if(i==word.length()-1) node.isEndOfWord = true;
	            }
	        }
	        public int find(String word){
	            TrieNode node = root;
	            int cnt = 0;
	            int temp = 0;
	            for(int i=0; i<word.length(); i++){
	                char ch = word.charAt(i);

	                node = node.map.get(ch);           
	                if(node.isEndOfWord) cnt++;
	            }
	            return cnt;
	        }
	    }
	    public int solution(String[] words) {
	        int answer = 0;
	        Trie trie = new Trie();
	        for(int i=0; i<words.length; i++){
	            trie.insert(words[i]);
	        }
	        for(int i=0; i<words.length; i++){
	            int res = trie.find(words[i]);
	            System.out.println(res);
	            answer+=res;
	        }
	        return answer;
	    }
	}
}
