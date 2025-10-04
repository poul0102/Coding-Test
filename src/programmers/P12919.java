package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/12919
public class P12919 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		String[] seoul = {"Jane", "Kim"};
		System.out.println(sol.solution(seoul));
	}

	static class Solution {
		public String solution(String[] seoul) {
			StringBuilder answer = new StringBuilder();
			
			for (int i = 0; i < seoul.length; i++) {
				if (seoul[i].equals("Kim")) {
					answer.append("김서방은 " + i + "에 있다");
					break;
				}
			}

			return answer.toString();
		}
	}

}
