package programmers;

import java.util.function.Function;

// https://school.programmers.co.kr/learn/courses/30/lessons/468378
public class P468378 {
	public int solution(int[] depth, int money, Function<Integer, Integer> excavate) {
		int len = depth.length;

		// cost[i][j]
		// i ~ j 구간에서 보물을 찾기 위한 최소 비용
		int[][] cost = new int[len][len];

		// pick[i][j]
		// i ~ j 구간에서 먼저 탐색하는 최적 위치
		int[][] pick = new int[len][len];

		// 길이가 1인 구간 초기화
		for (int i = 0; i < len; i++) {
			cost[i][i] = depth[i];
			pick[i][i] = i;
		}

		// 길이가 2인 구간부터 탐색
		for (int size = 2; size <= len; size++) {
			// 구간 시작점
			for (int i = 0; i + size - 1 < len; i++) {
				// 구간 끝점
				int j = i + size - 1;

				// 최소값 갱신을 위한 초기화
				cost[i][j] = Integer.MAX_VALUE;

				// i부터 j까지 각각 먼저 탐색하는 경우 확인
				for (int k = i; k <= j; k++) {
					int leftCost = 0;
					int rightCost = 0;

					// 보물이 왼쪽에 있을 경우, i ~ k-1 구간 다시 탐색
					if (k > i) leftCost = cost[i][k - 1];

					// 보물이 오른쪽에 있을 경우, k+1 ~ j 구간 다시 탐색
					if (k < j) rightCost = cost[k + 1][j];

					// 현재 k를 파는 비용 + 왼쪽/오른쪽 최악의 경우 비용
					int price = depth[k] + Math.max(leftCost, rightCost);

					// 더 작은 비용일 경우
					if (price < cost[i][j]) {
						cost[i][j] = price; // 최소 비용 저장
						pick[i][j] = k; // 첫 탐색 위치 저장
					}
				}
			}
		}

		// 실제 탐색 시작 범위
		int left = 0;
		int right = len - 1;

		while (left <= right) {
			// 현재 구간에서 최적으로 탐색해야 하는 위치
			int mid = pick[left][right];

			int res = excavate.apply(mid + 1);

			// 보물을 찾는 경우
			if (res == 0) return mid + 1;
			// 보물이 왼쪽에 있는 경우
			else if (res < 0) right = mid - 1;
			// 보물이 오른쪽에 있는 경우
			else left = mid + 1;
		}

		return 0;
	}
}
