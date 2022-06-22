package rs.ac.ni.pmf.oop3.vezbe.vezba06.calculator;

import java.util.HashSet;
import java.util.Set;
import rs.ac.ni.pmf.oop3.vezbe.vezba06.calculator.exception.CalculatorException;
import rs.ac.ni.pmf.oop3.vezbe.vezba06.calculator.exception.UnknownOperatorException;

public class PowerCalculator extends IntegerCalculator
{
	@Override
	public Set<Character> getAvailableOperations()
	{
		Set<Character> currentOperations = new HashSet<>(super.getAvailableOperations());
		currentOperations.add('^');
		return currentOperations;
	}

	@Override
	public Integer calculate() throws CalculatorException
	{
		try
		{
			return super.calculate();
		}
		catch (CalculatorException e)
		{
			if (e.getErrorCode() != CalculatorException.ErrorCode.UNKNOWN_OPERATION)
			{
				throw e;
			}

			if (operation == '^')
			{
				return (int)Math.pow(first, second);
			}
			else
			{
				throw new UnknownOperatorException("Unknown operation '" + operation + "'");
			}
		}
	}
}
