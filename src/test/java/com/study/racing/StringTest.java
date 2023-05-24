package com.study.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("\uD83D\uDE80String 클래스에 대한 학습 테스트 - 1단계")
class StringTest {

	private static final String regex = ",";

	@Test
	@DisplayName("','를 기준으로 문자열을 분리하는 테스트")
	public void case_1_1() {
		String testStr = "1,2";
		String[] strings = testStr.split(regex);

		// 값 일치
		assertThat(strings).contains("1", "2");
	}

	@Test
	@DisplayName("','를 기준으로 문자열을 분리하고 '1'을 포함한 배열인지 확인하는 테스트")
	public void case_1_2() {
		String testStr = "1";
		String[] strings = testStr.split(regex);

		// containsExactly 순서와 값이 정확히 일치
		assertThat(strings).containsExactly("1");
	}

	@Test
	@DisplayName("문자열에서 '()'을 제거하는 테스트")
	public void case_2() {
		String testStr = "(1,2)";
		// 앞과 뒤 괄호 제거
		testStr = testStr.substring(1, testStr.length() - 1);

		// 값 일치
		assertThat(testStr).isEqualTo("1,2");
	}

	@Test
	@DisplayName("문자열에서 특정 위치의 문자를 가져올 때 위치값 오류를 확인하는 테스트")
	public void case_3() {
		String testStr = "abc";
		int idx = testStr.length();

		assertThatThrownBy(() -> testStr.charAt(idx))
				.isInstanceOf(StringIndexOutOfBoundsException.class)
				.hasMessageContaining("String index out of range")
				.hasMessageContaining(String.valueOf(idx));
	}
}