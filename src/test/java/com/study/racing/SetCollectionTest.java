package com.study.racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Set Collection에 대한 학습 테스트")
public class SetCollectionTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("numbers 크기를 확인하는 테스트")
	public void case_1() {
		assertThat(numbers).hasSize(3);
	}

	@Test
	void contains() {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}

	@DisplayName("numbers 입력 값이 존재하는지 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	public void case_2(int value) {
		assertThat(numbers.contains(value)).isTrue();
	}

	@DisplayName("입력 값에 따라 다른 반환값 테스트 하기")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	public void case_3(int value, boolean rtnValue) {
		assertThat(numbers.contains(value)).isEqualTo(rtnValue);
	}
}
