package programmers;

import java.util.*;

/*
 * 1. bfs를 활용한 석유량 계산 및 id 부여
 * 2. Map을 활용해 각 id의 석유 크기 저장
 * 3. 각 열 탐색
 * 4. HashSet을 활용해 중복 제거
 * 5. 크기 계산
 */

public class P250136 {
	int[][] land;
	int n, m;
	boolean[][] visited;
	int[] dx = { -1, 1, 0, 0 };
	int[] dy = { 0, 0, -1, 1 };
	int count; // 석유량
	int id = 2; // 각 석유 덩어리 id (빈 땅 : 0, 석유가 있는 땅 : 1이기 때문에 2부터 시작)

	public int solution(int[][] land) {
		this.land = land;
		n = land.length;
		m = land[0].length;
		visited = new boolean[n][m];

		// <석유 덩어리 id, 석유량>
		Map<Integer, Integer> oilSize = new HashMap<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (land[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					oilSize.put(id, count);
					id++;
				}
			}
		}

		int answer = 0;

		// 각 열 탐색
		for (int col = 0; col < m; col++) {
			// 현재 열과 연결된(시추관이 지나는) id 저장
			// 같은 id를 여러 번 만나더라도 한 번만 저장하기 위해 HashSet 사용
			Set<Integer> set = new HashSet<>();

			for (int row = 0; row < n; row++) {
				// id가 부여된 석유 덩어리인 경우
				if (land[row][col] >= 2) {
					set.add(land[row][col]);
				}
			}

			int sum = 0;

			// 현재 열과 연결된(시추관이 지나는) 석유 덩어리 크기 계산
			for (int oilId : set) {
				sum += oilSize.get(oilId);
			}

			answer = Math.max(answer, sum);
		}

		return answer;
	}

	// 석유량 계산 및 id 부여
	void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		count = 0;

		q.add(new int[] { a, b });
		visited[a][b] = true;
		land[a][b] = id;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			count++;
			int x = cur[0];
			int y = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (visited[nx][ny]) continue;
				if (land[nx][ny] == 0) continue;

				visited[nx][ny] = true;
				land[nx][ny] = id;
				q.offer(new int[] { nx, ny });
			}
		}
	}
}
