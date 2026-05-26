package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/468379
public class P468379 {
	public int[] solution(int m, int n, int h, int w, int[][] drops) {
		int[] answer = new int[2];

		int[][] map = new int[m][n];

		// 비가 오지 않는 칸은 매우 큰 값으로 처리하기 위한 초기화
		for (int i = 0; i < m; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
		}

		// 비 내린 순서 기록
		int idx = 1;
		for (int[] drop : drops) {
			map[drop[0]][drop[1]] = idx++;
		}

		// 길이 w 구간의 최소값 저장을 위한 배열
		int[][] rowMin = new int[m][n - w + 1];

		// 각 행에서 길이 w 구간의 최소값 구하기
		for (int i = 0; i < m; i++) {
			// 최소 후보 인덱스 저장을 위한 Deque
			Deque<Integer> dq = new ArrayDeque<>();

			for (int j = 0; j < n; j++) {
				// 현재 값이 Deque의 맨 뒤의 값보다 더 작거나 같은 경우
				while (!dq.isEmpty() && map[i][dq.peekLast()] >= map[i][j]) {
					// Deque의 맨 뒤의 값은 최소가 될 가능성이 없기에 제거
					dq.pollLast();
				}

				// 현재 인덱스 추가
				dq.offerLast(j);

				// 현재 윈도우 범위를 벗어난 인덱스 제거
				if (dq.peekFirst() <= j - w) {
					dq.pollFirst();
				}

				// 길이 w 구간 완성 시 최소값 저장
				if (j >= w - 1) {
					rowMin[i][j - w + 1] = map[i][dq.peekFirst()];
				}
			}
		}

		int best = -1;
		int bestR = 0;
		int bestC = 0;

		// rowMin에서 길이 h 구간의 최소값 구하기
		for (int j = 0; j < n - w + 1; j++) {
			// 세로 최소값용 Deque
			Deque<Integer> dq = new ArrayDeque<>();

			for (int i = 0; i < m; i++) {
				// 현재 값이 Deque의 맨 뒤의 값보다 더 작거나 같은 경우
				while (!dq.isEmpty() && rowMin[dq.peekLast()][j] >= rowMin[i][j]) {
					// Deque의 맨 뒤의 값은 최소가 될 가능성이 없기에 제거
					dq.pollLast();
				}

				// 현재 행(인덱스) 추가
				dq.offerLast(i);

				// 현재 윈도우(세로) 범위 밖 제거
				if (dq.peekFirst() <= i - h) {
					dq.pollFirst();
				}

				// (세로) 길이 h 구간 완성 시
				if (i >= h - 1) {
					int value = rowMin[dq.peekFirst()][j]; // 현재 사각형 최소값
					int sr = i - h + 1; // 현재 사각형 시작 행
					int sc = j; // 현재 사각형 시작 열

					// 더 늦게 비 맞는 경우 갱신 (value가 클수록, 같다면 더 위쪽, 더 왼쪽)
					if (value > best || (value == best && sr < bestR || (sr == bestR && sc < bestC))) {
						best = value;
						bestR = sr;
						bestC = sc;
					}
				}
			}
		}

		answer[0] = bestR;
		answer[1] = bestC;

		return answer;
	}
}
