import java.util.*;
public class kakao_3 {
	static Map<String, List<Integer>> hm = new HashMap<>();;
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		int[] answer = solution2(info, query);
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	static int[] solution2(String[] info, String[] query) {
		int[] answer = new int[query.length];
		
		for(int i=0; i<info.length; i++) {
			String[] infos = info[i].split(" ");			
			dfs("", infos, 0);
		}
		
		for(String set : hm.keySet()) {			
			List<Integer> list = hm.get(set);
			Collections.sort(list);
		}
		
		for(int i=0; i<query.length; i++) {
			String[] parts = query[i].split(" ");
			String key = parts[0]+parts[2]+parts[4]+parts[6];


			int score = Integer.parseInt(parts[7]);
			if(hm.containsKey(key) == false ) {
				answer[i] = 0;
			}else {
				List<Integer> list = hm.get(key);
				int end = list.size()-1;
				int start = 0;
				while(start <= end) {
					int mid = (start + end) / 2;
					if(list.get(mid) < score) {
						start = mid +1;
					}else {
						end = mid-1;
					}
				}
				answer[i] = list.size() - start;
			}
			
		}
		
		return answer;
	}
	
	static void dfs(String str, String[] infos, int depth) {
		if(depth == 4) {
			int score = Integer.parseInt(infos[4]);
			if(hm.containsKey(str)) {
				hm.get(str).add(score);
			}else {
				List<Integer> list = new ArrayList<>();
				list.add(score);
				hm.put(str, list);
			}
			return;
		}
		dfs(str+"-", infos, depth+1);
		dfs(str+infos[depth], infos, depth+1);
	}
	
	
	static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		String[] languages = new String[info.length];
		String[] ends = new String[info.length];
		String[] careers = new String[info.length];
		String[] soulFoods = new String[info.length];
		int[] scores = new int[info.length];
		for(int i=0; i<info.length; i++) {
			String participant = info[i];
			String[] parts = participant.split(" ");
			languages[i] = parts[0];
			ends[i] = parts[1];
			careers[i] = parts[2];
			soulFoods[i] = parts[3];
			scores[i] = Integer.valueOf(parts[4]);			
		}
		
		for(int i=0; i<query.length; i++) {
			String standard = query[i];
			String[] stans = standard.split(" ");
			String language = stans[0];
			String end = stans[2];
			String career = stans[4];
			String soulFood = stans[6];
			int score = Integer.valueOf(stans[7]);
			int count = 0;
			for(int j=0; j<info.length; j++) {
				
				if(language.equals("-") || language.equals(languages[j])) {
					if(end.equals("-") || end.equals(ends[j])) {
						if(career.equals("-") || career.equals(careers[j])) {
							if(soulFood.equals("-") || soulFood.equals(soulFoods[j])) {
								if(scores[j] >= score) {
									count++;
								}
							}
						}
					}
				}
			}
			answer[i] = count;
		}
		
		return answer;
	}
}
