package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/12920
public class P12920 {
	public int solution(int n, int[] cores) {
		int answer = 0;

		// n이 코어 개수보다 작거나 같을 경우
		// 처음 시작 시 모든 코어가 동시에 작업하므로 n번째 코어가 마지막 작업 수행
		if (n <= cores.length)
			return n;

		// 이분 탐색 범위 설정
		long left = 0;
		long right = 250_000_000;
		long time = 0;

		// n번째 작업이 끝나는 시간 찾기(이분탐색)
		while (left <= right) {
			long mid = (left + right) / 2;

			// mid 시간까지 처리된 작업 수
			long work = cores.length; // 처음에 코어 개수만큼 작업 시작
			for (int core : cores) {
				work += mid / core;
			}

			// n개 이상 처리 가능 시 시간 줄이기
			if (work >= n) {
				time = mid;
				right = mid - 1;
			} else { // 부족하면 시간 늘리기
				left = mid + 1;
			}
		}

		// time - 1까지 처리된 작업 수 계산
		long workBefore = cores.length;
		for (int core : cores) {
			workBefore += (time - 1) / core;
		}

		// time 시점에 작업이 끝나는 코어 확인
		for (int i = 0; i < n; i++) {

			// time에 해당 코어의 작업이 끝나는 경우
			if (time % cores[i] == 0) {
				workBefore++;

				// n번째 작업이 배정되는 순간
				if (workBefore == n) {
					answer = i + 1;
					break;
				}
			}
		}

		return answer;
	}
}
