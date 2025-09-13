package programmers;

public class P12926 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		String s1 = "AB";
		int n1 = 1;
		System.out.println(sol.solution(s1, n1));
		
		String s2 = "z";
        int n2 = 1;
        System.out.println(sol.solution(s2, n2));

        String s3 = "a B z";
        int n3 = 4;
        System.out.println(sol.solution(s3, n3));
	}

	static class Solution {
		public String solution(String s, int n) {
			StringBuilder answer = new StringBuilder();

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);

				if (Character.isUpperCase(c)) {
					char shifted = (char)('A' + (c -'A' + n) % 26);
					answer.append(shifted);
				} else if (Character.isLowerCase(c)) {
					char shifted = (char)('a' + (c -'a' + n) % 26);
					answer.append(shifted);
				} else {
					answer.append(c);
				}

			}

			return answer.toString();
		}
	}

}
