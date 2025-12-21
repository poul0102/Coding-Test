package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/42860
public class P42860 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		System.out.println(sol.solution("JEROEN"));
		System.out.println(sol.solution("JAN"));
	}

	static class Solution {
		public int solution(String name) {
			int answer = 0;

			// 알파벳 조작
			for (int i = 0; i < name.length(); i++) {
				char c = name.charAt(i);
				// 위로 이동 vs 아래로 이동
				answer += Math.min(c - 'A', 'Z' - c + 1);
			}

			// 커서 이동
			int move = name.length() - 1;	// 디폴트 값은 오른쪽으로 끝까지 가는 경우

			for (int i = 0; i < name.length(); i++) {
				int next = i + 1;

				// A가 연속되는 구간 확인
				while (next < name.length() && name.charAt(next) == 'A') {
					next++;
				}

				// 오른쪽으로 이동 A 연속구간까지 + 다시 돌아오기 + 끝에서 next까지 
				move = Math.min(move, i * 2 + (name.length() - next));
				// 끝에서 next까지 + 다시 돌아오기 + 처음에서 A 연속구간까지
				move = Math.min(move, i + (name.length() - next) * 2);
			}

			return answer + move;
		}
	}

}
