package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/43238
public class P43238 {
	public long solution(int n, int[] times) {
		long answer = 0;

		long left = 1; // 최소 시간
		long right = 0; // 최대 시간
		for (int t : times) {
			right = Math.max(right, t);
		}
		right *= n;

		// 이진 탐색
		while (left <= right) {
			long mid = (left + right) / 2; // 중간 시간

			long x = 0; // mid 시간 동안 처리 가능한 총 인원
			for (int t : times) {
				x += mid / t;
			}

			// 처리 가능 인원 n명 이상 -> 시간 충분
			if (x >= n) {
				answer = mid; // 현재 시간을 정답 후보로 저장
				right = mid - 1; // 더 짧은 시간 탐색
			} else {
				// 처리 가능 인원 부족 -> 시간 부족
				left = mid + 1; // 시간 늘리기
			}
		}

		return answer;
	}
}
