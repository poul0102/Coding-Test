package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/131127
public class P131127 {
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		
		// 시작 날짜 선택
		for (int i = 0; i < discount.length - 9; i++) {
			int j;
			
			// 원하는 상품 j 하나씩 검사
			for (j = 0; j < want.length; j++) {
				int count = 0;
				
				// 10일 구간을 돌면서 개수 세기 
				for (int k = i; k < i + 10; k++) {
					if (discount[k].equals(want[j])) count++;
				}
				
				// 원하는 수량보다 적으면 break
				if (count < number[j]) break;
			}
			
			// 원하는 상품 수량이 맞으면(반복문이 끝까지 돌면) answer++
			if (j == want.length) answer++; 
		}
		
		return answer;
	}
}
