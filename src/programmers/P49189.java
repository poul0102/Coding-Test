package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/49189
public class P49189 {
	
	List<List<Integer>> graph = new ArrayList<>();
	int[] dist;

	public int solution(int n, int[][] edge) {
		int answer = 0;

		// n+1 크기로 초기화(1 ~ n 노드까지 사용)
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		// 양방향 그래프 구성
		for (int[] node : edge) {
			int a = node[0];
			int b = node[1];
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		// 거리 배열 초기화 (-1은 방문하지 않았음을 의미)
		dist = new int[n + 1];
		Arrays.fill(dist, -1);

		bfs(1);

		// 가장 먼 거리 찾기
		int max = 0;
		for (int d : dist) {
			max = Math.max(max, d);
		}

		// 가장 멀리 떨어진 노드 개수 카운트
		for (int d : dist) {
			if (d == max) answer++;
		}

		return answer;
	}

	// 시작 노드부터 최단 거리 계산
	void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();

		// 시작 노드 큐에 넣고 거리 0으로 설정
		q.add(start);
		dist[start] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			// 현재 노드와 연결된 노드 탐색
			for (int next : graph.get(cur)) {
				if (dist[next] == -1) {
					dist[next] = dist[cur] + 1;
					q.add(next);
				}
			}
		}

		return;
	}
}
