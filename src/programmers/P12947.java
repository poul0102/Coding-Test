package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/12947
public class P12947 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		System.out.println(sol.solution(10));
		System.out.println(sol.solution(12));
		System.out.println(sol.solution(11));
		System.out.println(sol.solution(13));
	}

	static class Solution {
		public boolean solution(int x) {
			boolean answer = true;
//			int sum = 0;
//			int n = x;
//			
//			// 각 자릿수 합 구하기(1)
//			while(n > 0) {
//				sum += n % 10;
//				n /= 10;
//			}
			
			// 각 자릿수 합 구하기(2)
			String[] number = String.valueOf(x).split("");
			int sum = 0;
			for(String num : number) {
				sum += Integer.parseInt(num);
			}
			
			answer = x % sum == 0 ? true : false;
			
			return answer;
		}
	}

}
