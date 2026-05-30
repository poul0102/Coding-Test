package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12946
public class P12946 {
	// 이동 기록 저장
	List<int[]> list = new ArrayList<>();

	public int[][] solution(int n) {
		// n개의 원판 이동 : 출발지(1)에서 목적지(3)까지, 보조(2)
		hanoi(n, 1, 3, 2);

		int[][] answer = new int[list.size()][2];

		for (int i = 0; i < list.size(); i++) {
			answer[i][0] = list.get(i)[0];
			answer[i][1] = list.get(i)[1];
		}

		return answer;
	}

	// n개의 원판을 from에서 to로 이동, via는 보조 역할
	void hanoi(int n, int from, int to, int via) {
		// n이 1인 경우, list 저장
		if (n == 1) {
			list.add(new int[] { from, to });
			return;
		}

		// 가장 큰 원판을 옮기기 위해 n-1개의 원판을 보조 기둥으로 이동
		hanoi(n - 1, from, via, to);

		// 가장 큰 원판 목적지로 이동
		list.add(new int[] { from, to });

		// 보조 기둥에 옮겨두었던 나머지 원판 목적지로 이동
		hanoi(n - 1, via, to, from);
	}
}
