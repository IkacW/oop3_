package rs.ac.ni.pmf.oop3.vezbe.vezba06.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import rs.ac.ni.pmf.oop3.vezbe.vezba06.calculator.exception.CalculatorException;

class PowerCalculatorTest
{
	@Test
	public void shouldComputePower() throws CalculatorException
	{
		PowerCalculator powerCalculator = new PowerCalculator();
		powerCalculator.addOperand(2);
		powerCalculator.addOperand(4);
		powerCalculator.setOperation('^');

		assertThat(powerCalculator.calculate()).isEqualTo(16);
	}
}
