package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/87946
public class P87946 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(sol.solution(80, new int[][] { { 80, 20 }, { 50, 40 }, { 30, 10 } })); // 3
	}

	static class Solution {

		// 탐험 가능한 최대 던전 수를 저장할 변수
		static int answer = 0;

		public int solution(int k, int[][] dungeons) {
			boolean[] isSelected = new boolean[dungeons.length]; // 던전 탐험 여부
			dfs(dungeons, isSelected, 0, k);
			return answer;
		}

		public static void dfs(int[][] dungeons, boolean[] isSelected, int count, int k) {
			answer = Math.max(answer, count);

			// 모든 던전에 대해 탐색
			for (int i = 0; i < dungeons.length; i++) {
				// 아직 탐험하지 않았고, 현재 피로도로 입장 가능한 던전이라면
				if (!isSelected[i] && dungeons[i][0] <= k) {
					// 탐험 완료로 표시
					isSelected[i] = true;
					// 해당 던전을 탐험했으므로 count는 1증가, 피로도는 해당 던전의 소모 피로도만큼 감소
					dfs(dungeons, isSelected, count + 1, k - dungeons[i][1]);
					// 백트래킹: 다른 경우의 수를 위해 탐험 여부 되돌리기
					isSelected[i] = false;
				}
			}
		}
	}

}
