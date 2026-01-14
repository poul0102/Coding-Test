package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/72411
class P72411 {

	char[] menu;
	StringBuilder sb = new StringBuilder();
	Map<String, Integer> map = new HashMap<>();

	public String[] solution(String[] orders, int[] course) {

		// 모든 주문에 대해 가능한 조합 생성
		for (String order : orders) {
			menu = order.toCharArray(); // 문자 배열로 변환
			Arrays.sort(menu);

			// course 길이별 조합 생성
			for (int len : course) {
				sb.setLength(0);
				dfs(0, len);
			}
		}

		List<String> answer = new ArrayList<>();

		// course 길이별 가장 많이 등장한 조합 찾기
		for (int len : course) {
			int max = 0;
			List<String> temp = new ArrayList<>(); // 최대 등장 조합 임시 저장

			for (String key : map.keySet()) {
				// 길이가 다르면 제외
				if (key.length() != len) continue;

				int count = map.get(key);

				// 2번 이하 등장한 조합 제외
				if (count < 2) continue;

				// 더 많이 등장한 조합 발견 시 갱신
				if (count > max) {
					max = count;
					temp.clear();
					temp.add(key);
				}
				// 등장 횟수 동일 시 함께 저장
				else if (count == max) {
					temp.add(key);
				}
			}

			answer.addAll(temp);
		}

		Collections.sort(answer);
		return answer.toArray(new String[0]);
	}

	/**
	 * DFS를 이용한 조합 생성
	 * 
	 * @param index     다음에 탐색할 메뉴의 시작 인덱스
	 * @param targetLen 만들고자 하는 조합의 길이
	 */
	void dfs(int index, int targetLen) {

		// 목표 길이에 도달하면 조합 완성
		if (sb.length() == targetLen) {
			map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
			return;
		}

		// 현재 인덱스부터 끝까지 탐색
		for (int i = index; i < menu.length; i++) {
			sb.append(menu[i]); // 현재 메뉴 추가
			dfs(i + 1, targetLen); // 다음 인덱스부터 조합 생성
			sb.deleteCharAt(sb.length() - 1); // 백트래킹: 마지막에 추가한 문자 제거
		}
	}
}