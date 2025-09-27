package leetcode;

// https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75
public class L345 {

	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(sol.reverseVowels("IceCreAm"));

		System.out.println(sol.reverseVowels("leetcode"));
	}

	static class Solution {
		public String reverseVowels(String s) {
			String vowels = "aeiouAEIOU"; // 모음 집합
			char[] arr = s.toCharArray();
			int left = 0;
			int right = arr.length - 1;

			while (left < right) {
				// 왼쪽에서 모음을 찾을 때까지 이동
				while (left < right && vowels.indexOf(arr[left]) == -1) {
					left++;
				}

				// 오른쪽에서 모음을 찾을 때까지 이동
				while (left < right && vowels.indexOf(arr[right]) == -1) {
					right--;
				}

				// 모음 교환
				if (left < right) {
					char temp = arr[left];
					arr[left] = arr[right];
					arr[right] = temp;
					left++;
					right--;
				}
			}

			return new String(arr);
		}
	}

}
