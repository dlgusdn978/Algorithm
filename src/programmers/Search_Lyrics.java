package programmers;

import java.util.HashMap;
import java.util.Map;

public class Search_Lyrics {
	static class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
            
        public void insert(String word){
            TrieNode trie = root;
            for(int i=0; i<word.length(); i++){
                String cur = word.substring(i, i+1);  
                trie.map.computeIfAbsent(cur, k -> new TrieNode());

                trie.lenMap.put(word.length(), trie.lenMap.getOrDefault(word.length(), 0)+1);
                trie = trie.map.get(cur);
                if(i==word.length()-1) trie.isEndOfWord = true;
            }
            
        }
        public int find(String word){
            int cnt = 0;
            TrieNode trie = root;
            
            for(int i=0; i<word.length(); i++){
                String s = word.substring(i, i+1);
                if(s.equals("?")){
                    cnt = trie.lenMap.get(word.length())==null ? 0 : trie.lenMap.get(word.length());
                    break;
                }else{
                    if(trie.map.containsKey(s)) trie = trie.map.get(s);
                    else break;
                }
            }
            return cnt;
        }
    }
    static class TrieNode{
        Map<String, TrieNode> map;
        Map<Integer, Integer> lenMap;
        boolean isEndOfWord;
        public TrieNode(){
            map = new HashMap<>();
            lenMap = new HashMap<>();
            isEndOfWord = false;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static String reverse(String word){
        return new StringBuilder(word).reverse().toString();
    }
	class Solution {
	    
	 
	    public int[] solution(String[] words, String[] queries) {
	        // 2. 트라이 알고리즘?
	        // 트라이 2개 사용으로 queue 제거.
	        int[] answer = new int[queries.length];
	        Trie trie = new Trie();
	        Trie reverseTrie = new Trie();
	        Map<String, Integer> map = new HashMap<>();
	        for(int i=0; i<words.length; i++){
	            trie.insert(words[i]);
	            reverseTrie.insert(reverse(words[i]));
	        }
	        for(int i=0; i<queries.length; i++){
	            // if(map.containsKey(queries[i])) answer[i] = map.get(queries[i]);
	            // else {
	                if(queries[i].substring(0, 1).equals("?")) answer[i] = reverseTrie.find(reverse(queries[i]));
	                else answer[i] = trie.find(queries[i]);
	                // map.put(queries[i], answer[i]);
	            // }
	        }
	        // System.out.println(Arrays.toString(answer));
	        return answer;
	    }
	}
}
