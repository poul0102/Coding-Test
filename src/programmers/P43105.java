package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/43105
public class P43105 {
	public int solution(int[][] triangle) {
		int answer = 0;
		int n = triangle.length;
		int[][] dp = new int[n][n];

		// 시작점
		dp[0][0] = triangle[0][0];

		for (int i = 1; i < n; i++) {
			// 왼쪽 끝
			dp[i][0] = dp[i - 1][0] + triangle[i][0];
			for (int j = 1; j <= i; j++) {
				if (j == i) {
					// 오른쪽 끝
					dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
				} else {
					// 가운데
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
				}
			}
		}

		// 최댓값 찾기
		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, dp[n - 1][i]);
		}

		return answer;
	}
}
