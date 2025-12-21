package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/42862
public class P42862 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(sol.solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 }));
		System.out.println(sol.solution(5, new int[] { 2, 4 }, new int[] { 3 }));
		System.out.println(sol.solution(3, new int[] { 3 }, new int[] { 1 }));
	}

	static class Solution {
		public int solution(int n, int[] lost, int[] reserve) {
			int answer = 0;
			int[] clothes = new int[n];

			// 도난 체육복
			for (int student : lost) {
				clothes[student - 1]--;
			}

			// 여벌 체육복
			for (int student : reserve) {
				clothes[student - 1]++;
			}

			for (int i = 0; i < n; i++) {
				// 체육복을 도난 당한 경우
				if (clothes[i] == -1) {
					// 앞번호 학생에게 빌린 경우
					if (i > 0 && clothes[i - 1] == 1) {
						clothes[i]++;
						clothes[i - 1]--;
					}
					// 뒷번호 학생에게 빌린 경우
					else if (i < n - 1 && clothes[i + 1] == 1) {
						clothes[i]++;
						clothes[i + 1]--;
					}
				}
			}

			// 수업을 들을 수 있는 학생의 수
			for (int i = 0; i < n; i++) {
				if (clothes[i] >= 0) {
					answer++;
				}
			}
			return answer;
		}
	}

}
