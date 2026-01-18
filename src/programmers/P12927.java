package programmers;

import java.util.*;

public class P12927 {
	public long solution(int n, int[] works) {
		long answer = 0;
		
		// 큰 숫자가 우선순위가 높게
		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		// 우선순위 큐에 works 삽입
		for (int work : works) {
			pq.offer(work);
		}

		// n시간 동안 큰 작업부터 1씩 감소
		while (n > 0 && !pq.isEmpty()) {
			int work = pq.poll() - 1;
			// 감소 후에도 작업량이 남아 있으면 다시 큐에 삽입
			if (work > 0) pq.offer(work);
			n--;
		}

		// 결과 계산
		while (!pq.isEmpty()) {
			answer += Math.pow(pq.poll(), 2);
		}

		return answer;
	}
}
