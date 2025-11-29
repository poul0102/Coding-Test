package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/136798
public class P136798 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		System.out.println(sol.solution(5, 3, 2));
		System.out.println(sol.solution(10, 3, 2));
	}

	static class Solution {
		public int solution(int number, int limit, int power) {
			int answer = 0;
			int[] count = new int[number];	// 약수의 개수 저장 배열

			// 약수 개수 계산
			for (int i = 1; i <= number; i++) {
				int cnt = 1;	// 자기 자신은 항상 포함
				
				//  속도 개선을 위해 1 ~ i/2까지 검사 (i를 제외한 약수들은 i/2 이하에 존재)
				for (int j = 1; j < i / 2 + 1; j++) {
					if (i % j == 0) {
						cnt++;
					}
				}
				count[i - 1] = cnt;
			}

			// 결과 계산
			for (int i = 0; i < count.length; i++) {
				answer += (count[i] > limit) ? power : count[i];
			}

			return answer;
		}
	}

}
