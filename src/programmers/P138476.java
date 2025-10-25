package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/138476
public class P138476 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		System.out.println(sol.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
		System.out.println(sol.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
		System.out.println(sol.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
	}

	static class Solution {
		public int solution(int k, int[] tangerine) {
			int answer = 0;

			// map을 활용해 각 크기별 갯수 확인
			Map<Integer, Integer> map = new HashMap<>();
			for (int i : tangerine) {
				map.put(i, map.getOrDefault(i, 0) + 1);
			}

			// map의 value값을 list에 넣기
			// 방법 1
//			List<Integer> list = new ArrayList<>();
//			for (int value : map.values()) {
//				list.add(value);
//			}
			
			// 방법 2
			List<Integer> list = new ArrayList<>(map.values());

			Collections.sort(list, Collections.reverseOrder());	// 갯수를 내림차순으로 정렬

			int tan = 0;
			for (int i : list) {
				if (tan >= k) break;
				tan += i;
				answer++;
			}

			return answer;
		}
	}

}
