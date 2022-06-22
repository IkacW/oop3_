package rs.ac.ni.pmf.oop3.vezbe.vezba06.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import rs.ac.ni.pmf.oop3.vezbe.vezba06.calculator.exception.CalculatorException;

class IntegerCalculatorTest
{
	@Test
	public void shouldComputeSum() throws CalculatorException
	{
		IntegerCalculator calculator = new IntegerCalculator();
		calculator.addOperand(3);
		calculator.addOperand(5);
		calculator.setOperation('+');

		assertThat(calculator.calculate()).isEqualTo(8);
	}

	@Test
	public void shouldThrowWhenNoOperands() throws CalculatorException
	{
		IntegerCalculator calculator = new IntegerCalculator();
		calculator.setOperation('+');

		assertThatThrownBy(() -> calculator.calculate())
			.isInstanceOf(CalculatorException.class);
	}
}
