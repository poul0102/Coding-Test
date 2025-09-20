package programmers;

public class P68935 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();

		int n1 = 45;
		System.out.println(sol.solution(n1));

		int n2 = 125;
		System.out.println(sol.solution(n2));
	}

	static class Solution {
		public int solution(int n) {
			// 방법 1
//			int answer = 0;
//			StringBuilder str = new StringBuilder();
//
//			// 앞뒤 반전(3진법) 만들기
//			while (n > 0) {
//				str.append(n % 3);
//				n /= 3;
//			}
//
//			// 10진법으로 표현
//			int pow = 1;
//			for (int i = str.length() - 1; i >= 0; i--) {
//				answer += (str.charAt(i) - '0') * pow;
//				pow *= 3;
//			}
//
//			return answer;

			// 방법 2
			StringBuilder str = new StringBuilder();

			// 앞뒤 반전(3진법) 만들기
			while (n > 0) {
				str.append(n % 3);
				n /= 3;
			}

			return Integer.parseInt(str.toString(), 3); // Integer.parseInt를 활용해 진수 변환
		}
	}

}
