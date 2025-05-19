package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Best_Album {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    static class Node{
	        int idx;
	        String genre;
	        int plays;
	        public Node(int idx, String genre, int plays){
	            this.idx = idx;
	            this.genre = genre;
	            this.plays = plays;
	        }
	    }
	    public int[] solution(String[] genres, int[] plays) {
	        // 해시 2회 사용
	        Map<String, Integer> map = new HashMap<>();
	        Map<String, Integer> playsMap = new HashMap<>();
	        int[] answer = {};
	        String genre = "";
	        int max = 0;
	        // 장르 수 구하기
	        for(int i=0; i<genres.length; i++){
	            if(!map.containsKey(genres[i])) map.put(genres[i], map.size());
	            playsMap.put(genres[i], playsMap.getOrDefault(genres[i], 0)+plays[i]);
	        }
	        
	        Set<Entry<String, Integer>> entry = new HashSet<>(playsMap.entrySet());
	        List<Entry<String, Integer>> list = new ArrayList<>();
	        for(Entry<String, Integer> e : entry){
	            list.add(e);
	        }
	        
	        Collections.sort(list, new Comparator<Entry<String, Integer>>(){
	            @Override
	            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2){
	                return o2.getValue()-o1.getValue();
	            }
	        });

	        for(int i=0; i<list.size(); i++){
	            map.put(list.get(i).getKey(), i);
	        }
	        // 장르 수 구하기 -> 각 장르별 재생 수 구하기 -> 장르 내 많이 재생된 노래 수록(인덱스) -> 같은 재생수는 고유번호 낮은 노래.
	        List<List<Node>> musicList = new ArrayList<>();
	        for(int i=0; i<map.size(); i++){
	            musicList.add(new ArrayList<>());
	        }
	        for(int i=0; i<genres.length; i++){
	            int code = map.get(genres[i]);
	            musicList.get(code).add(new Node(i, genres[i], plays[i]));
	        }
	        int idx = 0;
	        List<Integer> res = new ArrayList<>();
	        for(int i=0; i<musicList.size(); i++){
	            Collections.sort(musicList.get(i), new Comparator<Node>(){
	                @Override
	                public int compare(Node o1, Node o2){
	                    return o2.plays==o1.plays ? o1.idx-o2.idx : o2.plays-o1.plays;
	                }
	            });
	            for(int j=0; j<(musicList.get(i).size()>=2 ? 2 : 1); j++){
	                res.add(musicList.get(i).get(j).idx);
	            }
	        }
	        answer = new int[res.size()];
	        for(int i=0; i<res.size(); i++){
	            answer[i] = res.get(i);
	        }
	        
	        return answer;
	    }
	}
}
