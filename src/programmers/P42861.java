package programmers;

import java.util.*;

public class P42861 {
	// 인접 리스트 ([연결된 노드, 비용])
	List<List<int[]>> graph = new ArrayList<>();
	boolean[] visited;
	int answer = 0;

	public int solution(int n, int[][] costs) {
		// 그래프 초기화
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		// 양방향 그래프 구성
		for (int[] cost : costs) {
			int s = cost[0];
			int e = cost[1];
			int c = cost[2];

			graph.get(s).add(new int[] { e, c });
			graph.get(e).add(new int[] { s, c });
		}

		visited = new boolean[n]; // 방문 여부 확인
		bfs(0); // 0번 노드부터 확인

		return answer;
	}

	void bfs(int start) {
		// 가장 적은 비용부터 확인하기 위한 우선순위 큐
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

		// 시작 노드 (비용 0)
		pq.add(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int node = cur[0];
			int cost = cur[1];

			if (visited[node]) continue;

			visited[node] = true; // 방문 처리
			answer += cost; // 비용 누적

			// 다음 노드 확인
			for (int[] next : graph.get(node)) {
				if (!visited[next[0]]) {
					pq.add(next);
				}
			}
		}
	}
}
