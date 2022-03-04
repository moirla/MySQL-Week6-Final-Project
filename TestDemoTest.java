import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import net.bytebuddy.asm.Advice.Argument;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TestDemoTest {
	
	private TestDemo testDemo = new TestDemo();
	TestDemo mockDemo = spy(testDemo);
	
	@BeforeEach
	void setUp() throws Exception {
		this.testDemo = new TestDemo();		
	}
		//Integration tests(functional tests) test all or part of an application
	
		//unit tests test methods
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
		
		if(!expectException) {
			  assert(testDemo.addPositive(a, b) == expected);
			} else {
				assertThatThrownBy(() -> testDemo.addPositive(a, b))
				.isInstanceOf(IllegalArgumentException.class);
			}
	}
		
	public static Stream<Arguments> argumentsForAddPositive()  {
		return Stream.of(arguments(2, 4, 6, false));
			
		}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		assert(fiveSquared == 25);
		
	}
		
	}


