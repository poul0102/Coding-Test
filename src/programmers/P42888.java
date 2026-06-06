package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42888
public class P42888 {
	public String[] solution(String[] record) {
		List<String> answer = new ArrayList<>(); // 결과 저장 리스트
		Map<String, String> map = new HashMap<>(); // uid와 닉네임 매핑

		StringTokenizer st;

		// 각 uid의 최종 닉네임 저장
		for (String r : record) {
			st = new StringTokenizer(r);
			String com = st.nextToken();
			String uid = st.nextToken();

			// Enter or Change 명령인 경우 map 추가 or 갱신
			if (com.equals("Enter") || com.equals("Change")) {
				String nickname = st.nextToken();
				map.put(uid, nickname);
			}
		}

		// 최종 닉네임을 바탕으로 메시지 생성
		for (String r : record) {
			st = new StringTokenizer(r);
			String com = st.nextToken();
			String uid = st.nextToken();

			if (com.equals("Enter")) {
				answer.add(map.get(uid) + "님이 들어왔습니다.");
			} else if (com.equals("Leave")) {
				answer.add(map.get(uid) + "님이 나갔습니다.");
			}
		}

		return answer.toArray(new String[0]);
	}
}
