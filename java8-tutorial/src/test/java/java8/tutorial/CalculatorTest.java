package java8.tutorial;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

import com.codedok.java8.tutorial.ch01.BasicCalculator;
import com.codedok.java8.tutorial.ch01.Calculator;

public class CalculatorTest {

    Calculator calculator = Calculator.getInstance();

    @Test
    public void shouldAddTwoNumbers() throws Exception {
        int sum = calculator.add(1, 2);
        assertThat(sum, is(equalTo(3)));
    }

    @Test
    public void shouldSubtractTwoNumbers() throws Exception {
        int difference = calculator.subtract(3, 2);
        assertThat(difference, is(equalTo(1)));
    }

    @Test
    public void shouldDivideTwoNumbers() throws Exception {
        int quotient = calculator.divide(4, 2);
        assertThat(quotient, is(equalTo(2)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenDivisorIsZero() throws Exception {
        calculator.divide(4, 0);
    }

    @Test
    public void shouldMultiplyTwoNumbers() throws Exception {
        int product = calculator.multiply(3, 4);
        assertThat(product, is(equalTo(12)));
    }

    @Test
    public void shouldFindRemainderOfTwoNumbers() throws Exception {
        int remainder = calculator.remainder(100, 19);
        assertThat(remainder, is(equalTo(5)));

    }
	@Test
	public void testCalculator() {
		Calculator calculator = new BasicCalculator();
		int sum = calculator.add(1, 2);
		Assert.assertEquals(sum, 3);

		BasicCalculator cal = new BasicCalculator();
		int difference = cal.subtract(3, 2);
		Assert.assertEquals(difference, 1);
		
		
	}

}
